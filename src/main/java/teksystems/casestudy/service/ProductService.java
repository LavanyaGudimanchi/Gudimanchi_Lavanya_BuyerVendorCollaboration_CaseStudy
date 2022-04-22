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

    public List<Product> getProductsByCategory(String category) {

        return productdao.findByCategory(category);

    }

    public List<Product> getProductsByUser(User user) {

        return productdao.findByVendorId(user.getId());

    }
    public Product save(Product product){

        return productdao.save(product);

    }

    public void delete(Product product)
    {
         productdao.delete(product);
    }

    public Product getProductById(Integer Id){
        return productdao.getById(Id);
    }


}
