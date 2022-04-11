package teksystems.casestudy.database.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import teksystems.casestudy.database.entity.Product;
import teksystems.casestudy.database.entity.User;

@Repository
public interface ProductDAO extends JpaRepository<Product, Integer> {

}
