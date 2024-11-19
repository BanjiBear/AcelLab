package io.acellab.service.web.startline.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;


@Entity
@Table(name = "user")
public class UserInfo{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long userId;

	@Column(name = "username", length = 100, nullable = false)
	private String username;

	@Column(name = "password", length = 32, nullable = false)
	private String password;
	
	@Column(name = "name", length = 255, nullable = false)
	private String name;
	
	@ManyToOne
	@JoinColumn(name = "company_id")
	private CompanyInfo company;
	
	@Column(name = "department", length = 255)
	private String department;
	
	@Column(name = "role", length = 255)
	private String role;
	
	@Column(name = "email", length = 255)
	private String email;
	
	@Column(name = "phone", length = 255)
	private String phone;
	
	@Column(name = "linkedIn", length = 255)
	private String linkedIn;
	
	@Column(name = "isStartup")
    private Boolean isStartup;

    @ManyToOne
    @JoinColumn(name = "business_plan_id")
    private BusinessPlanInfo businessPlan;
	
	public Long getUserId() {return this.userId;}
		
	public void setUsername(String username) {this.username = username;}
	public String getUsername() {return this.username;}
	
	public void setPassword(String password) {this.password = password;}
	public String getPassword() {return this.password;}
	
	public void setName(String name) {this.name = name;}
	public String getName() {return this.name;}
	
	public void setCompany(CompanyInfo company) {this.company = company;}
	public CompanyInfo getCompany() {return company;}
	
	public void setDepartment(String department) {this.department = department;}
	public String getDepartment() {return this.department;}
	
	public void setRole(String role) {this.role = role;}
	public String getRole() {return this.role;}
	
	public void setEmail(String email) {this.email = email;}
	public String getEmail() {return this.email;}
	
	public void setPhone(String phone) {this.phone = phone;}
	public String getPhone() {return this.phone;}
	
	public void setLinkedIn(String linkedIn) {this.linkedIn = linkedIn;}
	public String getLinkedIn() {return this.linkedIn;}
	
	public void setAccountType(Boolean isStartup) {this.isStartup = isStartup;}
	public Boolean getAccountType() {return this.isStartup;}
	
	public void setBusinessPlan(BusinessPlanInfo businessPlan) {this.businessPlan = businessPlan;}
	public BusinessPlanInfo getBusinessPlan() {return businessPlan;}

}