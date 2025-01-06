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

import io.acellab.service.web.startline.Entity.CollaboratorsInfo;
import io.acellab.service.web.startline.Entity.UserInfo;

@Repository("CollaboratorsRepository")
public interface CollaboratorsRepository extends CrudRepository<CollaboratorsInfo, Long> {
	
	@Query(value = "SELECT * FROM collaborators WHERE id IN "
			+ "(SELECT collaborators_id FROM collabgroupinfo WHERE user_id = :userid)", nativeQuery = true)
	Optional<CollaboratorsInfo> getAllCollaboratorsIDsByUserID(@Param("userid") Long userid);
	
	@Modifying
	@Transactional
	@Query(value = "INSERT INTO collabgroupinfo (user_id, collaborators_id) "
			+ "VALUES (:userid, :collaboratorsid);", nativeQuery = true)
	void addCollaboratorsMappingInCollabGroupInfo(@Param("userid") Long userid, @Param("collaboratorsid") Long collaboratorsid);

}
