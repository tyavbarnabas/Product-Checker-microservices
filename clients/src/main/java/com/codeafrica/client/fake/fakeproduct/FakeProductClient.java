package com.codeafrica.client.fake.fakeproduct;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("fake-product")
public interface FakeProductClient {
    @GetMapping("/api/v1/fake/{productId}")
    ProductCheckResponse<?> isFakeProduct(@PathVariable("productId") Integer productId);
}
