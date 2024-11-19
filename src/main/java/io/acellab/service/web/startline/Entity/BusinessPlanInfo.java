package io.acellab.service.web.startline.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.Column;


@Entity
@Table(name = "businessplan")
public class BusinessPlanInfo{

	@Id
	@Column(name = "id", columnDefinition = "INTEGER")
	private Integer id;

	@Column(name = "plan_name", length = 255, nullable = false)
	private String plan_name;

	@Column(name = "price", columnDefinition = "INTEGER", nullable = false)
	private Integer price;
	
	@Column(name = "description1", length = 255)
	private String description1;
	
	@Column(name = "description2", length = 255)
	private String description2;
	
	@Column(name = "description3", length = 255)
	private String description3;
	
	@Column(name = "description4", length = 255)
	private String description4;
	
	@Column(name = "description5", length = 255)
	private String description5;
	
	@Column(name = "description6", length = 255)
	private String description6;
	
	@Column(name = "description7", length = 255)
	private String description7;
	
	@Column(name = "description8", length = 255)
	private String description8;
	
	@Column(name = "description9", length = 255)
	private String description9;
	
	@Column(name = "description10", length = 255)
	private String description10;
	
	public Integer getPlanId() {return this.id;}
		
	public void setPlanName(String name) {this.plan_name = name;}
	public String getPlanName() {return this.plan_name;}
	
	public void setPrice(Integer price) {this.price = price;}
	public Integer getPrice() {return this.price;}
	
	public void setDescription1(String desc) {this.description1 = desc;}
	public String getDescription1() {return this.description1;}
	
	public void setDescription2(String desc) {this.description2 = desc;}
	public String getDescription2() {return this.description2;}
	
	public void setDescription3(String desc) {this.description3 = desc;}
	public String getDescription3() {return this.description3;}
	
	public void setDescription4(String desc) {this.description4 = desc;}
	public String getDescription4() {return this.description4;}
	
	public void setDescription5(String desc) {this.description5 = desc;}
	public String getDescription5() {return this.description5;}
	
	public void setDescription6(String desc) {this.description6 = desc;}
	public String getDescription6() {return this.description6;}
	
	public void setDescription7(String desc) {this.description7 = desc;}
	public String getDescription7() {return this.description7;}
	
	public void setDescription8(String desc) {this.description8 = desc;}
	public String getDescription8() {return this.description8;}
	
	public void setDescription9(String desc) {this.description9 = desc;}
	public String getDescription9() {return this.description9;}
	
	public void setDescription10(String desc) {this.description10 = desc;}
	public String getDescription10() {return this.description10;}

}