package teksystems.casestudy.controller;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import teksystems.casestudy.database.dao.UserDAO;
import teksystems.casestudy.database.entity.User;
import teksystems.casestudy.validation.EmailUniqueImpl;

import java.io.File;
import java.util.List;



@Slf4j
@Controller
public class IndexController {
    public static final Logger LOG = LoggerFactory.getLogger(IndexController.class);

    @Autowired
    private UserDAO userDao;

    @GetMapping(value = "/")
    public ModelAndView main() throws Exception {
        ModelAndView response = new ModelAndView();
        response.setViewName("index/index");
        return response;

    }






}
