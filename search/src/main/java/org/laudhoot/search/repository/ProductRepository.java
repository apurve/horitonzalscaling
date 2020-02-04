package org.laudhoot.search.repository;

import org.laudhoot.search.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

    Product findByDescription(String description);

}
