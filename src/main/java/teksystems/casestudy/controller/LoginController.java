package teksystems.casestudy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import teksystems.casestudy.database.entity.User;
import teksystems.casestudy.service.UserService;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

//    @RequestMapping(value = "/login/login", method = RequestMethod.GET)
//    public ModelAndView login(@ModelAttribute ("user")User user) throws Exception {
//        ModelAndView response = new ModelAndView();
//        response.setViewName("login/loginForm");
//        return response;
//    }


//    @PostMapping("/login/loginForm")
//    public ModelAndView loginSubmit(@ModelAttribute ("user")User user) throws Exception {
//        ModelAndView response = new ModelAndView();
//        response.setViewName("login/loginForm");
//        return response;
//    }

}
