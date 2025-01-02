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
@Table(name = "corporateproducts")
public class CorporateProductInfo{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;
	
	@ManyToOne
    @JoinColumn(name = "corporate_id", nullable = false)
    private CorporateInfo corporate;
	
	@Column(name = "product_name", length = 50)
	private String productName;
	@Lob
	@Column(name = "product_description")
	private String productDescription;
	
	public Long getId() {return this.id;}
	
	public CorporateInfo getCorporate() {return this.corporate;}
	public void setCorporate(CorporateInfo corporate) {this.corporate = corporate;}
	
	public void setProductName(String name) {this.productName = name;}
	public String getProductName() {return this.productName;}
	
	public void setProductDescription(String desc) {this.productDescription = desc;}
	public String getProductDescription() {return this.productDescription;}

}