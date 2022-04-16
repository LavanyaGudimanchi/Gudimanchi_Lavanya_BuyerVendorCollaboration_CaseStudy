package teksystems.casestudy.database.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import teksystems.casestudy.database.entity.Product;
import teksystems.casestudy.database.entity.User;

import java.util.List;

@Repository
public interface ProductDAO extends JpaRepository<Product, Integer> {

    List<Product> findByCategory(String category);

}
