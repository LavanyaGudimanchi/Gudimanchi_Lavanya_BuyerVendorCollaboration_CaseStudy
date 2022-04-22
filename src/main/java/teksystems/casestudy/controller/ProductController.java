package teksystems.casestudy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import teksystems.casestudy.database.entity.Product;
import teksystems.casestudy.database.entity.User;
import teksystems.casestudy.security.AuthenticatedUserService;
import teksystems.casestudy.service.ProductService;
import teksystems.casestudy.service.UserService;

import javax.validation.Valid;
import java.util.List;

@Controller
public class ProductController {
    @Autowired
    private ProductService productService;

    @Autowired
    private AuthenticatedUserService authenticatedUserService;

    @GetMapping("products/products/{category}")
    public ModelAndView productslistbyCategory(@PathVariable("category") String category) throws Exception {
        ModelAndView response = new ModelAndView();
        response.setViewName("products/products");
        List<Product> products = productService.getProductsByCategory(category);
        response.addObject("products", products);
        return response;
    }

    @GetMapping("products/products")
    public ModelAndView productslistbyUser()  throws Exception {

        return returnProductsByUser();
    }

    @GetMapping("vendor/addProduct")
    public ModelAndView addProduct(@ModelAttribute("product") Product product) throws Exception {
        ModelAndView response = new ModelAndView();
        response.setViewName("vendor/addProduct");
        List<String> categories = productService.getAllCategories();
        response.addObject("categories", categories);
        response.addObject("product", product);
        return response;
    }

    @GetMapping("vendor/addProduct/{productId}")
    public ModelAndView editProduct(@PathVariable("productId") Integer productId) throws Exception {
        ModelAndView response = new ModelAndView();
        response.setViewName("vendor/addProduct");
        List<String> categories = productService.getAllCategories();
        response.addObject("categories", categories);
        response.addObject("product", productService.getProductById(productId));
        return response;
    }

    @RequestMapping(value = "vendor/saveProduct", method=RequestMethod.POST, params = "save")
    public ModelAndView saveProduct(@ModelAttribute("product") Product product) throws Exception {
        product.setVendor(authenticatedUserService.getCurrentUser());
        productService.save(product);
        return returnProductsByUser();
    }

    @RequestMapping(value = "vendor/saveProduct", method=RequestMethod.POST, params = "delete")
    public ModelAndView deleteProduct(@Valid @ModelAttribute("product") Product product, BindingResult bindingResult) throws Exception {

        if (bindingResult.hasErrors())
        {
            ModelAndView response = new ModelAndView();
            response.setViewName("vendor/addProduct");
            List<String> categories = productService.getAllCategories();
            response.addObject("categories", categories);
            response.addObject("product", productService.getProductById(product.getId()));
            response.addObject("bindingResult", bindingResult);
            return response;

        }
        productService.delete(product);
        return returnProductsByUser();
    }

    private ModelAndView returnProductsByUser()
    {
        ModelAndView response = new ModelAndView();
        response.setViewName("products/products");
        List<Product> products = productService.getProductsByUser(authenticatedUserService.getCurrentUser());
        response.addObject("products", products);
        return response;
    }




}
