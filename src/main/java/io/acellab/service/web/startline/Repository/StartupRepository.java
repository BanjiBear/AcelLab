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

import io.acellab.service.web.startline.Entity.StartupFundingInfo;
import io.acellab.service.web.startline.Entity.StartupInfo;
import io.acellab.service.web.startline.Entity.StartupProductInfo;

@Repository("StartupRepository")
public interface StartupRepository extends CrudRepository<StartupInfo, Long> {
	
	@Query(value = "SELECT * FROM startup WHERE id = :id", nativeQuery = true)
	Optional<StartupInfo> getStartupById(@Param("id") Long id);


}
