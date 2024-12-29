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

@Repository("StartupProductRepository")
public interface StartupProductRepository extends CrudRepository<StartupProductInfo, Long> {
	
	@Query(value = "SELECT DISTINCT sp.* FROM startupproducts sp "
			+ "JOIN startup s ON sp.startup_id = s.id "
			+ "WHERE sp.startup_id = :id", nativeQuery = true)
	ArrayList<StartupProductInfo> getStartupProductsByStartupId(@Param("id") Long id);
	
	
}
