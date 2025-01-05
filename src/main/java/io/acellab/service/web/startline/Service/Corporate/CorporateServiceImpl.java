package io.acellab.service.web.startline.Service.Corporate;


import java.lang.reflect.Method;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.acellab.service.web.startline.Config.Security.CustomUserDetails;
import io.acellab.service.web.startline.Config.Security.CustomUserDetailsService;
import io.acellab.service.web.startline.Entity.CompanyInfo;
import io.acellab.service.web.startline.Entity.CorporateFundingInfo;
import io.acellab.service.web.startline.Entity.CorporateInfo;
import io.acellab.service.web.startline.Entity.CorporateProductInfo;
import io.acellab.service.web.startline.Entity.CorporateTeamInfo;
import io.acellab.service.web.startline.Entity.UserInfo;
import io.acellab.service.web.startline.Repository.CompanyRepository;
import io.acellab.service.web.startline.Repository.CorporateFundingRepository;
import io.acellab.service.web.startline.Repository.CorporateProductRepository;
import io.acellab.service.web.startline.Repository.CorporateRepository;
import io.acellab.service.web.startline.Repository.CorporateTeamRepository;
import io.acellab.service.web.startline.Repository.UserRepository;
import io.acellab.service.web.startline.Status.ResponseFactory;
import io.acellab.service.web.startline.Status.Status;
import io.acellab.service.web.startline.Util.OneTimePasswordGenerator;
import io.acellab.service.web.startline.Util.Util;

@Service("CorporateService")
public class CorporateServiceImpl implements CorporateService {
	
	@Autowired
	CustomUserDetailsService customUserDetailsService;
	
	@Autowired
	private CorporateRepository corporateRepository;
	
	@Autowired
	private CorporateProductRepository corporateProductRepository;
	
	@Autowired
	private CorporateFundingRepository corporateFundingRepository;
	
	@Autowired
	private CorporateTeamRepository corporateTeamRepository;
	
	@Autowired
	private UserRepository userRepository;


	@Override
	public ResponseFactory<CorporateInfo> getUserCorporate(UserInfo user) {
		ArrayList<CorporateInfo> return_list = new ArrayList<CorporateInfo>();
		try {
			if(user.getCorporate() == null) {
				CorporateInfo Corporate = new CorporateInfo();
				return_list.add(Corporate);
			} else {
				return_list.add(user.getCorporate());
			}
		} catch(Exception e) {
			return Util.responseFormation(Status.UNEXPECTED_ERROR);
		}
		
		return Util.responseFormation(Status.RESULT_FOUND, return_list);
	}
	
	
	@Override
	public ResponseFactory<CorporateProductInfo> getCorporateProducts(UserInfo user) {
		ArrayList<CorporateProductInfo> products = new ArrayList<CorporateProductInfo>();
		try {
			if(user.getCorporate() != null) {
				products = corporateProductRepository.getCorporateProductsByCorporateId(user.getCorporate().getId());
			}
		} catch(Exception e) {
			e.printStackTrace();
			return Util.responseFormation(Status.UNEXPECTED_ERROR);
		}
		
		return Util.responseFormation(Status.RESULT_FOUND, products);
	}


	@Override
	public ResponseFactory<CorporateFundingInfo> getCorporateFundings(UserInfo user) {
		ArrayList<CorporateFundingInfo> fundings = new ArrayList<CorporateFundingInfo>();
		try {
			if(user.getCorporate() != null) {
				fundings = corporateFundingRepository.getCorporateFundingsByCorporateId(user.getCorporate().getId());
			}
		} catch(Exception e) {
			return Util.responseFormation(Status.UNEXPECTED_ERROR);
		}
		
		return Util.responseFormation(Status.RESULT_FOUND, fundings);
	}
	
