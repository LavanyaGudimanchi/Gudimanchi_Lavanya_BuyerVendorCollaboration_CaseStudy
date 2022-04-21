package teksystems.casestudy.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import teksystems.casestudy.database.entity.User;
import teksystems.casestudy.service.UserService;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("login/registerUser")
    public ModelAndView registerUser(@ModelAttribute("user") User user) throws Exception {
        ModelAndView response = new ModelAndView();
        response.setViewName("login/register");
        response.addObject("user", user);
        return response;
    }

    @GetMapping("/login/login")
    public ModelAndView login() throws Exception {
        ModelAndView response = new ModelAndView();
        response.setViewName("login/loginForm");
        return response;
    }

    @PostMapping("login/registerSubmit")
    public ModelAndView registerSubmit(@ModelAttribute("user") User user, BindingResult bindingResult) throws Exception {
        ModelAndView response = new ModelAndView();

        response.setViewName("login/loginForm");
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userService.saveUser(user);
        return response;
    }


}

