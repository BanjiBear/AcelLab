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

@Repository("StartupFundingRepository")
public interface StartupFundingRepository extends CrudRepository<StartupFundingInfo, Long> {
	
	@Query(value = "SELECT DISTINCT sf.* FROM startupfundings sf "
			+ "JOIN startup s ON sf.startup_id = s.id "
			+ "WHERE sf.startup_id = :id", nativeQuery = true)
	ArrayList<StartupFundingInfo> getStartupFundingsByStartupId(@Param("id") Long id);

}
