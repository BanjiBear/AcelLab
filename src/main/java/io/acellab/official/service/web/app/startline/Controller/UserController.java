package io.acellab.official.service.web.app.startline.Controller;

/*import io.acellab.service.web.app.startline.Dto.UserDTO.UserProfileDTO;
import io.acellab.service.web.app.startline.Entity.User;
import io.acellab.service.web.app.startline.Service.UserService;
import io.acellab.service.web.app.startline.Status.ResponseFactory;
import io.acellab.service.web.app.startline.Status.Status;*/


import io.acellab.official.service.web.app.startline.Dto.User.UserDto;
import io.acellab.official.service.web.app.startline.Status.ResponseFactory;

import io.acellab.official.service.web.app.startline.Service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.security.Principal;

@Controller
//@RequestMapping("/startline/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserDetailsService userDetailsService;

    @GetMapping("/login")
    public String login(Model model, UserDto userDto) {
        model.addAttribute("user", userDto);
        return "login";
    }

    @GetMapping("/home")
    public String home(Model model, Principal principal) {
        UserDetails userDetails = userDetailsService.loadUserByUsername(principal.getName());
        model.addAttribute("userdetail", userDetails);
        return "home";
    }

}