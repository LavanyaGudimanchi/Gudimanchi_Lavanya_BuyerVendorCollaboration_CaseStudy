package teksystems.casestudy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import teksystems.casestudy.database.entity.Product;
import teksystems.casestudy.database.entity.User;
import teksystems.casestudy.database.entity.UserCopy;

@Controller
public class ModelViewController {

//    @ModelAttribute("user")
//    public UserCopy myuser() {
//
//        UserCopy user = new UserCopy();
//        user.firstName= "First";
//        user.lastName = "Last";
//        user.email = "abc@mnc.com";
//        user.loginId= "user";
//        return user;
//    }

    @RequestMapping(value = "/login/login", method = RequestMethod.GET)
    public ModelAndView login(@ModelAttribute ("user")UserCopy user) throws Exception {
        ModelAndView response = new ModelAndView();
        response.setViewName("login/loginForm");
        user.firstName= "First";
        user.lastName = "Last";
        user.email = "abc@mnc.com";
        user.loginId= "user";
        response.addObject(user);
        return response;
    }

//    @GetMapping("/login/loginForm")
//    public String passParameterswithModel(Model model)
//    {
//        model.addAttribute("message", "Perscholas");
//        model.addAttribute("welcomemessage", "Welcome");
//        return "/login/loginForm";
//    }

    @GetMapping("/login/loginForm")
    public ModelAndView passParameterswithModel()
    {
        ModelAndView modelandview = new ModelAndView("/login/loginForm");
        modelandview.addObject("message", "Perscholas");
        modelandview.addObject("welcomemessage", "Welcome");
        return modelandview;
    }

}
