package io.acellab.service.web.startline.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;


@Entity
@Table(name = "questionform")
public class QuestionForm{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long questionid;
	
	@Column(name = "reason", length = 255, nullable = false)
	private String reason;

	@Column(name = "firstname", length = 255, nullable = false)
	private String firstname;

	@Column(name = "lastname", length = 255, nullable = false)
	private String lastname;
	
	@Column(name = "companyname", length = 255, nullable = false)
	private String companyname;
	
	@Column(name = "phone", length = 255, nullable = false)
	private String phone;
	
	@Column(name = "email", length = 255, nullable = false)
	private String email;
	
	@Lob
	@Column(name = "message")
	private String message;
	
	@Column(name = "resolved")
	private Boolean resolved;
	
	@Lob
	@Column(name = "internalremarks")
	private String internalremarks;
	
	
	public void setQuestionId(Long questionid) {this.questionid = questionid;}
	public Long getQuestionId() {return this.questionid;}
	
	public void setReason(String reason) {this.reason = reason;}
	public String getReason() {return this.reason;}
	
	public void setFirstname(String firstname) {this.firstname = firstname;}
	public String getFirstname() {return this.firstname;}
	
	public void setLastname(String lastname) {this.lastname = lastname;}
	public String getLastname() {return this.lastname;}
	
	public void setCompanyname(String companyname) {this.companyname = companyname;}
	public String getCompanyname() {return this.companyname;}
	
	public void setPhone(String phone) {this.phone = phone;}
	public String getPhone() {return this.phone;}
	
	public void setEmail(String email) {this.email = email;}
	public String getEmail() {return this.email;}
	
	public void setMessage(String message) {this.message = message;}
	public String getMessage() {return this.message;}
	
	public void setStatus(Boolean resolved) {this.resolved = resolved;}
	public Boolean getStatus() {return this.resolved;}
	
	public void setInternalRemarks(String remark) {this.internalremarks = remark;}
	public String getInternalRemarks() {return this.internalremarks;}

}