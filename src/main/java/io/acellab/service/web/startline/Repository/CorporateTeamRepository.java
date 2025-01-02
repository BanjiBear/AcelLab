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

import io.acellab.service.web.startline.Entity.CorporateTeamInfo;

@Repository("CorporateTeamRepository")
public interface CorporateTeamRepository extends CrudRepository<CorporateTeamInfo, Long> {
	
	@Query(value = "SELECT DISTINCT ct.* FROM corporateteam ct "
			+ "JOIN corporate c ON ct.corporate_id = c.id "
			+ "WHERE ct.corporate_id = :id", nativeQuery = true)
	ArrayList<CorporateTeamInfo> getCorporateTeamByCorporateId(@Param("id") Long id);
	
	
}
