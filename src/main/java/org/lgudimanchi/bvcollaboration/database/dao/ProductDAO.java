package org.lgudimanchi.bvcollaboration.database.dao;

import org.lgudimanchi.bvcollaboration.database.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductDAO extends JpaRepository<Product, Integer> {

    List<Product> findByCategory(String category);

    @Query("select p from Product p where p.vendor.id = ?1")
    List<Product> findByVendorId(Integer vendorId);



}
