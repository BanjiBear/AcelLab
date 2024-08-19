package io.acellab.official.service.web.app.startline.Repository;

import io.acellab.official.service.web.app.startline.Entity.UserEntity;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository("userRepository")
public interface UserRepository extends CrudRepository<UserEntity, Long> {

    @Query(value = "SELECT * FROM crm_user WHERE username = :username", nativeQuery = true)
    Optional<UserEntity> findUserByUserName(@Param("username") String username);

    @Query(value = "INSERT INTO crm_user ('username' , 'password') VALUES (:username , ::password)",nativeQuery = true)
    int createUser(@Param("username") String username, @Param("password") String password);

}
