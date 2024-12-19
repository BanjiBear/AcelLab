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
@Table(name = "company")
public class CompanyInfo{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;
	
	@OneToMany(mappedBy = "company")
    private List<UserInfo> users;
	
	//setId() only for returning company info from model purposes
	public void setId(Long id) {this.id = id;}
	public Long getId() {return this.id;}
	
	public void setUsers(List<UserInfo> users) {this.users = users;}
	public List<UserInfo> getUsers() {return users;}
	
	
	
	/***************************
	 *                         *
	 *   General Information   *
	 *                         * 
	 ***************************/

	@Column(name = "company_name", nullable = false, length = 255)
	private String companyName;
	
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
	
	@Column(name = "company_size", length = 50)
	private String companySize;
	
    
	public void setCompanyName(String name) {this.companyName = name;}
	public String getCompanyName() {return this.companyName;}
	
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
	
	public void setCompanySize(String size) {this.companySize = size;}
	public String getCompanySize() {return this.companySize;}
	
	
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
	
	@Lob
	@Column(name = "product1")
	private String product1;	
	@Column(name = "price1", length = 20)
	private String price1;
	
	@Lob
	@Column(name = "product2")
	private String product2;	
	@Column(name = "price2", length = 20)
	private String price2;
	
	@Lob
	@Column(name = "product3")
	private String product3;	
	@Column(name = "price3", length = 20)
	private String price3;
	
	@Lob
	@Column(name = "product4")
	private String product4;	
	@Column(name = "price4", length = 20)
	private String price4;
	
	@Lob
	@Column(name = "product5")
	private String product5;	
	@Column(name = "price5", length = 20)
	private String price5;
	
	@Lob
	@Column(name = "product6")
	private String product6;	
	@Column(name = "price6", length = 20)
	private String price6;
	
	@Lob
	@Column(name = "product7")
	private String product7;	
	@Column(name = "price7", length = 20)
	private String price7;
	
	@Lob
	@Column(name = "product8")
	private String product8;	
	@Column(name = "price8", length = 20)
	private String price8;
	
	@Lob
	@Column(name = "product9")
	private String product9;	
	@Column(name = "price9", length = 20)
	private String price9;
	
	@Lob
	@Column(name = "product10")
	private String product10;	
	@Column(name = "price10", length = 20)
	private String price10;
	
	
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
	
	public void setProduct1(String product) {this.product1 = product;}
	public String getProduct1() {return this.product1;}
	
	public void setProduct2(String product) {this.product2 = product;}
	public String getProduct2() {return this.product2;}
	
	public void setProduct3(String product) {this.product3 = product;}
	public String getProduct3() {return this.product3;}
	
	public void setProduct4(String product) {this.product4 = product;}
	public String getProduct4() {return this.product4;}
	
	public void setProduct5(String product) {this.product5 = product;}
	public String getProduct5() {return this.product5;}
	
	public void setProduct6(String product) {this.product6 = product;}
	public String getProduct6() {return this.product6;}
	
	public void setProduct7(String product) {this.product7 = product;}
	public String getProduct7() {return this.product7;}
	
	public void setProduct8(String product) {this.product8 = product;}
	public String getProduct8() {return this.product8;}
	
	public void setProduct9(String product) {this.product9 = product;}
	public String getProduct9() {return this.product9;}
	
	public void setProduct10(String product) {this.product10 = product;}
	public String getProduct10() {return this.product10;}
	
	public void setPrice1(String price) {this.price1 = price;}
	public String getPrice1() {return this.price1;}
	
	public void setPrice2(String price) {this.price2 = price;}
	public String getPrice2() {return this.price2;}
	
	public void setPrice3(String price) {this.price3 = price;}
	public String getPrice3() {return this.price3;}
	
	public void setPrice4(String price) {this.price4 = price;}
	public String getPrice4() {return this.price4;}
	
	public void setPrice5(String price) {this.price5 = price;}
	public String getPrice5() {return this.price5;}
	
	public void setPrice6(String price) {this.price6 = price;}
	public String getPrice6() {return this.price6;}
	
	public void setPrice7(String price) {this.price7 = price;}
	public String getPrice7() {return this.price7;}
	
	public void setPrice8(String price) {this.price8 = price;}
	public String getPrice8() {return this.price8;}
	
	public void setPrice9(String price) {this.price9 = price;}
	public String getPrice9() {return this.price9;}
	
	public void setPrice10(String price) {this.price10 = price;}
	public String getPrice10() {return this.price10;}
	
	
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
	
	@Column(name = "funding_amount1", length = 20)
	private String fundingAmount1;
	@Column(name = "funding_date1", length = 20)
	private String fundingDate1;
	
	@Column(name = "funding_amount2", length = 20)
	private String fundingAmount2;
	@Column(name = "funding_date2", length = 20)
	private String fundingDate2;
	
	@Column(name = "funding_amount3", length = 20)
	private String fundingAmount3;
	@Column(name = "funding_date3", length = 20)
	private String fundingDate3;
	
	@Column(name = "funding_amount4", length = 20)
	private String fundingAmount4;
	@Column(name = "funding_date4", length = 20)
	private String fundingDate4;
	
	@Column(name = "funding_amount5", length = 20)
	private String fundingAmount5;
	@Column(name = "funding_date5", length = 20)
	private String fundingDate5;
	
	
	public void setTotalFundingRounds(Long numRounds) {this.totalFundingRounds = numRounds;}
	public Long getTotalFundingRounds() {return this.totalFundingRounds;}
	
	public void setTotalFundingAmount(String amount) {this.totalFundingAmount = amount;}
	public String getTotalFundingAmount() {return this.totalFundingAmount;}
	
	public void setNumberOfInvestors(Long num) {this.numberOfInvestors = num;}
	public Long getNumberOfInvestors() {return this.numberOfInvestors;}
	
	public void setFundingAmount1(String amount) {this.fundingAmount1 = amount;}
	public String getFundingAmount1() {return this.fundingAmount1;}
	
	public void setFundingAmount2(String amount) {this.fundingAmount2 = amount;}
	public String getFundingAmount2() {return this.fundingAmount2;}
	
	public void setFundingAmount3(String amount) {this.fundingAmount3 = amount;}
	public String getFundingAmount3() {return this.fundingAmount3;}
	
	public void setFundingAmount4(String amount) {this.fundingAmount4 = amount;}
	public String getFundingAmount4() {return this.fundingAmount4;}
	
	public void setFundingAmount5(String amount) {this.fundingAmount5 = amount;}
	public String getFundingAmount5() {return this.fundingAmount5;}
	
	public void setFundingDate1(String date) {this.fundingDate1 = date;}
	public String getFundingDate1() {return this.fundingDate1;}
	
	public void setFundingDate2(String date) {this.fundingDate2 = date;}
	public String getFundingDate2() {return this.fundingDate2;}
	
	public void setFundingDate3(String date) {this.fundingDate3 = date;}
	public String getFundingDate3() {return this.fundingDate3;}
	
	public void setFundingDate4(String date) {this.fundingDate4 = date;}
	public String getFundingDate4() {return this.fundingDate4;}
	
	public void setFundingDate5(String date) {this.fundingDate5 = date;}
	public String getFundingDate5() {return this.fundingDate5;}

}