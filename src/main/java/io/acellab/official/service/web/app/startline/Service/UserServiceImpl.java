package io.acellab.official.service.web.app.startline.Service;

import io.acellab.official.service.web.app.startline.Dto.User.UserDto;
import io.acellab.official.service.web.app.startline.Entity.UserEntity;
import io.acellab.official.service.web.app.startline.Repository.UserRepository;
import io.acellab.official.service.web.app.startline.Status.ResponseFactory;
import io.acellab.official.service.web.app.startline.Status.Status;
import io.acellab.official.service.web.app.startline.Util.FunctionUtil;
import io.acellab.official.service.web.app.startline.Util.ResponseUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public ResponseFactory<UserEntity> findByUsername(String username) {

        Optional<UserEntity> user = userRepository.findUserByUserName(username);

        if (user.isPresent()) {
            return ResponseUtil.createResponse(Status.DATA_FOUND, user.get());
        } else {
            return ResponseUtil.createResponse(Status.DATA_NOT_FOUND, new UserEntity());
        }
    }

    @Override
    @Transactional
    public ResponseFactory<UserEntity> findByEmail(String email) {
        Optional<UserEntity> user = userRepository.findUserByEmail(email);

        if (user.isPresent()) {
            return ResponseUtil.createResponse(Status.DATA_FOUND, user.get());
        } else {
            return ResponseUtil.createResponse(Status.DATA_NOT_FOUND, new UserEntity());
        }
    }

    @Override
    @Transactional
    public ResponseFactory<UserDto> userRegister(UserDto userDto) {


        int result = userRepository.createUser(
                userDto.getUsername(),
                userDto.getEmail(),
                passwordEncoder.encode(userDto.getPassword()),
                userRepository.findRoleIdByPermission(userDto.getUserType()).get()
        );

        if (result == -1) {
            return ResponseUtil.createResponse(Status.DATA_UNIQUE_EXIST, userDto);
        } else {
            return ResponseUtil.createResponse(Status.DATA_CREATED, userDto);
        }

    }

    @Override
    @Transactional
    public ResponseFactory<String> passwordValidation(String password) {
        if(FunctionUtil.isValidPassword(password)){
            return ResponseUtil.createResponse(Status.USER_VALID_PASSWORD_FORMAT, password);
        }else{
            return ResponseUtil.createResponse(Status.USER_INVALID_PASSWORD_FORMAT, password);
        }
    }


}
