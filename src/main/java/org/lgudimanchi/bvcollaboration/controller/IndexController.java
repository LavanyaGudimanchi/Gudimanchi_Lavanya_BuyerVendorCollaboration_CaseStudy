package org.lgudimanchi.bvcollaboration.controller;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;


@Slf4j
@Controller
public class IndexController {
    public static final Logger LOG = LoggerFactory.getLogger(IndexController.class);


    @GetMapping(value = "/")
    public ModelAndView main() throws Exception {
        ModelAndView response = new ModelAndView();
        response.setViewName("index/index");
        return response;

    }






}
