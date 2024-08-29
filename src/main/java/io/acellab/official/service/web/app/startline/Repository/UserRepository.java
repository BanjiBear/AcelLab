package io.acellab.official.service.web.app.startline.Repository;

import io.acellab.official.service.web.app.startline.Entity.UserEntity;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository("userRepository")
public interface UserRepository extends CrudRepository<UserEntity, Long> {

    @Query(value = "SELECT * FROM crm_user WHERE username = :username", nativeQuery = true)
    Optional<UserEntity> findUserByUserName(@Param("username") String username);

    @Modifying
    @Query(value = "INSERT INTO crm_user (username ,email, passwd , roleid) VALUES (:username ,:email, :password, :roleId)", nativeQuery = true)
    int createUser(@Param("username") String username,
                   @Param("email") String email,
                   @Param("password") String password,
                   @Param("roleId") String roleId);

    @Query(value = "SELECT * FROM crm_user WHERE email = :email", nativeQuery = true)
    Optional<UserEntity> findUserByEmail(@Param("email") String email);

    @Query(value = "SELECT permission FROM role INNER JOIN crm_user ON role.Id = crm_user.roleid WHERE crm_user.username = :username", nativeQuery = true)
    Optional<String> findRoleByUsername(@Param("username") String username);

    @Query(value = "SELECT Id FROM role WHERE permission = :permission", nativeQuery = true)
    Optional<String> findRoleIdByPermission(@Param("permission") String permission);

}
