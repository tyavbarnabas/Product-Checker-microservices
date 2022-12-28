package com.codeafrica.product.controller;

import com.codeafrica.product.dto.ProductRegistrationRequest;
import com.codeafrica.product.model.Product;
import com.codeafrica.product.response.ApiResponse;
import com.codeafrica.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class ProductController {

    private final ProductService productService;

    @PostMapping("/product")
    public ResponseEntity<ApiResponse<?>> registerProduct(@RequestBody ProductRegistrationRequest request){
        log.info("new  product registration {}" ,request);
        try {
            Product product = productService.registerProduct(request);
            return new ResponseEntity<>(new ApiResponse<>(true,
                    "The Product," + request.getName() + " Was Registered Successfully ",product), HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(new ApiResponse<>(false,e.getMessage(),"Wrong RegNum"),HttpStatus.CONFLICT);
        }
    }


}
