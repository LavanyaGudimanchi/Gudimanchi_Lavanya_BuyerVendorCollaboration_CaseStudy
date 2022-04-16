package teksystems.casestudy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import teksystems.casestudy.database.entity.Product;
import teksystems.casestudy.service.ProductService;
import teksystems.casestudy.service.UserService;

import java.util.List;

@Controller
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("admin/products/{category}")
    public ModelAndView productslist(@PathVariable("category") String category) throws Exception {
        ModelAndView response = new ModelAndView();
        response.setViewName("admin/products");
        List<Product> products = productService.getProducts("Ikat");
        response.addObject("products", products);
        return response;
    }

    @GetMapping("admin/adminHome")
    public ModelAndView categoriesList() throws Exception {
        ModelAndView response = new ModelAndView();
        response.setViewName("admin/adminHome");

        List<String> categories = productService.getAllCategories();
        response.addObject("categories", categories);
        return response;
    }
}
