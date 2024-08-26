package io.acellab.official.service.web.app.startline.Controller;

import io.acellab.official.service.web.app.startline.Dto.User.UserDto;
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

        String searchUsernameResultMessage = userService.findByUsername(userDto.getUsername()).getStatusMessage();
        String searchEmailResultMessage = userService.findByEmail(userDto.getEmail()).getStatusMessage();
        String PasswordValidation = userService.passwordValidation(userDto.getPassword()).getStatusMessage();

        if (searchUsernameResultMessage.equals("DATA_FOUND") || searchEmailResultMessage.equals("DATA_FOUND") || PasswordValidation.equals("USER_INVALID_PASSWORD_FORMAT")) {
            if(searchUsernameResultMessage.equals("DATA_FOUND")) model.addAttribute("UsernameExist", userDto.getUsername());
            if(searchEmailResultMessage.equals("DATA_FOUND")) model.addAttribute("EmailExist", userDto.getEmail());
            if(PasswordValidation.equals("USER_INVALID_PASSWORD_FORMAT")) model.addAttribute("PasswordFormatInvalid", "");
            return "register";
        }

        userService.userRegister(userDto);
        return "redirect:/register?success";
    }

    @GetMapping("/company-home")
    public String companyUserHome(Model model, Principal principal) {
        UserDetails userDetails = userDetailsService.loadUserByUsername(principal.getName());
        model.addAttribute("userdetail", userDetails);
        return "companyUserHome";
    }

    @GetMapping("/startup-home")
    public String StartUpUserHome(Model model, Principal principal) {
        UserDetails userDetails = userDetailsService.loadUserByUsername(principal.getName());
        model.addAttribute("userdetail", userDetails);
        return "startUpUserHome";
    }

}
