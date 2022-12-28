package com.codeafrica.product.repository;

import com.codeafrica.product.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product,Integer> {


    Product findByNafdacRegNum(String reg);
}
