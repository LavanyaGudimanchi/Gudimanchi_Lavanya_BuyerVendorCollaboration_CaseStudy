package org.lgudimanchi.bvcollaboration.controller;

import lombok.extern.slf4j.Slf4j;
import org.lgudimanchi.bvcollaboration.database.entity.User;
import org.lgudimanchi.bvcollaboration.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.lgudimanchi.bvcollaboration.formbean.RegisterFormBean;

import javax.validation.Valid;

@Slf4j
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    //I am sending the form bean as a user object by using model attribute approach
    @GetMapping("login/registerUser")
    public ModelAndView registerUser(@ModelAttribute("user") RegisterFormBean registerFormBean) throws Exception {
        ModelAndView response = new ModelAndView();
        response.setViewName("login/register");
        response.addObject("user", registerFormBean);
        return response;
    }

    @GetMapping("/login/login")
    public ModelAndView login() throws Exception {
        ModelAndView response = new ModelAndView();
        response.setViewName("login/loginForm");
        return response;
    }

    //When user click the submit button this controller gets called and binding result will check for the errors.
    // If it finds the errors then it will display the errors messages
    //and stays in the same page.If it doesn't find any errors then user object will get populated  and gets saved by using userservice.
    @PostMapping("login/registerSubmit")
    public ModelAndView registerSubmit(@Valid @ModelAttribute("user") RegisterFormBean registerFormBean, BindingResult bindingResult) throws Exception {
        ModelAndView response = new ModelAndView();

        if (bindingResult.hasErrors()) {
            response.setViewName("login/register");
            response.addObject("user", registerFormBean);
            response.addObject("bindingResult", bindingResult);
            return response;
        }

        User user = new User();
        user.setLoginId(registerFormBean.getLoginId());
        user.setPassword(passwordEncoder.encode(registerFormBean.getPassword()));
        user.setLastName(registerFormBean.getLastName());
        user.setFirstName(registerFormBean.getFirstName());
        user.setPhoneNumber(registerFormBean.getPhoneNumber());
        user.setEmail(registerFormBean.getEmail());

        user.setCompanyName(registerFormBean.getCompanyName());
        user.setAddressLine1(registerFormBean.getAddressLine1());
        user.setAddressLine2(registerFormBean.getAddressLine2());
        user.setCity(registerFormBean.getCity());
        user.setState(registerFormBean.getState());
        user.setZipcode(registerFormBean.getZipcode());

        userService.saveUser(user);

        response.setViewName("login/loginForm");
        return response;
    }


}

