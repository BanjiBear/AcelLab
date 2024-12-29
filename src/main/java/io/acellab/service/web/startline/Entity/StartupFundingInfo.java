package io.acellab.service.web.startline.Entity;


import java.util.Date;
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
@Table(name = "startupfundings")
public class StartupFundingInfo{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;
	
	@ManyToOne
    @JoinColumn(name = "startup_id", nullable = false)
    private StartupInfo startup;
	
	@Column(name = "funding_round", length = 100)
	private String fundingRound;

	@Column(name = "funding_amount", length = 50)
	private String fundingAmount;
	
	@Column(name = "funding_date")
	private Date fundingDate;
	
	@Column(name = "funding_investors", length = 150)
	private String fundingInvestors;
	
	public Long getId() {return this.id;}
	
	public StartupInfo getStartup() {return this.startup;}
	public void setStartup(StartupInfo startup) {this.startup = startup;}
	
	public void setFundingRound(String round) {this.fundingRound = round;}
	public String getFundingRound() {return this.fundingRound;}
	
	public void setFundingAmount(String amount) {this.fundingAmount = amount;}
	public String getFundingAmount() {return this.fundingAmount;}
	
	public void setFundingDate(Date date) {this.fundingDate = date;}
	public Date getFundingDate() {return this.fundingDate;}
	
	public void setFundingInvestors(String investors) {this.fundingInvestors = investors;}
	public String getFundingInvestors() {return this.fundingInvestors;}
	
}