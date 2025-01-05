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
	
	@Column(name = "firstname", length = 255, nullable = false)
	private String firstname;
	
	@Column(name = "lastname", length = 255, nullable = false)
	private String lastname;
	
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
	@JoinColumn(name = "startup_id")
	private StartupInfo startup;

	@ManyToOne
	@JoinColumn(name = "corporate_id")
	private CorporateInfo corporate;

	@Column(name = "business_plan_id", nullable = false)
	private Integer businessPlan;
	
	public Long getUserId() {return this.userId;}
		
	public void setUsername(String username) {this.username = username;}
	public String getUsername() {return this.username;}
	
	public void setPassword(String password) {this.password = password;}
	public String getPassword() {return this.password;}
	
	public void setFirstname(String name) {this.firstname = name;}
	public String getFirstname() {return this.firstname;}
	
	public void setLastname(String name) {this.lastname = name;}
	public String getLastname() {return this.lastname;}
	
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
	
	public StartupInfo getStartup() {return this.startup;}
	public void setStartup(StartupInfo startup) {this.startup = startup;}

	public CorporateInfo getCorporate() {return corporate;}
	public void setCorporate(CorporateInfo corporate) {this.corporate = corporate;}
	
	public void setBusinessPlan(Integer businessPlan) {this.businessPlan = businessPlan;}
	public Integer getBusinessPlan() {return businessPlan;}
	
	
	@Column(name = "is_admin")
	private Boolean isAdmin;
	
	@Column(name = "is_active")
	private Boolean isActive;
	
	@Column(name = "is_expired")
	private Boolean isExpired;
	
	public void setIsAdmin(Boolean isAdmin) {this.isAdmin = isAdmin;}
	public Boolean getIsAdmin() {return this.isAdmin;}
	
	public void setIsActive(Boolean isActive) {this.isActive = isActive;}
	public Boolean getIsActive() {return this.isActive;}
	
	public void setIsExpired(Boolean isExpired) {this.isExpired = isExpired;}
	public Boolean getIsExpired() {return this.isExpired;}

}