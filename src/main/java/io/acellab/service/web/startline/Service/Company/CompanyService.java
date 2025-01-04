package io.acellab.service.web.startline.Service.Company;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;

import io.acellab.service.web.startline.Entity.CompanyInfo;
import io.acellab.service.web.startline.Entity.UserInfo;
import io.acellab.service.web.startline.Status.ResponseFactory;

public interface CompanyService {
		
	public ResponseFactory<CompanyInfo> getCompaniesList();
	
	public ResponseFactory<CompanyInfo> searchCompanies(String companyName, String location, String industry, String fundingRound, String bookmark);
	
	public <T> ResponseFactory<T> addCompanyToBookmark(@AuthenticationPrincipal UserDetails userDetails, Long userId, Long companyId);
	
	public ResponseFactory<Object> getCompanyDetails(Long companyId);

	public ResponseFactory<CompanyInfo> getBookmarks(UserInfo user);

	public ResponseFactory<Long> getBookmarkedCompanyID(UserInfo user);

	public <T> ResponseFactory<T> deleteBookmark(UserInfo user, Long companyId);
	
}
