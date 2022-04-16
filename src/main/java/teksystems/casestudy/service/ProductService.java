package teksystems.casestudy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import teksystems.casestudy.database.dao.ProductDAO;
import teksystems.casestudy.database.entity.Product;
import teksystems.casestudy.database.entity.User;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductDAO productdao;

    public List<Product> getProducts(String category) {

        return productdao.findByCategory(category);

    }
}
