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
import io.acellab.service.web.startline.Entity.CompanyInfo;
import io.acellab.service.web.startline.Entity.UserInfo;
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

}
