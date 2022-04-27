package org.lgudimanchi.bvcollaboration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import org.lgudimanchi.bvcollaboration.service.ProductService;

@Controller
public class BuyerController {

    @Autowired
    private ProductService productService;

    @PreAuthorize("hasAuthority('BUYER')")
    @GetMapping("buyer/categories")
    public ModelAndView categoriesList() throws Exception {
        ModelAndView response = new ModelAndView();
        response.setViewName("buyer/categories");
        return response;
    }
}
