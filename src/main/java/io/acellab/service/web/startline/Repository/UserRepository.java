package io.acellab.service.web.startline.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

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


}
