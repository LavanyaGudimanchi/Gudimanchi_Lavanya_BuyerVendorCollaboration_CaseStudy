package teksystems.casestudy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import teksystems.casestudy.database.entity.User;
import teksystems.casestudy.service.UserService;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    public User getUser(@RequestParam(value = "loginId") String loginId,
                        @RequestParam(value = "password") String password) {

        User user = userService.validateUser(loginId,password);

        return user;
    }

    @GetMapping("/login/login")
    public ModelAndView login(@ModelAttribute("user")User user) throws Exception {
        ModelAndView response = new ModelAndView();
        response.setViewName("login/loginForm");
        //response.addObject("user", user);
        return response;
    }

    @PostMapping("/login/login")
    public ModelAndView loginSubmit(@ModelAttribute("user")User user) throws Exception {
        ModelAndView response = new ModelAndView();
        response.setViewName("login/loginForm");
        //response.addObject("user", user);
        return response;
    }

}