	@Override
	public ResponseFactory<CorporateTeamInfo> getCorporateTeam(UserInfo user) {
		ArrayList<CorporateTeamInfo> members = new ArrayList<CorporateTeamInfo>();
		try {
			if(user.getCorporate() != null) {
				members = corporateTeamRepository.getCorporateTeamByCorporateId(user.getCorporate().getId());
			}
		} catch(Exception e) {
			return Util.responseFormation(Status.UNEXPECTED_ERROR);
		}
		
		return Util.responseFormation(Status.RESULT_FOUND, members);
	}
	
	
	@Override
	public <T> ResponseFactory<T> updateUserCorporate(@AuthenticationPrincipal UserDetails userDetails, UserInfo user, Map<String, String> corporateInfoMap) {
		
		/************************
		 *                      * 
		 * Check Valid UserInfo *
		 *                      *  
		 ************************/
		CustomUserDetails customUserDetails = (CustomUserDetails) userDetails;
		UserInfo current_user = customUserDetails.getUser();
		if(current_user.getUserId() != user.getUserId()) return Util.responseFormation(Status.SECURITY_INVALID_OPERATION_UPDATE_ORG_NOT_CURRENT_USER);
		
		CorporateInfo corporate = null;
		if(user.getCorporate() != null) {
			// Update CorporateInfo
			corporate = user.getCorporate();
		} else {
			// Construct CorporateInfo
			corporate = new CorporateInfo();
		}
		
		
		/*************************
		 *                       * 
		 * Process CorporateInfo *
		 *                       *  
		 *************************/
		
		// Check for input format
		if(!Util.isValidOrgUpdateNameFormat(corporateInfoMap.get("Name"))) {
			return Util.responseFormation(Status.UPDATE_ORG_INVALID_ORG_NAME_FORMAT);
		}
		if(corporateInfoMap.get("Phone").indexOf('-') == -1) {
			return Util.responseFormation(Status.UNEXPECTED_ERROR);
		} else {
			String phone = corporateInfoMap.get("Phone");
			phone = phone.substring(corporateInfoMap.get("Phone").indexOf('-') + 1);
			if(!Util.isValidOrgUpdatePhoneFormat(phone)) {
				return Util.responseFormation(Status.UPDATE_ORG_INVALID_ORG_PHONE_FORMAT);
			}
		}
		if(!Util.isValidOrgUpdateSizeFormat(corporateInfoMap.get("Size"))) {
			return Util.responseFormation(Status.UPDATE_ORG_INVALID_ORG_SIZE_FORMAT);
		}
		corporate.setCorporateName(corporateInfoMap.get("Name"));
		corporate.setIntroduction(corporateInfoMap.get("Introduction"));
		corporate.setEmail1(corporateInfoMap.get("Email"));
		corporate.setPhone(corporateInfoMap.get("Phone"));
		corporate.setWebsite(corporateInfoMap.get("Website"));
		corporate.setCorporateSize(corporateInfoMap.get("Size"));
		corporate.setFoundYear(Integer.valueOf(corporateInfoMap.get("Year")));
		corporate.setIndustry(corporateInfoMap.get("Industry"));
		corporate.setHeadquarter(corporateInfoMap.get("Headquarter"));
		try {
			Class<?> clazz = CorporateInfo.class;
			for (int i = 0; i < 10; i++) {
				String setTagsName = "setTag" + i;
				Method method = clazz.getMethod(setTagsName, String.class);
				if(corporateInfoMap.containsKey("tag"+i)) {
					method.invoke(corporate, corporateInfoMap.get("tag"+i));
				} else {
					method.invoke(corporate, "");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			return Util.responseFormation(Status.UNEXPECTED_ERROR);
		}
		CorporateInfo updatedCorporate = corporateRepository.save(corporate);
		
		
		/******************************
		 *                            * 
		 * Process CorporateProductInfo *
		 *                            *  
		 ******************************/
		Map<String, Long> inputProductIDMap = new HashMap<String, Long>();
		
		List<CorporateProductInfo> createCPlist = new ArrayList<CorporateProductInfo>();
		List<CorporateProductInfo> updateCPlist = new ArrayList<CorporateProductInfo>();
		List<CorporateProductInfo> deleteCPlist = new ArrayList<CorporateProductInfo>();
		
		List<CorporateProductInfo> finalProductList = new ArrayList<CorporateProductInfo>();
		
		try {
			// Setting up intermediate objects for products updating
			for (String key : corporateInfoMap.keySet()) {
				if (key.trim().contains("Product Name")) {
					if(!Util.isValidOrgUpdateProductNameFormat(corporateInfoMap.get(key))) {
						return Util.responseFormation(Status.UPDATE_ORG_INVALID_PRODUCT_NAME_FORMAT);
					}
				} else if(key.trim().contains("Product ID")) {
					inputProductIDMap.put(key, Long.parseLong(corporateInfoMap.get(key)));
				}
			}
			
			// Check for existing products
			if(user.getCorporate() != null) {
				List<CorporateProductInfo> products = corporateProductRepository.getCorporateProductsByCorporateId(corporate.getId());
				for(int i = 0; i < products.size(); i++) {
					if(!inputProductIDMap.containsValue(products.get(i).getId())) {
						deleteCPlist.add(products.get(i));
					} else {
						for(String key : inputProductIDMap.keySet()) {
							if(inputProductIDMap.get(key) == products.get(i).getId()) {
								products.get(i).setCorporate(updatedCorporate);
								products.get(i).setProductName(corporateInfoMap.get("Product Name " + key.replace("Product ID ", "")));
								products.get(i).setProductDescription(corporateInfoMap.get("Product Desc " + key.replace("Product ID ", "")));
								break;
							}
						}
						updateCPlist.add(products.get(i));
					}
				}
			}
			// Create new product
			for(String key : inputProductIDMap.keySet()) {
				if(inputProductIDMap.get(key) == -1) {
					CorporateProductInfo newproduct = new CorporateProductInfo();
					newproduct.setCorporate(updatedCorporate);
					newproduct.setProductName(corporateInfoMap.get("Product Name " + key.replace("Product ID ", "")));
					newproduct.setProductDescription(corporateInfoMap.get("Product Desc " + key.replace("Product ID ", "")));
					createCPlist.add(newproduct);
				}
			}
			
			// Database updates
			corporateProductRepository.deleteAll(deleteCPlist);
			Iterable<CorporateProductInfo> updatedlist = corporateProductRepository.saveAll(updateCPlist);
			Iterable<CorporateProductInfo> createdlist = corporateProductRepository.saveAll(createCPlist);
			
			// CorporateInfo entity updates
			for(CorporateProductInfo product : updatedlist) {
				finalProductList.add(product);
			}
			for(CorporateProductInfo product : createdlist) {
				finalProductList.add(product);
			}
			updatedCorporate.setProducts(null);
			updatedCorporate.setProducts(finalProductList);
		} catch(Exception e) {
			e.printStackTrace();
			return Util.responseFormation(Status.UNEXPECTED_ERROR);
		}
		
		
		/******************************
		 *                            * 
		 * Process CorporateFundingInfo *
		 *                            *  
		 ******************************/
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Map<String, Long> inputFundingIDMap = new HashMap<String, Long>();
		
		List<CorporateFundingInfo> createCFlist = new ArrayList<CorporateFundingInfo>();
		List<CorporateFundingInfo> updateCFlist = new ArrayList<CorporateFundingInfo>();
		List<CorporateFundingInfo> deleteCFlist = new ArrayList<CorporateFundingInfo>();
		
		List<CorporateFundingInfo> finalFundingList = new ArrayList<CorporateFundingInfo>();
		
		try {
			// Setting up intermediate objects for products updating
			for (String key : corporateInfoMap.keySet()) {
				if (key.trim().contains("Amount")) {
					if(!Util.isValidOrgUpdateFundingAmountFormat(corporateInfoMap.get(key))) {
						return Util.responseFormation(Status.UPDATE_ORG_INVALID_FUNDING_AMOUNT_FORMAT);
					}
				} else if (key.trim().contains("Investors")) {
					if(!Util.isValidOrgUpdateInvestorsFormat(corporateInfoMap.get(key))) {
						return Util.responseFormation(Status.UPDATE_ORG_INVALID_INVESTORS_FORMAT);
					}
				} else if(key.trim().contains("Funding ID")) {
					inputFundingIDMap.put(key, Long.parseLong(corporateInfoMap.get(key)));
				}
			}
			
			// Check for existing fundings
			if(user.getCorporate() != null) {
				List<CorporateFundingInfo> fundings = corporateFundingRepository.getCorporateFundingsByCorporateId(corporate.getId());
				for(int i = 0; i < fundings.size(); i++) {
					if(!inputFundingIDMap.containsValue(fundings.get(i).getId())) {
						deleteCFlist.add(fundings.get(i));
					} else {
						for(String key : inputFundingIDMap.keySet()) {
							if(inputFundingIDMap.get(key) == fundings.get(i).getId()) {
								fundings.get(i).setCorporate(updatedCorporate);
								fundings.get(i).setFundingDate(dateFormat.parse(corporateInfoMap.get("Funidng Date " + key.replace("Funding ID ", ""))));
								fundings.get(i).setFundingRound(corporateInfoMap.get("Round " + key.replace("Funding ID ", "")));
								fundings.get(i).setFundingAmount(corporateInfoMap.get("Amount " + key.replace("Funding ID ", "")));
								fundings.get(i).setFundingInvestors(corporateInfoMap.get("Investors " + key.replace("Funding ID ", "")));
								break;
							}
						}
						updateCFlist.add(fundings.get(i));
					}
				}
			}
			// Create new product
			for(String key : inputFundingIDMap.keySet()) {
				if(inputFundingIDMap.get(key) == -1) {
					CorporateFundingInfo newfunding = new CorporateFundingInfo();
					newfunding.setCorporate(updatedCorporate);
					newfunding.setFundingDate(dateFormat.parse(corporateInfoMap.get("Funidng Date " + key.replace("Funding ID ", ""))));
					newfunding.setFundingRound(corporateInfoMap.get("Round " + key.replace("Funding ID ", "")));
					newfunding.setFundingAmount(corporateInfoMap.get("Amount " + key.replace("Funding ID ", "")));
					newfunding.setFundingInvestors(corporateInfoMap.get("Investors " + key.replace("Funding ID ", "")));
					createCFlist.add(newfunding);
				}
			}
			
			// Database updates
			corporateFundingRepository.deleteAll(deleteCFlist);
			Iterable<CorporateFundingInfo> updatedlist = corporateFundingRepository.saveAll(updateCFlist);
			Iterable<CorporateFundingInfo> createdlist = corporateFundingRepository.saveAll(createCFlist);
			
			// CorporateInfo entity updates
			for(CorporateFundingInfo funding : updatedlist) {
				finalFundingList.add(funding);
			}
			for(CorporateFundingInfo funding : createdlist) {
				finalFundingList.add(funding);
			}
			updatedCorporate.setFundings(null);
			updatedCorporate.setFundings(finalFundingList);
		} catch(Exception e) {
			e.printStackTrace();
			return Util.responseFormation(Status.UNEXPECTED_ERROR);
		}
		
		
		/***************************
		 *                         * 
		 * Process CorporateTeamInfo *
		 *                         *  
		 ***************************/
		Map<String, Long> inputTeamIDMap = new HashMap<String, Long>();
		
		List<CorporateTeamInfo> createCTlist = new ArrayList<CorporateTeamInfo>();
		List<CorporateTeamInfo> updateCTlist = new ArrayList<CorporateTeamInfo>();
		List<CorporateTeamInfo> deleteCTlist = new ArrayList<CorporateTeamInfo>();
		
		List<CorporateTeamInfo> finalTeamList = new ArrayList<CorporateTeamInfo>();
		
		try {
			// Setting up intermediate objects for products updating
			for (String key : corporateInfoMap.keySet()) {
				if (key.trim().contains("Member Name")) {
					if(!Util.isValidOrgUpdateMemberNameFormat(corporateInfoMap.get(key))) {
						return Util.responseFormation(Status.UPDATE_ORG_INVALID_MEMBER_NAME_FORMAT);
					}
				} else if (key.trim().contains("Member Dept")) {
					if(!Util.isValidOrgUpdateMemberDeptFormat(corporateInfoMap.get(key))) {
						return Util.responseFormation(Status.UPDATE_ORG_INVALID_MEMBER_DEPT_FORMAT);
					}
				} else if (key.trim().contains("Member Pos")) {
					if(!Util.isValidOrgUpdateMemberPosFormat(corporateInfoMap.get(key))) {
						return Util.responseFormation(Status.UPDATE_ORG_INVALID_MEMBER_POS_FORMAT);
					}
				} else if (key.trim().contains("Member Phone")) {
					if(corporateInfoMap.get(key).indexOf('-') == -1) {
						return Util.responseFormation(Status.UNEXPECTED_ERROR);
					} else {
						String phone = corporateInfoMap.get(key);
						phone = phone.substring(corporateInfoMap.get(key).indexOf('-') + 1);
						if(!Util.isValidOrgUpdateMemberPhoneFormat(phone)) {
							return Util.responseFormation(Status.UPDATE_ORG_INVALID_MEMBER_PHONE_FORMAT);
						}
					}
				} else if(key.trim().contains("Member ID")) {
					inputTeamIDMap.put(key, Long.parseLong(corporateInfoMap.get(key)));
				}
			}
			
			// Check for existing team members
			if(user.getCorporate() != null) {
				List<CorporateTeamInfo> members = corporateTeamRepository.getCorporateTeamByCorporateId(corporate.getId());
				for(int i = 0; i < members.size(); i++) {
					if(!inputTeamIDMap.containsValue(members.get(i).getId())) {
						deleteCTlist.add(members.get(i));
					} else {
						for(String key : inputTeamIDMap.keySet()) {
							if(inputTeamIDMap.get(key) == members.get(i).getId()) {
								members.get(i).setCorporate(updatedCorporate);
								members.get(i).setName(corporateInfoMap.get("Member Name " + key.replace("Member ID ", "")));
								members.get(i).setDepartment(corporateInfoMap.get("Member Dept " + key.replace("Member ID ", "")));
								members.get(i).setRole(corporateInfoMap.get("Member Pos " + key.replace("Member ID ", "")));
								members.get(i).setEmail(corporateInfoMap.get("Member Email " + key.replace("Member ID ", "")));
								members.get(i).setPhone(corporateInfoMap.get("Member Phone " + key.replace("Member ID ", "")));
								members.get(i).setLinkedin(corporateInfoMap.get("Member LinkedIn " + key.replace("Member ID ", "")));
								break;
							}
						}
						updateCTlist.add(members.get(i));
					}
				}
			}
			// Create new member
			for(String key : inputTeamIDMap.keySet()) {
				if(inputTeamIDMap.get(key) == -1) {
					CorporateTeamInfo member = new CorporateTeamInfo();
					member.setCorporate(updatedCorporate);
					member.setName(corporateInfoMap.get("Member Name " + key.replace("Member ID ", "")));
					member.setDepartment(corporateInfoMap.get("Member Dept " + key.replace("Member ID ", "")));
					member.setRole(corporateInfoMap.get("Member Pos " + key.replace("Member ID ", "")));
					member.setEmail(corporateInfoMap.get("Member Email " + key.replace("Member ID ", "")));
					member.setPhone(corporateInfoMap.get("Member Phone " + key.replace("Member ID ", "")));
					member.setLinkedin(corporateInfoMap.get("Member LinkedIn " + key.replace("Member ID ", "")));
					createCTlist.add(member);
				}
			}
			
			// Database updates
			corporateTeamRepository.deleteAll(deleteCTlist);
			Iterable<CorporateTeamInfo> updatedlist = corporateTeamRepository.saveAll(updateCTlist);
			Iterable<CorporateTeamInfo> createdlist = corporateTeamRepository.saveAll(createCTlist);
			
			// CorporateInfo entity updates
			for(CorporateTeamInfo team : updatedlist) {
				finalTeamList.add(team);
			}
			for(CorporateTeamInfo team : createdlist) {
				finalTeamList.add(team);
			}
			updatedCorporate.setMembers(null);
			updatedCorporate.setMembers(finalTeamList);
		} catch(Exception e) {
			e.printStackTrace();
			return Util.responseFormation(Status.UNEXPECTED_ERROR);
		}
		
		
		/*********************
		 *                   * 
		 *  Update UserInfo  *
		 *                   *  
		 *********************/
		user.setCorporate(updatedCorporate);
		userRepository.save(user);
		
		return Util.responseFormation(Status.DATA_UPDATED);
	}


	@Override
	@Transactional
	public <T> ResponseFactory<T> addScheduledEmail(UserInfo user, String email, String type, Boolean payload) {
		if(!Util.isValidEmailFormat(email)) {
			return Util.responseFormation(Status.USER_REGISTER_INVALID_EMAIL_FORMAT);
		} else if(type == "INVITATION") {
			Optional<UserInfo> userinfo = userRepository.findUserByEmail(email);
			if(!userinfo.isEmpty()) {
				return Util.responseFormation(Status.EXISTING_EMAIL);
			}
		}
		
		try {
			Long user_id = user.getUserId();
			String user_firstname = user.getFirstname();
			String user_email = user.getEmail();
			String one_time_pwd = null;
			
			if(type == "INVITATION") {
				one_time_pwd = OneTimePasswordGenerator.generateRandomString();
				if(!Util.isValidPassword(one_time_pwd)) return Util.responseFormation(Status.UNEXPECTED_ERROR);
				
				// Generate new UserInfo
				Timestamp timestamp = new Timestamp(System.currentTimeMillis());
				SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
				String formattedTimestamp = sdf.format(timestamp);
				
				String username = "user_" + formattedTimestamp;
				String firstname = "User";
				String lastname = "lastname";
				userRepository.createSystemGeneratedUserFromInvitation(
						username, new BCryptPasswordEncoder().encode(one_time_pwd), firstname, lastname, email, false, 3, false, true, true, false);
				userRepository.createCollaboratorsFromInvitation(user.getUserId(), username);
			}
			
			corporateRepository.addScheduledEmailByUserId(user_id, user_firstname, user_email, email, one_time_pwd, type, false, false);
		} catch(Exception e) {
			e.printStackTrace();
			return Util.responseFormation(Status.UNEXPECTED_ERROR);
		}
		
		return Util.responseFormation(Status.NEW_DATA_CREATED);
	}


	@Override
	public ResponseFactory<UserInfo> getCollaborators(UserInfo user) {
		ArrayList<Long> collabIDs = new ArrayList<Long>();
		ArrayList<UserInfo> collaborators = new ArrayList<UserInfo>();
		
		try {
			collabIDs = userRepository.getAllCollaboratorsIDsByUserID(user.getUserId());
			Iterable<UserInfo> userInfoList = userRepository.findAllById(collabIDs);
			for(UserInfo collab : userInfoList) {
				collaborators.add(collab);
			}
		} catch(Exception e) {
			return Util.responseFormation(Status.UNEXPECTED_ERROR);
		}
		
		return Util.responseFormation(Status.RESULT_FOUND, collaborators);
	}


	@Override
	public <T> ResponseFactory<T> updateCollaboratorsInfo(UserInfo user, Map<String, String> map) {
		ArrayList<UserInfo> updatedUserList = new ArrayList<UserInfo>();
		
		if(!user.getIsAdmin()) {
			return Util.responseFormation(Status.UPDATE_COLLABORATORS_USER_NOT_ADMIN);
		}
		
		try {
			for (String key : map.keySet()) {
				if (key.trim().contains("Name")) {
					String idx = key.replace("Name ", "");
					String username = map.get(key);
					String role = map.get("Role " + idx);
					String status = map.get("Status " + idx);
					
					Optional<UserInfo> userinfo = userRepository.findUserByUsername(username);
					if(userinfo.isEmpty()) {
						return Util.responseFormation(Status.UPDATE_COLLABORATORS_USER_NOT_FOUND);
					}
					UserInfo collab = userinfo.get();
					collab.setIsAdmin("admin".equals(role));
					collab.setIsActive("Active".equals(status));
					
					updatedUserList.add(collab);
				}
			}
			userRepository.saveAll(updatedUserList);
		} catch(Exception e) {
			return Util.responseFormation(Status.UNEXPECTED_ERROR);
		}
		
		return Util.responseFormation(Status.DATA_UPDATED);
	}


}
