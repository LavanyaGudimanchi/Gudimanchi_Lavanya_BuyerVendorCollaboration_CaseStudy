package teksystems.casestudy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import teksystems.casestudy.database.entity.Product;
import teksystems.casestudy.database.entity.User;
import teksystems.casestudy.service.ProductService;
import teksystems.casestudy.service.UserService;

import java.util.List;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @Autowired
    private ProductService productService;

    @GetMapping("/login/login")
    public ModelAndView login() throws Exception {
        ModelAndView response = new ModelAndView();
        response.setViewName("login/loginForm");
        return response;
    }


    @PostMapping("/login/loginSubmit")
    public ModelAndView loginSubmit(@RequestParam(value = "username", required = false) String username,
                                    @RequestParam(value = "password", required = false) String password)
                                                    throws Exception {
        ModelAndView response = new ModelAndView();
        User user = userService.validateUser(username,password);
        if (user == null)
        {
            response.setViewName("login/loginForm");
        }
        else
        {
            if(user.isBuyer())
            {
                List<String> categories = productService.getAllCategories();
                response.addObject("categories", categories);
                response.setViewName("buyer/categories");
            }
            else {
                response.setViewName("products/products");
                List<Product> products = productService.getProductsByUser(user);
                response.addObject("products", products);

            }



        }

        return response;
    }

}
