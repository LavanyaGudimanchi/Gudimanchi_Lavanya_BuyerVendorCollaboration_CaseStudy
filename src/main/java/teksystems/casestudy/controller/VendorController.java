package teksystems.casestudy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import teksystems.casestudy.database.entity.Product;
import teksystems.casestudy.service.ProductService;

import java.util.List;

@Controller
public class VendorController {

    @Autowired
    private ProductService productService;

    @GetMapping("vendor/addProduct")
    public ModelAndView addProduct(@ModelAttribute("product") Product product) throws Exception {
        ModelAndView response = new ModelAndView();
        response.setViewName("vendor/addProduct");
        List<String> categories = productService.getAllCategories();
        response.addObject("categories", categories);
        response.addObject("product", product);
        return response;
    }


    @PostMapping("vendor/saveProduct")
    public ModelAndView saveProduct(@ModelAttribute("product") Product product) throws Exception {
        ModelAndView response = new ModelAndView();
        response.setViewName("products/products");
        productService.save(product);
        return response;
    }

}
