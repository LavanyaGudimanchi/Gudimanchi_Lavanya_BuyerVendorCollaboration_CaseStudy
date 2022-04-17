package teksystems.casestudy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import teksystems.casestudy.database.entity.Product;
import teksystems.casestudy.database.entity.User;
import teksystems.casestudy.service.ProductService;
import teksystems.casestudy.service.UserService;

import java.util.List;

@Controller
public class ProductController {
    @Autowired
    private ProductService productService;

//    @ModelAttribute
//    public void addAttributes(Model model) {
//        Product product = new Product();
//        model.addAttribute("product", product);
//    }

    @GetMapping("products/products/{category}")
    public ModelAndView productslistbyCategory(@PathVariable("category") String category) throws Exception {
        ModelAndView response = new ModelAndView();
        response.setViewName("products/products");
        List<Product> products = productService.getProductsByCategory(category);
        response.addObject("products", products);
        return response;
    }

    @GetMapping("user/addProduct")
    public ModelAndView addProduct(@ModelAttribute("product") Product product) throws Exception {
        ModelAndView response = new ModelAndView();
        response.setViewName("user/addProduct");
        List<String> categories = productService.getAllCategories();
        response.addObject("categories", categories);
        response.addObject("product", product);
        return response;
    }


    @PostMapping("user/saveProduct")
    public ModelAndView saveProduct(@ModelAttribute("product") Product product) throws Exception {
        ModelAndView response = new ModelAndView();
        response.setViewName("admin/adminHome");
        productService.save(product);
        return response;
    }

}
