package org.laudhoot.search.repository;

import org.laudhoot.search.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByDescription(String description);

}
