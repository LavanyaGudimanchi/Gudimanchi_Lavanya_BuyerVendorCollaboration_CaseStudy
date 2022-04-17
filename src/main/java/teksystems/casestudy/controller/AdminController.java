package teksystems.casestudy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import teksystems.casestudy.service.ProductService;

import java.util.List;

@Controller
public class AdminController {

    @Autowired
    private ProductService productService;

    @GetMapping("admin/adminHome")
    public ModelAndView categoriesList() throws Exception {
        ModelAndView response = new ModelAndView();
        response.setViewName("admin/adminHome");
        List<String> categories = productService.getAllCategories();
        response.addObject("categories", categories);
        return response;
    }
}
