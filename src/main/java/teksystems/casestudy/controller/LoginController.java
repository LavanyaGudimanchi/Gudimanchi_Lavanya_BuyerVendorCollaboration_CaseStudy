package teksystems.casestudy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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

    @RequestMapping(value = "/login/login", method = RequestMethod.GET)
    public ModelAndView login() throws Exception {
        ModelAndView response = new ModelAndView();
        response.setViewName("login/loginForm");
        return response;
    }

}
