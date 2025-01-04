package io.acellab.service.web.startline.Repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import io.acellab.service.web.startline.Entity.CompanyProductInfo;

@Repository("CompanyProductRepository")
public interface CompanyProductRepository extends CrudRepository<CompanyProductInfo, Long> {
	
	@Query(value = "SELECT DISTINCT cp.* FROM companyproducts cp "
			+ "JOIN company c ON cp.company_id = c.id "
			+ "WHERE cp.company_id = :id", nativeQuery = true)
	ArrayList<CompanyProductInfo> getCompanyProductsByCompanyId(@Param("id") Long id);
	
	
}
