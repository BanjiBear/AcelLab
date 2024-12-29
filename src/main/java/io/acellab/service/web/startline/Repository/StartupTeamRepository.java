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

import io.acellab.service.web.startline.Entity.StartupTeamInfo;

@Repository("StartupTeamRepository")
public interface StartupTeamRepository extends CrudRepository<StartupTeamInfo, Long> {
	
	@Query(value = "SELECT DISTINCT st.* FROM startupteam st "
			+ "JOIN startup s ON st.startup_id = s.id "
			+ "WHERE st.startup_id = :id", nativeQuery = true)
	ArrayList<StartupTeamInfo> getStartupTeamByStartupId(@Param("id") Long id);
	
	
}
