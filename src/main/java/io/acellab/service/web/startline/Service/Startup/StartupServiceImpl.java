package io.acellab.service.web.startline.Service.Startup;


import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.acellab.service.web.startline.Config.Security.CustomUserDetails;
import io.acellab.service.web.startline.Config.Security.CustomUserDetailsService;
import io.acellab.service.web.startline.Entity.CompanyInfo;
import io.acellab.service.web.startline.Entity.StartupFundingInfo;
import io.acellab.service.web.startline.Entity.StartupInfo;
import io.acellab.service.web.startline.Entity.StartupProductInfo;
import io.acellab.service.web.startline.Entity.StartupTeamInfo;
import io.acellab.service.web.startline.Entity.UserInfo;
import io.acellab.service.web.startline.Repository.CompanyRepository;
import io.acellab.service.web.startline.Repository.StartupFundingRepository;
import io.acellab.service.web.startline.Repository.StartupProductRepository;
import io.acellab.service.web.startline.Repository.StartupRepository;
import io.acellab.service.web.startline.Repository.StartupTeamRepository;
import io.acellab.service.web.startline.Repository.UserRepository;
import io.acellab.service.web.startline.Status.ResponseFactory;
import io.acellab.service.web.startline.Status.Status;
import io.acellab.service.web.startline.Util.Util;

@Service("StartupService")
public class StartupServiceImpl implements StartupService {
	
	@Autowired
	CustomUserDetailsService customUserDetailsService;
	
	@Autowired
	private StartupRepository startupRepository;
	
	@Autowired
	private StartupProductRepository startupProductRepository;
	
	@Autowired
	private StartupFundingRepository startupFundingRepository;
	
	@Autowired
	private StartupTeamRepository startupTeamRepository;
	
	@Autowired
	private UserRepository userRepository;


	@Override
	public ResponseFactory<StartupInfo> getUserStartup(UserInfo user) {
		ArrayList<StartupInfo> return_list = new ArrayList<StartupInfo>();
		try {
			if(user.getStartup() == null) {
				StartupInfo startup = new StartupInfo();
				return_list.add(startup);
			} else {
				return_list.add(user.getStartup());
			}
		} catch(Exception e) {
			return Util.responseFormation(Status.UNEXPECTED_ERROR);
		}
		
		return Util.responseFormation(Status.RESULT_FOUND, return_list);
	}


	@Override
	public ResponseFactory<StartupProductInfo> getStartupProducts(UserInfo user) {
		ArrayList<StartupProductInfo> products = new ArrayList<StartupProductInfo>();
		try {
			if(user.getStartup() != null) {
				products = startupProductRepository.getStartupProductsByStartupId(user.getStartup().getId());
			}
		} catch(Exception e) {
			e.printStackTrace();
			return Util.responseFormation(Status.UNEXPECTED_ERROR);
		}
		
		return Util.responseFormation(Status.RESULT_FOUND, products);
	}


	@Override
	public ResponseFactory<StartupFundingInfo> getStartupFundings(UserInfo user) {
		ArrayList<StartupFundingInfo> fundings = new ArrayList<StartupFundingInfo>();
		try {
			if(user.getStartup() != null) {
				fundings = startupFundingRepository.getStartupFundingsByStartupId(user.getStartup().getId());
			}
		} catch(Exception e) {
			return Util.responseFormation(Status.UNEXPECTED_ERROR);
		}
		
		return Util.responseFormation(Status.RESULT_FOUND, fundings);
	}
	
	@Override
	public ResponseFactory<StartupTeamInfo> getStartupTeam(UserInfo user) {
		ArrayList<StartupTeamInfo> members = new ArrayList<StartupTeamInfo>();
		try {
			if(user.getStartup() != null) {
				members = startupTeamRepository.getStartupTeamByStartupId(user.getStartup().getId());
			}
		} catch(Exception e) {
			return Util.responseFormation(Status.UNEXPECTED_ERROR);
		}
		
		return Util.responseFormation(Status.RESULT_FOUND, members);
	}


