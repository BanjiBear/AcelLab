package io.acellab.service.web.startline.Service.Company;


import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.acellab.service.web.startline.Config.Security.CustomUserDetails;
import io.acellab.service.web.startline.Config.Security.CustomUserDetailsService;
import io.acellab.service.web.startline.Entity.CompanyFundingInfo;
import io.acellab.service.web.startline.Entity.CompanyInfo;
import io.acellab.service.web.startline.Entity.CompanyProductInfo;
import io.acellab.service.web.startline.Entity.UserInfo;
import io.acellab.service.web.startline.Repository.CompanyFundingRepository;
import io.acellab.service.web.startline.Repository.CompanyProductRepository;
import io.acellab.service.web.startline.Repository.CompanyRepository;
import io.acellab.service.web.startline.Repository.UserRepository;
import io.acellab.service.web.startline.Status.ResponseFactory;
import io.acellab.service.web.startline.Status.Status;
import io.acellab.service.web.startline.Util.Util;

@Service("CompanyService")
public class CompanyServiceImpl implements CompanyService {
	
	@Autowired
	CustomUserDetailsService customUserDetailsService;
	
	@Autowired
	private CompanyRepository companyRepository;
	
	@Autowired
	private CompanyProductRepository companyProductRepository;
	
	@Autowired
	private CompanyFundingRepository companyFundingRepository;
	
	@Autowired
	private UserRepository userRepository;

	@Override
	@Transactional
	public ResponseFactory<CompanyInfo> getCompaniesList() {
		ArrayList<CompanyInfo> companiesList = new ArrayList<>();
		
		try{
			companiesList = companyRepository.getAllCompany();
		} catch(Exception e) {
			return Util.responseFormation(Status.UNEXPECTED_ERROR, companiesList);
		}
		return Util.responseFormation(Status.RESULT_FOUND, companiesList);
	}

	@Override
	public ResponseFactory<CompanyInfo> searchCompanies(String companyName, String location, String industry, String fundingRound, String bookmark) {
		ArrayList<CompanyInfo> companiesList = new ArrayList<>();
		
		try {
			if(!bookmark.equals("") && bookmark != null) {
				// get company from user
			} else {
				if(!Util.isValidSearchInput(companyName)) {
					return Util.responseFormation(Status.COMPANY_SEARCH_INVALID_INPUT, companiesList);
				}
				companiesList = companyRepository.getCompaniesBySearchParams(companyName, location, industry, fundingRound);
			}
		} catch (Exception e) {
			return Util.responseFormation(Status.UNEXPECTED_ERROR, companiesList);
		}
		
		if(companiesList.size() == 0) {
			return Util.responseFormation(Status.NO_RESULT_FOUND_ERROR, companiesList);
		}
		return Util.responseFormation(Status.RESULT_FOUND, companiesList);
	}

	
	
	@Override
	public <T> ResponseFactory<T> addCompanyToBookmark(@AuthenticationPrincipal UserDetails userDetails, Long userId, Long companyId) {
		
		Optional<UserInfo> user = userRepository.findById(userId);
		Optional<CompanyInfo> company = companyRepository.getCompanyById(companyId);
		
		//get Current user details
		CustomUserDetails customUserDetails = (CustomUserDetails) userDetails;
		UserInfo current_user = customUserDetails.getUser();
		
		if(user.isEmpty() || company.isEmpty()) return Util.responseFormation(Status.SECURITY_INVALID_OPERATION_CREATE_BOOKMARK_INVLAID_ID);
		if(current_user.getUserId() != user.get().getUserId()) return Util.responseFormation(Status.SECURITY_INVALID_OPERATION_CREATE_BOOKMARK_NOT_CURRENT_USER);
		
		ArrayList<Long> bookmarks = new ArrayList<Long>();
		bookmarks = companyRepository.getBookmarkListByUserId(userId);
		if(bookmarks.size() == 0 || !bookmarks.contains(companyId)) {
			try {
				companyRepository.addBookmarkByUserIdAndCompanyId(userId, companyId);
			} catch(Exception e) {
				return Util.responseFormation(Status.UNEXPECTED_ERROR);
			}
		}
		return Util.responseFormation(Status.DATA_UPDATED);
	}

	
	@Override
	public ResponseFactory<Object> getCompanyDetails(Long companyId) {
		Object[] companyObjects = new Object[4];
		// [CompanyInfo, CompanyProductInfo, CompanyFundingInfo, CompanyTeamInfo]
		try {
			Optional<CompanyInfo> company = companyRepository.getCompanyById(companyId);
			if(company.isEmpty()) {
				return Util.responseFormation(Status.NO_RESULT_FOUND_ERROR);
			}
			companyObjects[0] = company.get();
			
			ArrayList<CompanyProductInfo> products = new ArrayList<CompanyProductInfo>();
			products = companyProductRepository.getCompanyProductsByCompanyId(companyId);
			companyObjects[1] = products;
			
			ArrayList<CompanyFundingInfo> fundings = new ArrayList<CompanyFundingInfo>();
			fundings = companyFundingRepository.getCompanyFundingsByCompanyId(companyId);
			companyObjects[2] = fundings;
		} catch(Exception e) {
			return Util.responseFormation(Status.UNEXPECTED_ERROR);
		}
		
		return Util.responseFormation(Status.RESULT_FOUND, companyObjects);
	}
	
	@Override
	public ResponseFactory<CompanyInfo> getBookmarks(UserInfo user) {
		ArrayList<CompanyInfo> companies = new ArrayList<CompanyInfo>();
		
		try {
			Long user_id = user.getUserId();
			companies = companyRepository.getBookmarkCompanyListByUserID(user_id);
		} catch(Exception e) {
			return Util.responseFormation(Status.UNEXPECTED_ERROR, companies);
		}
		
		return Util.responseFormation(Status.RESULT_FOUND, companies);
	}

	@Override
	public ResponseFactory<Long> getBookmarkedCompanyID(UserInfo user) {
		ArrayList<Long> companyIDs = new ArrayList<Long>();
		
		try {
			Long user_id = user.getUserId();
			companyIDs = companyRepository.getBookmarkCompanyIDsByUserID(user_id);
		} catch(Exception e) {
			return Util.responseFormation(Status.UNEXPECTED_ERROR, companyIDs);
		}
		
		return Util.responseFormation(Status.RESULT_FOUND, companyIDs);
	}

	@Override
	public <T> ResponseFactory<T> deleteBookmark(UserInfo user, Long companyId) {
		
		try {
			Long user_id = user.getUserId();
			companyRepository.deleteBookmarkByUserIDAndCompanyID(user_id, companyId);
		} catch(Exception e) {
			return Util.responseFormation(Status.UNEXPECTED_ERROR);
		}
		
		return Util.responseFormation(Status.DATA_DELETED);
	}

}
