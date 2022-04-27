package org.lgudimanchi.bvcollaboration.controller;

import org.lgudimanchi.bvcollaboration.database.entity.Product;
import org.lgudimanchi.bvcollaboration.database.entity.User;
import org.lgudimanchi.bvcollaboration.security.AuthenticatedUserService;
import org.lgudimanchi.bvcollaboration.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.lgudimanchi.bvcollaboration.service.ProductService;

import javax.validation.Valid;
import java.util.List;

@Controller
public class ProductController {
    @Autowired
    private ProductService productService;

    @Autowired
    private UserService userService;

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
    public ModelAndView productslistbyUser() throws Exception {

        return returnProductsByUser(authenticatedUserService.getCurrentUser());
    }

    @GetMapping("products/search")
    public ModelAndView productslistbyVendor(@RequestParam(value = "firstName", required = false) String firstName) throws Exception {

        User vendor = userService.findByFirstName(firstName);
        return returnProductsByUser(vendor);
    }

    //Add product
    @GetMapping("vendor/addProduct")
    public ModelAndView addProduct(@ModelAttribute("product") Product product) throws Exception {
        ModelAndView response = new ModelAndView();
        response.setViewName("vendor/addProduct");
        response.addObject("product", product);
        return response;
    }

    //Editing the product
    @GetMapping("vendor/addProduct/{productId}")
    public ModelAndView editProduct(@PathVariable("productId") Integer productId) throws Exception {
        ModelAndView response = new ModelAndView();
        response.setViewName("vendor/addProduct");
        response.addObject("product", productService.getProductById(productId));
        return response;
    }

    @RequestMapping(value = "vendor/saveProduct", method = RequestMethod.POST, params = "save")
    public ModelAndView saveProduct(@ModelAttribute("product") Product product) throws Exception {
        product.setVendor(authenticatedUserService.getCurrentUser());
        productService.save(product);
        return returnProductsByUser(authenticatedUserService.getCurrentUser());
    }

    @RequestMapping(value = "vendor/saveProduct", method = RequestMethod.POST, params = "delete")
    public ModelAndView deleteProduct(@Valid @ModelAttribute("product") Product product, BindingResult bindingResult) throws Exception {

        if (bindingResult.hasErrors()) {
            ModelAndView response = new ModelAndView();
            response.setViewName("vendor/addProduct");
            response.addObject("product", productService.getProductById(product.getId()));
            response.addObject("bindingResult", bindingResult);
            return response;

        }
        productService.delete(product);
        return returnProductsByUser(authenticatedUserService.getCurrentUser());
    }

    private ModelAndView returnProductsByUser(User user) {
        ModelAndView response = new ModelAndView();
        response.setViewName("products/products");
        List<Product> products = productService.getProductsByUser(user);
        response.addObject("products", products);
        return response;
    }

}