	@Override
	public <T> ResponseFactory<T> updateUserStartup(@AuthenticationPrincipal UserDetails userDetails, UserInfo user, Map<String, String> startupInfoMap) {
		
		/************************
		 *                      * 
		 * Check Valid UserInfo *
		 *                      *  
		 ************************/
		CustomUserDetails customUserDetails = (CustomUserDetails) userDetails;
		UserInfo current_user = customUserDetails.getUser();
		if(current_user.getUserId() != user.getUserId()) return Util.responseFormation(Status.SECURITY_INVALID_OPERATION_UPDATE_ORG_NOT_CURRENT_USER);
		
		StartupInfo startup = null;
		if(user.getStartup() != null) {
			// Update StartupInfo
			startup = user.getStartup();
		} else {
			// Construct StartupInfo
			startup = new StartupInfo();
		}
		
		
		/***********************
		 *                     * 
		 * Process StartupInfo *
		 *                     *  
		 ***********************/
		
		// Check for input format
		if(!Util.isValidOrgUpdateNameFormat(startupInfoMap.get("Name"))) {
			return Util.responseFormation(Status.UPDATE_ORG_INVALID_ORG_NAME_FORMAT);
		}
		if(startupInfoMap.get("Phone").indexOf('-') == -1) {
			return Util.responseFormation(Status.UNEXPECTED_ERROR);
		} else {
			String phone = startupInfoMap.get("Phone");
			phone = phone.substring(startupInfoMap.get("Phone").indexOf('-') + 1);
			if(!Util.isValidOrgUpdatePhoneFormat(phone)) {
				return Util.responseFormation(Status.UPDATE_ORG_INVALID_ORG_PHONE_FORMAT);
			}
		}
		if(!Util.isValidOrgUpdateSizeFormat(startupInfoMap.get("Size"))) {
			return Util.responseFormation(Status.UPDATE_ORG_INVALID_ORG_SIZE_FORMAT);
		}
		startup.setStartupName(startupInfoMap.get("Name"));
		startup.setIntroduction(startupInfoMap.get("Introduction"));
		startup.setEmail1(startupInfoMap.get("Email"));
		startup.setPhone(startupInfoMap.get("Phone"));
		startup.setWebsite(startupInfoMap.get("Website"));
		startup.setStartupSize(startupInfoMap.get("Size"));
		startup.setFoundYear(Integer.valueOf(startupInfoMap.get("Year")));
		startup.setIndustry(startupInfoMap.get("Industry"));
		startup.setHeadquarter(startupInfoMap.get("Headquarter"));
		try {
			Class<?> clazz = StartupInfo.class;
			for (int i = 0; i < 10; i++) {
				String setTagsName = "setTag" + i;
				Method method = clazz.getMethod(setTagsName, String.class);
				if(startupInfoMap.containsKey("tag"+i)) {
					method.invoke(startup, startupInfoMap.get("tag"+i));
				} else {
					method.invoke(startup, "");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			return Util.responseFormation(Status.UNEXPECTED_ERROR);
		}
		StartupInfo updatedStartup = startupRepository.save(startup);
		
		
		/******************************
		 *                            * 
		 * Process StartupProductInfo *
		 *                            *  
		 ******************************/
		Map<String, Long> inputProductIDMap = new HashMap<String, Long>();
		
		List<StartupProductInfo> createSPlist = new ArrayList<StartupProductInfo>();
		List<StartupProductInfo> updateSPlist = new ArrayList<StartupProductInfo>();
		List<StartupProductInfo> deleteSPlist = new ArrayList<StartupProductInfo>();
		
		List<StartupProductInfo> finalProductList = new ArrayList<StartupProductInfo>();
		
		try {
			// Setting up intermediate objects for products updating
			for (String key : startupInfoMap.keySet()) {
				if (key.trim().contains("Product Name")) {
					if(!Util.isValidOrgUpdateProductNameFormat(startupInfoMap.get(key))) {
						return Util.responseFormation(Status.UPDATE_ORG_INVALID_PRODUCT_NAME_FORMAT);
					}
				} else if(key.trim().contains("Product ID")) {
					inputProductIDMap.put(key, Long.parseLong(startupInfoMap.get(key)));
				}
			}
			
			// Check for existing products
			if(user.getStartup() != null) {
				List<StartupProductInfo> products = startupProductRepository.getStartupProductsByStartupId(startup.getId());
				for(int i = 0; i < products.size(); i++) {
					if(!inputProductIDMap.containsValue(products.get(i).getId())) {
						deleteSPlist.add(products.get(i));
					} else {
						for(String key : inputProductIDMap.keySet()) {
							if(inputProductIDMap.get(key) == products.get(i).getId()) {
								products.get(i).setStartup(updatedStartup);
								products.get(i).setProductName(startupInfoMap.get("Product Name " + key.replace("Product ID ", "")));
								products.get(i).setProductDescription(startupInfoMap.get("Product Desc " + key.replace("Product ID ", "")));
								break;
							}
						}
						updateSPlist.add(products.get(i));
					}
				}
			}
			// Create new product
			for(String key : inputProductIDMap.keySet()) {
				if(inputProductIDMap.get(key) == -1) {
					StartupProductInfo newproduct = new StartupProductInfo();
					newproduct.setStartup(updatedStartup);
					newproduct.setProductName(startupInfoMap.get("Product Name " + key.replace("Product ID ", "")));
					newproduct.setProductDescription(startupInfoMap.get("Product Desc " + key.replace("Product ID ", "")));
					createSPlist.add(newproduct);
				}
			}
			
			// Database updates
			startupProductRepository.deleteAll(deleteSPlist);
			Iterable<StartupProductInfo> updatedlist = startupProductRepository.saveAll(updateSPlist);
			Iterable<StartupProductInfo> createdlist = startupProductRepository.saveAll(createSPlist);
			
			// StartupInfo entity updates
			for(StartupProductInfo product : updatedlist) {
				finalProductList.add(product);
			}
			for(StartupProductInfo product : createdlist) {
				finalProductList.add(product);
			}
			updatedStartup.setProducts(null);
			updatedStartup.setProducts(finalProductList);
		} catch(Exception e) {
			e.printStackTrace();
			return Util.responseFormation(Status.UNEXPECTED_ERROR);
		}
		
		
		/******************************
		 *                            * 
		 * Process StartupFundingInfo *
		 *                            *  
		 ******************************/
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Map<String, Long> inputFundingIDMap = new HashMap<String, Long>();
		
		List<StartupFundingInfo> createSFlist = new ArrayList<StartupFundingInfo>();
		List<StartupFundingInfo> updateSFlist = new ArrayList<StartupFundingInfo>();
		List<StartupFundingInfo> deleteSFlist = new ArrayList<StartupFundingInfo>();
		
		List<StartupFundingInfo> finalFundingList = new ArrayList<StartupFundingInfo>();
		
		try {
			// Setting up intermediate objects for products updating
			for (String key : startupInfoMap.keySet()) {
				if (key.trim().contains("Amount")) {
					if(!Util.isValidOrgUpdateFundingAmountFormat(startupInfoMap.get(key))) {
						return Util.responseFormation(Status.UPDATE_ORG_INVALID_FUNDING_AMOUNT_FORMAT);
					}
				} else if (key.trim().contains("Investors")) {
					if(!Util.isValidOrgUpdateInvestorsFormat(startupInfoMap.get(key))) {
						return Util.responseFormation(Status.UPDATE_ORG_INVALID_INVESTORS_FORMAT);
					}
				} else if(key.trim().contains("Funding ID")) {
					inputFundingIDMap.put(key, Long.parseLong(startupInfoMap.get(key)));
				}
			}
			
			// Check for existing fundings
			if(user.getStartup() != null) {
				List<StartupFundingInfo> fundings = startupFundingRepository.getStartupFundingsByStartupId(startup.getId());
				for(int i = 0; i < fundings.size(); i++) {
					if(!inputFundingIDMap.containsValue(fundings.get(i).getId())) {
						deleteSFlist.add(fundings.get(i));
					} else {
						for(String key : inputFundingIDMap.keySet()) {
							if(inputFundingIDMap.get(key) == fundings.get(i).getId()) {
								fundings.get(i).setStartup(updatedStartup);
								fundings.get(i).setFundingDate(dateFormat.parse(startupInfoMap.get("Funidng Date " + key.replace("Funding ID ", ""))));
								fundings.get(i).setFundingRound(startupInfoMap.get("Round " + key.replace("Funding ID ", "")));
								fundings.get(i).setFundingAmount(startupInfoMap.get("Amount " + key.replace("Funding ID ", "")));
								fundings.get(i).setFundingInvestors(startupInfoMap.get("Investors " + key.replace("Funding ID ", "")));
								break;
							}
						}
						updateSFlist.add(fundings.get(i));
					}
				}
			}
			// Create new product
			for(String key : inputFundingIDMap.keySet()) {
				if(inputFundingIDMap.get(key) == -1) {
					StartupFundingInfo newfunding = new StartupFundingInfo();
					newfunding.setStartup(updatedStartup);
					newfunding.setFundingDate(dateFormat.parse(startupInfoMap.get("Funidng Date " + key.replace("Funding ID ", ""))));
					newfunding.setFundingRound(startupInfoMap.get("Round " + key.replace("Funding ID ", "")));
					newfunding.setFundingAmount(startupInfoMap.get("Amount " + key.replace("Funding ID ", "")));
					newfunding.setFundingInvestors(startupInfoMap.get("Investors " + key.replace("Funding ID ", "")));
					createSFlist.add(newfunding);
				}
			}
			
			// Database updates
			startupFundingRepository.deleteAll(deleteSFlist);
			Iterable<StartupFundingInfo> updatedlist = startupFundingRepository.saveAll(updateSFlist);
			Iterable<StartupFundingInfo> createdlist = startupFundingRepository.saveAll(createSFlist);
			
			// StartupInfo entity updates
			for(StartupFundingInfo funding : updatedlist) {
				finalFundingList.add(funding);
			}
			for(StartupFundingInfo funding : createdlist) {
				finalFundingList.add(funding);
			}
			updatedStartup.setFundings(null);
			updatedStartup.setFundings(finalFundingList);
		} catch(Exception e) {
			e.printStackTrace();
			return Util.responseFormation(Status.UNEXPECTED_ERROR);
		}
		
		
		/***************************
		 *                         * 
		 * Process StartupTeamInfo *
		 *                         *  
		 ***************************/
		Map<String, Long> inputTeamIDMap = new HashMap<String, Long>();
		
		List<StartupTeamInfo> createSTlist = new ArrayList<StartupTeamInfo>();
		List<StartupTeamInfo> updateSTlist = new ArrayList<StartupTeamInfo>();
		List<StartupTeamInfo> deleteSTlist = new ArrayList<StartupTeamInfo>();
		
		List<StartupTeamInfo> finalTeamList = new ArrayList<StartupTeamInfo>();
		
		try {
			// Setting up intermediate objects for products updating
			for (String key : startupInfoMap.keySet()) {
				if (key.trim().contains("Member Name")) {
					if(!Util.isValidOrgUpdateMemberNameFormat(startupInfoMap.get(key))) {
						return Util.responseFormation(Status.UPDATE_ORG_INVALID_MEMBER_NAME_FORMAT);
					}
				} else if (key.trim().contains("Member Dept")) {
					if(!Util.isValidOrgUpdateMemberDeptFormat(startupInfoMap.get(key))) {
						return Util.responseFormation(Status.UPDATE_ORG_INVALID_MEMBER_DEPT_FORMAT);
					}
				} else if (key.trim().contains("Member Pos")) {
					if(!Util.isValidOrgUpdateMemberPosFormat(startupInfoMap.get(key))) {
						return Util.responseFormation(Status.UPDATE_ORG_INVALID_MEMBER_POS_FORMAT);
					}
				} else if (key.trim().contains("Member Phone")) {
					if(startupInfoMap.get(key).indexOf('-') == -1) {
						return Util.responseFormation(Status.UNEXPECTED_ERROR);
					} else {
						String phone = startupInfoMap.get(key);
						phone = phone.substring(startupInfoMap.get(key).indexOf('-') + 1);
						if(!Util.isValidOrgUpdateMemberPhoneFormat(phone)) {
							return Util.responseFormation(Status.UPDATE_ORG_INVALID_MEMBER_PHONE_FORMAT);
						}
					}
				} else if(key.trim().contains("Member ID")) {
					inputTeamIDMap.put(key, Long.parseLong(startupInfoMap.get(key)));
				}
			}
			
			// Check for existing team members
			if(user.getStartup() != null) {
				List<StartupTeamInfo> members = startupTeamRepository.getStartupTeamByStartupId(startup.getId());
				for(int i = 0; i < members.size(); i++) {
					if(!inputTeamIDMap.containsValue(members.get(i).getId())) {
						deleteSTlist.add(members.get(i));
					} else {
						for(String key : inputTeamIDMap.keySet()) {
							if(inputTeamIDMap.get(key) == members.get(i).getId()) {
								members.get(i).setStartup(updatedStartup);
								members.get(i).setName(startupInfoMap.get("Member Name " + key.replace("Member ID ", "")));
								members.get(i).setDepartment(startupInfoMap.get("Member Dept " + key.replace("Member ID ", "")));
								members.get(i).setRole(startupInfoMap.get("Member Pos " + key.replace("Member ID ", "")));
								members.get(i).setEmail(startupInfoMap.get("Member Email " + key.replace("Member ID ", "")));
								members.get(i).setPhone(startupInfoMap.get("Member Phone " + key.replace("Member ID ", "")));
								members.get(i).setLinkedin(startupInfoMap.get("Member LinkedIn " + key.replace("Member ID ", "")));
								break;
							}
						}
						updateSTlist.add(members.get(i));
					}
				}
			}
			// Create new member
			for(String key : inputTeamIDMap.keySet()) {
				if(inputTeamIDMap.get(key) == -1) {
					StartupTeamInfo member = new StartupTeamInfo();
					member.setStartup(updatedStartup);
					member.setName(startupInfoMap.get("Member Name " + key.replace("Member ID ", "")));
					member.setDepartment(startupInfoMap.get("Member Dept " + key.replace("Member ID ", "")));
					member.setRole(startupInfoMap.get("Member Pos " + key.replace("Member ID ", "")));
					member.setEmail(startupInfoMap.get("Member Email " + key.replace("Member ID ", "")));
					member.setPhone(startupInfoMap.get("Member Phone " + key.replace("Member ID ", "")));
					member.setLinkedin(startupInfoMap.get("Member LinkedIn " + key.replace("Member ID ", "")));
					createSTlist.add(member);
				}
			}
			
			// Database updates
			startupTeamRepository.deleteAll(deleteSTlist);
			Iterable<StartupTeamInfo> updatedlist = startupTeamRepository.saveAll(updateSTlist);
			Iterable<StartupTeamInfo> createdlist = startupTeamRepository.saveAll(createSTlist);
			
			// StartupInfo entity updates
			for(StartupTeamInfo team : updatedlist) {
				finalTeamList.add(team);
			}
			for(StartupTeamInfo team : createdlist) {
				finalTeamList.add(team);
			}
			updatedStartup.setMembers(null);
			updatedStartup.setMembers(finalTeamList);
		} catch(Exception e) {
			e.printStackTrace();
			return Util.responseFormation(Status.UNEXPECTED_ERROR);
		}
		
		
		/*********************
		 *                   * 
		 *  Update UserInfo  *
		 *                   *  
		 *********************/
		user.setStartup(updatedStartup);
		userRepository.save(user);
		
		return Util.responseFormation(Status.DATA_UPDATED);
	}


}
