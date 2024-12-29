package io.acellab.service.web.startline.Entity;


import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToMany;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;


@Entity
@Table(name = "startup")
public class StartupInfo{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;
	
	public Long getId() {return this.id;}
	
	
	
	/***************************
	 *                         *
	 *   General Information   *
	 *                         * 
	 ***************************/

	@Column(name = "startup_name", nullable = false, length = 255)
	private String startupName;
	
	@Column(name = "website", nullable = false)
	private String website;
	
	@Column(name = "logo", length = 255)
	private String logo;
	
	@Lob
	@Column(name = "introduction")
	private String introduction;
	
	@Column(name = "industry", length = 255)
	private String industry;
	
	@Column(name = "headquarter", length = 255)
	private String headquarter;
	
	@Lob
	@Column(name = "location1", length = 255)
	private String location1;
	
	@Lob
	@Column(name = "location2", length = 255)
	private String location2;
	
	@Lob
	@Column(name = "location3", length = 255)
	private String location3;
	
	@Lob
	@Column(name = "location4", length = 255)
	private String location4;
	
	@Lob
	@Column(name = "location5", length = 255)
	private String location5;
	
	@Column(name = "year_found", columnDefinition = "INTEGER")
	private Integer yearFound;
	
	@Column(name = "founders", length = 255)
	private String founders;
	
	@Column(name = "startup_size", length = 50)
	private String startupSize;
	
	@OneToMany(mappedBy = "startup")
    private List<StartupTeamInfo> members;
	
    
	public void setStartupName(String name) {this.startupName = name;}
	public String getStartupName() {return this.startupName;}
	
	public void setWebsite(String website) {this.website = website;}
	public String getWebsite() {return this.website;}
	
	public void setLogo(String path) {this.logo = path;}
	public String getLogo() {return this.logo;}
	
	public void setIntroduction(String intro) {this.introduction = intro;}
	public String getIntroduction() {return this.introduction;}
	
	public void setIndustry(String industry) {this.industry = industry;}
	public String getIndustry() {return this.industry;}
	
	public void setHeadquarter(String hq) {this.headquarter = hq;}
	public String getHeadquarter() {return this.headquarter;}
	
	public void setLocation1(String location) {this.location1 = location;}
	public String getLocation1() {return this.location1;}
	
	public void setLocation2(String location) {this.location2 = location;}
	public String getLocation2() {return this.location2;}
	
	public void setLocation3(String location) {this.location3 = location;}
	public String getLocation3() {return this.location3;}
	
	public void setLocation4(String location) {this.location4 = location;}
	public String getLocation4() {return this.location4;}
	
	public void setLocation5(String location) {this.location5 = location;}
	public String getLocation5() {return this.location5;}
	
	public void setFoundYear(Integer year) {this.yearFound = year;}
	public Integer getFoundYear() {return this.yearFound;}
	
	public void setFounders(String founders) {this.founders = founders;}
	public String getFounders() {return this.founders;}
	
	public void setStartupSize(String size) {this.startupSize = size;}
	public String getStartupSize() {return this.startupSize;}
	
	public List<StartupTeamInfo> getMembers() {return this.members;}
	public void setMembers(List<StartupTeamInfo> members) {this.members = members;}
	
	
	/**************************************************
	 *                                                *
	 *   Provision: Product, Service, and Solutions   *
	 *                                                * 
	 **************************************************/
	
	@Lob
	@Column(name = "solution")
	private String solution;
	
	@Column(name = "tag0", length = 30)
	private String tag0;
	
	@Column(name = "tag1", length = 30)
	private String tag1;
	
	@Column(name = "tag2", length = 30)
	private String tag2;
	
	@Column(name = "tag3", length = 30)
	private String tag3;
	
	@Column(name = "tag4", length = 30)
	private String tag4;
	
	@Column(name = "tag5", length = 30)
	private String tag5;
	
	@Column(name = "tag6", length = 30)
	private String tag6;

	@Column(name = "tag7", length = 30)
	private String tag7;
	
	@Column(name = "tag8", length = 30)
	private String tag8;
	
	@Column(name = "tag9", length = 30)
	private String tag9;
	
	@OneToMany(mappedBy = "startup")
    private List<StartupProductInfo> products;
	
	public void setSolution(String solution) {this.solution = solution;}
	public String getSolution() {return this.solution;}
	
	public void setTag0(String tag) {this.tag0 = tag;}
	public String getTag0() {return this.tag0;}
	
	public void setTag1(String tag) {this.tag1 = tag;}
	public String getTag1() {return this.tag1;}
	
	public void setTag2(String tag) {this.tag2 = tag;}
	public String getTag2() {return this.tag2;}
	
