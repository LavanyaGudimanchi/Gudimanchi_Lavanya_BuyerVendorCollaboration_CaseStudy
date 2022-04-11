package teksystems.casestudy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import teksystems.casestudy.database.entity.User;
import teksystems.casestudy.service.UserService;

@Controller
public class UserController {

    @Autowired
    private UserService userService;


    public User getUser(@RequestParam(value = "loginId") String loginId,
                        @RequestParam(value = "password") String password) {

        User user = userService.getUser(loginId,password);

        return user;
    }

}
