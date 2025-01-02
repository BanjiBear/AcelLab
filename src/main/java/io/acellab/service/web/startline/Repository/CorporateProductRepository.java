package io.acellab.service.web.startline.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import io.acellab.service.web.startline.Entity.CorporateProductInfo;

@Repository("CorporateProductRepository")
public interface CorporateProductRepository extends CrudRepository<CorporateProductInfo, Long> {
	
	@Query(value = "SELECT DISTINCT cp.* FROM corporateproducts cp "
			+ "JOIN corporate c ON cp.corporate_id = c.id "
			+ "WHERE cp.corporate_id = :id", nativeQuery = true)
	ArrayList<CorporateProductInfo> getCorporateProductsByCorporateId(@Param("id") Long id);
	
	
}
