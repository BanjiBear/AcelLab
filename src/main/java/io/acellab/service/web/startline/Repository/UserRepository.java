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

import io.acellab.service.web.startline.Entity.UserInfo;

@Repository("userRepository")
public interface UserRepository extends CrudRepository<UserInfo, Long> {

	@Query(value = "SELECT * FROM user WHERE username = :username", nativeQuery = true)
	Optional<UserInfo> findUserByUsername(@Param("username") String username);
	
	@Query(value = "SELECT * FROM user WHERE email = :email", nativeQuery = true)
	Optional<UserInfo> findUserByEmail(@Param("email") String email);
	
	@Query(value = "SELECT isStartup FROM user WHERE username = :username", nativeQuery = true)
	Boolean getAccountTypeByUsername(@Param("username") String username);
	
	@Query(value = "SELECT business_plan_id FROM user WHERE username = :username", nativeQuery = true)
	Integer getUserPlanByUsername(@Param("username") String username);
	
	@Modifying // Indicates this is a data modification query
	@Transactional
	@Query(value = "INSERT INTO user (username, password, firstname, lastname, company_id, department, role, email, phone, linkedIn, isStartup, business_plan_id) "
	+ "VALUES(:username, "
			+ ":password, "
			+ ":fname, "
			+ ":lname, "
			+ "NULL, "
			+ "NULL, "
			+ "NULL, "
			+ ":email, "
			+ "NULL, "
			+ "NULL, "
			+ ":isStartup, "
			+ ":plan)", nativeQuery = true)
	void createNewUserFromRegister(@Param("username") String username, @Param("password") String password, @Param("fname") String fname, @Param("lname") String lname, @Param("email") String email, @Param("isStartup") Boolean isStartup, @Param("plan") Integer plan);

}
