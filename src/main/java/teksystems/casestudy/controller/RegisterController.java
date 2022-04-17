package teksystems.casestudy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import teksystems.casestudy.database.entity.Product;
import teksystems.casestudy.database.entity.User;
import teksystems.casestudy.service.RegisterService;
import teksystems.casestudy.service.UserService;

import java.util.List;

@Controller
public class RegisterController {

    @Autowired
    private RegisterService registerService;

    @GetMapping("login/userlogin")
    public ModelAndView userlogin(@ModelAttribute("user") User user) throws Exception {
        ModelAndView response = new ModelAndView();
        response.setViewName("login/register");
        response.addObject("user", user);
        return response;
    }

    @PostMapping("login/registerUser")
    public ModelAndView registerUser(@ModelAttribute("user") User user) throws Exception {
        ModelAndView response = new ModelAndView();
        response.setViewName("login/loginForm");
        registerService.save(user);
        return response;
    }

}

