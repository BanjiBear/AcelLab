package io.acellab.service.web.startline.Entity;


import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Column;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;


@Entity
@Table(name = "corporateteam")
public class CorporateTeamInfo{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;
	
	@ManyToOne
    @JoinColumn(name = "corporate_id", nullable = false)
    private CorporateInfo corporate;
	
	@Column(name = "name", length = 100, nullable = false)
	private String name;
	
	@Column(name = "department", length = 255)
	private String department;
	
	@Column(name = "role", length = 255)
	private String role;
	
	@Column(name = "email", length = 255, nullable = false)
	private String email;
	
	@Column(name = "phone", length = 255)
	private String phone;
	
	@Column(name = "linkedin", length = 255)
	private String linkedin;
	
	public Long getId() {return this.id;}
	
	public CorporateInfo getCorporate() {return this.corporate;}
	public void setCorporate(CorporateInfo corporate) {this.corporate = corporate;}
	
	public void setName(String name) {this.name = name;}
	public String getName() {return this.name;}
	
	public void setDepartment(String department) {this.department = department;}
	public String getDepartment() {return this.department;}
	
	public void setRole(String role) {this.role = role;}
	public String getRole() {return this.role;}
	
	public void setEmail(String email) {this.email = email;}
	public String getEmail() {return this.email;}
	
	public void setPhone(String phone) {this.phone = phone;}
	public String getPhone() {return this.phone;}
	
	public void setLinkedin(String linkedin) {this.linkedin = linkedin;}
	public String getLinkedin() {return this.linkedin;}

}