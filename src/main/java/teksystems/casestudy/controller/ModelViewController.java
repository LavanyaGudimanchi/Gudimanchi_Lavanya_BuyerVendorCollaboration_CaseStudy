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

@Controller
public class ModelViewController {

    @ModelAttribute("user")
    public User myuser() {

        User user = new User();
        user.setFirstName("First");
        user.setLastName("Last");
        user.setEmail("abc@mnc.com");
        user.setLoginId("user");
        user.setPassword("user");
        user.setCompanyName("company");
        user.setPhoneNumber(1234567L);
        return user;
    }

    @RequestMapping(value = "/login/login", method = RequestMethod.GET)
    public ModelAndView login(@ModelAttribute ("User")User user) throws Exception {
        ModelAndView response = new ModelAndView();
        response.setViewName("login/loginForm");
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
