package io.acellab.official.service.web.app.startline.Service;

import io.acellab.official.service.web.app.startline.Entity.UserEntity;
import io.acellab.official.service.web.app.startline.Status.ResponseFactory;
import io.acellab.official.service.web.app.startline.Dto.User.UserDto;

public interface UserService {

    public ResponseFactory<UserEntity> findByUsername(String username);

    public ResponseFactory<UserEntity> userRegister(UserDto userDto);
}
