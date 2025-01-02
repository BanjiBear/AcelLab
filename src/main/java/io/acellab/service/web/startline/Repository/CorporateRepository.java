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
import io.acellab.service.web.startline.Entity.CorporateInfo;
import io.acellab.service.web.startline.Entity.CorporateProductInfo;

@Repository("CorporateRepository")
public interface CorporateRepository extends CrudRepository<CorporateInfo, Long> {
	
	@Query(value = "SELECT * FROM corporate WHERE id = :id", nativeQuery = true)
	Optional<CorporateInfo> getCorporateById(@Param("id") Long id);


}
