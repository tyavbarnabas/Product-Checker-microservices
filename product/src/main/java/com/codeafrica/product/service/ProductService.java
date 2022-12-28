package com.codeafrica.product.service;

import com.codeafrica.product.dto.ProductRegistrationRequest;
import com.codeafrica.product.model.Product;

import java.util.Optional;

public interface ProductService{

    Product registerProduct(ProductRegistrationRequest Request);


}
