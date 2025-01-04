package io.acellab.service.web.startline.Repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import io.acellab.service.web.startline.Entity.CompanyFundingInfo;

@Repository("CompanyFundingRepository")
public interface CompanyFundingRepository extends CrudRepository<CompanyFundingInfo, Long> {
	
	@Query(value = "SELECT DISTINCT cf.* FROM companyfundings cf "
			+ "JOIN company c ON cf.company_id = c.id "
			+ "WHERE cf.company_id = :id", nativeQuery = true)
	ArrayList<CompanyFundingInfo> getCompanyFundingsByCompanyId(@Param("id") Long id);
	
	
}
