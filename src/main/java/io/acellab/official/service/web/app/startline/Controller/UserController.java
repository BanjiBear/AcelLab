package io.acellab.official.service.web.app.startline.Controller;

/*import io.acellab.service.web.app.startline.Dto.UserDTO.UserProfileDTO;
import io.acellab.service.web.app.startline.Entity.User;
import io.acellab.service.web.app.startline.Service.UserService;
import io.acellab.service.web.app.startline.Status.ResponseFactory;
import io.acellab.service.web.app.startline.Status.Status;*/

import io.acellab.official.service.web.app.startline.Status.ResponseFactory;

import io.acellab.official.service.web.app.startline.Service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/startline/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserDetailsService userDetailsService;

    @PostMapping("/Login")
    public ResponseFactory<UserLoginDTO> updateUserProfile(@RequestBody UserLoginDTO userProfileDto) {
        return userService.userLogin(userProfileDto);
    }

}