	public void setTag3(String tag) {this.tag3 = tag;}
	public String getTag3() {return this.tag3;}
	
	public void setTag4(String tag) {this.tag4 = tag;}
	public String getTag4() {return this.tag4;}
	
	public void setTag5(String tag) {this.tag5 = tag;}
	public String getTag5() {return this.tag5;}
	
	public void setTag6(String tag) {this.tag6 = tag;}
	public String getTag6() {return this.tag6;}
	
	public void setTag7(String tag) {this.tag7 = tag;}
	public String getTag7() {return this.tag7;}
	
	public void setTag8(String tag) {this.tag8 = tag;}
	public String getTag8() {return this.tag8;}
	
	public void setTag9(String tag) {this.tag9 = tag;}
	public String getTag9() {return this.tag9;}
	
	public List<StartupProductInfo> getProducts() {return this.products;}
	public void setProducts(List<StartupProductInfo> products) {this.products = products;}
	
	
	/***********************
	 *                     *
	 *   Contact Details   *
	 *                     * 
	 ***********************/
	
	@Column(name = "phone", length = 255)
	private String phone;
	
	@Column(name = "email1", length = 255)
	private String email1;
	
	@Column(name = "email2", length = 255)
	private String email2;
	
	@Column(name = "linkedIn_link", length = 255)
	private String linkedInLink;
	
	@Column(name = "instagram_link", length = 255)
	private String instagramLink;
	
	@Column(name = "twitter_link", length = 255)
	private String twitterLink;

	@Column(name = "admin_name1", length = 255)
	private String adminName1;
	@Column(name = "admin_position1", length = 255)
	private String adminPosition1;
	@Column(name = "admin_email1", length = 255)
	private String adminEmail1;
	
	@Column(name = "admin_name2", length = 255)
	private String adminName2;
	@Column(name = "admin_position2", length = 255)
	private String adminPosition2;
	@Column(name = "admin_email2", length = 255)
	private String adminEmail2;
	

	public void setPhone(String phone) {this.phone = phone;}
	public String getPhone() {return this.phone;}
	
	public void setEmail1(String email) {this.email1 = email;}
	public String getEmail1() {return this.email1;}
	
	public void setEmail2(String email) {this.email2 = email;}
	public String getEmail2() {return this.email2;}
	
	public void setLinkedInLink(String link) {this.linkedInLink = link;}
	public String getLinkedInLink() {return this.linkedInLink;}
	
	public void setInstagramLink(String link) {this.instagramLink = link;}
	public String getInstagramLink() {return this.instagramLink;}
	
	public void setTwitterLink(String link) {this.twitterLink = link;}
	public String getTwitterLink() {return this.twitterLink;}
	
	public void setAdminName1(String name) {this.adminName1 = name;}
	public String getAdminName1() {return this.adminName1;}
	
	public void setAdminName2(String name) {this.adminName2 = name;}
	public String getAdminName2() {return this.adminName2;}
	
	public void setAdminPosition1(String position) {this.adminPosition1 = position;}
	public String getAdmin1Position1() {return this.adminPosition1;}
	
	public void setAdminPosition2(String position) {this.adminPosition2 = position;}
	public String getAdmin2Position2() {return this.adminPosition2;}
	
	public void setAdminEmail1(String email) {this.adminEmail1 = email;}
	public String getAdminEmail1() {return this.adminEmail1;}
	
	public void setAdminEmail2(String email) {this.adminEmail2 = email;}
	public String getAdminEmail2() {return this.adminEmail2;}
	
	
	/************************
	 *                      *
	 *   Financial Status   *
	 *                      * 
	 ************************/
	
	@Column(name = "total_funding_rounds", columnDefinition = "BIGINT")
	private Long totalFundingRounds;
	
	@Column(name = "total_funding_amount", length = 20)
	private String totalFundingAmount;
	
	@Column(name = "number_of_investors", columnDefinition = "BIGINT")
	private Long numberOfInvestors;
	
	@OneToMany(mappedBy = "startup")
    private List<StartupFundingInfo> fundings;
	
	
	public void setTotalFundingRounds(Long numRounds) {this.totalFundingRounds = numRounds;}
	public Long getTotalFundingRounds() {return this.totalFundingRounds;}
	
	public void setTotalFundingAmount(String amount) {this.totalFundingAmount = amount;}
	public String getTotalFundingAmount() {return this.totalFundingAmount;}
	
	public void setNumberOfInvestors(Long num) {this.numberOfInvestors = num;}
	public Long getNumberOfInvestors() {return this.numberOfInvestors;}

    public List<StartupFundingInfo> getFundings() {return this.fundings;}
    public void setFundings(List<StartupFundingInfo> fundings) {this.fundings = fundings;}

}