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

	@Query(value = "SELECT * FROM user WHERE id = :id", nativeQuery = true)
	Optional<UserInfo> findUserById(@Param("id") String id);
	
	@Query(value = "SELECT * FROM user WHERE username = :username", nativeQuery = true)
	Optional<UserInfo> findUserByUsername(@Param("username") String username);
	
	@Query(value = "SELECT * FROM user WHERE email = :email", nativeQuery = true)
	Optional<UserInfo> findUserByEmail(@Param("email") String email);
	
	//Not used
	@Query(value = "SELECT isStartup FROM user WHERE username = :username", nativeQuery = true)
	Boolean getAccountTypeByUsername(@Param("username") String username);
	
	//Not used
	@Query(value = "SELECT business_plan_id FROM user WHERE username = :username", nativeQuery = true)
	Integer getUserPlanByUsername(@Param("username") String username);
	
	@Modifying
	@Transactional
	@Query(value = "INSERT INTO user ("
			+ "username, password, firstname, lastname, department, role, email, phone, linkedIn, isStartup, business_plan_id, "
			+ "is_admin, is_active, is_system_generated, is_expired) "
	+ "VALUES(:username, "
			+ ":password, "
			+ ":fname, "
			+ ":lname, "
			+ "NULL, "
			+ "NULL, "
			+ ":email, "
			+ "NULL, "
			+ "NULL, "
			+ ":isStartup, "
			+ ":plan, "
			+ ":is_admin, "
			+ ":is_active, "
			+ ":is_system_gen, "
			+ ":is_expired)", nativeQuery = true)
	void createNewUserFromRegister(@Param("username") String username, @Param("password") String password, @Param("fname") String fname, @Param("lname") String lname, @Param("email") String email, @Param("isStartup") Boolean isStartup, @Param("plan") Integer plan, 
			@Param("is_admin") Boolean is_admin, @Param("is_active") Boolean is_active, @Param("is_system_gen") Boolean is_system_gen, @Param("is_expired") Boolean is_expired);
	
	
	@Modifying
	@Transactional
	@Query(value = "INSERT INTO user ("
			+ "username, password, firstname, lastname, email, isStartup, business_plan_id, "
			+ "is_admin, is_active, is_system_generated, is_expired) "
	+ "VALUES(:username, "
			+ ":password, "
			+ ":fname, "
			+ ":lname, "
			+ ":email, "
			+ ":isStartup, "
			+ ":plan, "
			+ ":is_admin, "
			+ ":is_active, "
			+ ":is_system_gen, "
			+ ":is_expired)", nativeQuery = true)
	void createSystemGeneratedUserFromInvitation(@Param("username") String username, @Param("password") String password, @Param("fname") String fname, @Param("lname") String lname, @Param("email") String email, @Param("isStartup") Boolean isStartup, @Param("plan") Integer plan, 
			@Param("is_admin") Boolean is_admin, @Param("is_active") Boolean is_active, @Param("is_system_gen") Boolean is_system_gen, @Param("is_expired") Boolean is_expired);
	
	@Modifying
	@Transactional
	@Query(value = "UPDATE user SET is_system_generated = 0 WHERE id = :id;", nativeQuery = true)
	void updateSystemUserStatusAfterLoginByID(@Param("id") Long id);
	
	
	@Modifying
	@Transactional
	@Query(value = "UPDATE user "
	+ "SET firstname = :firstname, "
		+ "lastname = :lastname, "
		+ "department = :department, "
		+ "role = :role, "
		+ "email = :email, "
		+ "phone = :phone, "
		+ "linkedIn = :linkedIn, "
		+ "username = :username, "
		+ "password = :password "
	+ "WHERE id = :id;", nativeQuery = true)
	void updateUserByID(@Param("firstname") String firstname, @Param("lastname") String lastname, @Param("department") String department, @Param("role") String role, @Param("email") String email, @Param("phone") String phone, @Param("linkedIn") String linkedIn, @Param("username") String username, @Param("password") String password, @Param("id") Long id);
	
	
	@Modifying
	@Transactional
	@Query(value = "UPDATE user "
	+ "SET isStartup = :isStartup, business_plan_id = :plan_id "
	+ "WHERE id = :id;", nativeQuery = true)
	void updateUserPlan(@Param("isStartup") Boolean isStartup, @Param("plan_id") Long plan_id, @Param("id") Long id);

}
