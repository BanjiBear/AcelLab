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
	
	@Modifying
	@Transactional
	@Query(value = "INSERT INTO email (user_id, user_firstname, user_email, recipient_email, payload_opt, type, isSent, job_error) "
			+ "VALUES ("
			+ ":user_id, "
			+ ":user_firstname, "
			+ ":user_email, "
			+ ":recipient_email, "
			+ ":payload_opt, "
			+ ":type, "
			+ ":isSent, "
			+ ":job_error)", nativeQuery = true)
	void addScheduledEmailByUserId(
			@Param("user_id") Long user_id, 
			@Param("user_firstname") String user_firstname, 
			@Param("user_email") String user_email, 
			@Param("recipient_email") String recipient_email, 
			@Param("payload_opt") String payload_opt, 
			@Param("type") String type, 
			@Param("isSent") Boolean isSent, 
			@Param("job_error") Boolean job_error);


}
