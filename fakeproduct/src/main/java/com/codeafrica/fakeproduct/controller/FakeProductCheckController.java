package com.codeafrica.fakeproduct.controller;


import com.codeafrica.fakeproduct.response.ProductCheckResponse;
import com.codeafrica.fakeproduct.service.FakeProductCheckService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/v1/fake")
public class FakeProductCheckController {

    private final FakeProductCheckService fakeProductCheckService;

    @GetMapping("/{productId}")
    public ResponseEntity<ProductCheckResponse<?>> isFakeProduct(@PathVariable("productId") Integer productId) {
            boolean isFakeProductCheck = fakeProductCheckService.isFakeProduct(productId);
        log.info("new product check report {}",productId);
            return new ResponseEntity<>(new ProductCheckResponse<>(
                    "check on product has been completed Successfully ", "is product a fake" ,false), HttpStatus.OK);
    }
}
