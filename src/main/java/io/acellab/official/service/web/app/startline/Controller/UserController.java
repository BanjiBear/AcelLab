package io.acellab.official.service.web.app.startline.Controller;

import io.acellab.official.service.web.app.startline.Dto.User.UserDto;
import io.acellab.official.service.web.app.startline.Entity.UserEntity;
import io.acellab.official.service.web.app.startline.Status.ResponseFactory;
import io.acellab.official.service.web.app.startline.Service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.security.Principal;

@Controller
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

    //Enter to register page
    @GetMapping("/register")
    public String register(Model model, UserDto userDto) {
        model.addAttribute("user", userDto);
        return "register";
    }

    //Doing registration action
    @PostMapping("/register")
    public String registerSava(@ModelAttribute("user") UserDto userDto, Model model) {
        String searchResultMessage = userService.findByUsername(userDto.getUsername()).getStatusMessage();
        if (searchResultMessage.equals("DATA_FOUND")) {
            model.addAttribute("Userexist",  userDto.getUsername());
            return "register";
        }
        userService.userRegister(userDto);
        return "redirect:/register?success";
    }

    @GetMapping("/home")
    public String home(Model model, Principal principal) {
        UserDetails userDetails = userDetailsService.loadUserByUsername(principal.getName());
        model.addAttribute("userdetail", userDetails);
        return "home";
    }

}
