package io.acellab.official.service.web.app.startline.Service;

import io.acellab.official.service.web.app.startline.Entity.UserEntity;
import io.acellab.official.service.web.app.startline.Status.ResponseFactory;

import org.springframework.security.core.userdetails.User;

import java.util.Optional;

public interface UserService {

    public ResponseFactory<UserEntity> findByUsername(String username);

    public ResponseFactory<UserEntity> userRegister(String username , String password);
}
