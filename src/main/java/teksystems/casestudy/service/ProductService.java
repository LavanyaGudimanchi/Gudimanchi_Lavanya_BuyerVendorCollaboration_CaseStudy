package teksystems.casestudy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import teksystems.casestudy.database.dao.ProductDAO;

@Service
public class ProductService {

    @Autowired
    private ProductDAO productdao;
}
