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

import io.acellab.service.web.startline.Entity.CorporateFundingInfo;

@Repository("CorporateFundingRepository")
public interface CorporateFundingRepository extends CrudRepository<CorporateFundingInfo, Long> {
	
	@Query(value = "SELECT DISTINCT cf.* FROM corporatefundings cf "
			+ "JOIN corporate c ON cf.corporate_id = c.id "
			+ "WHERE cf.corporate_id = :id", nativeQuery = true)
	ArrayList<CorporateFundingInfo> getCorporateFundingsByCorporateId(@Param("id") Long id);
	
	
}
