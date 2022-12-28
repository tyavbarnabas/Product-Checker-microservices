package com.codeafrica.product.serviceImpl;

import com.codeafrica.product.dto.ProductRegistrationRequest;
import com.codeafrica.product.model.Product;
import com.codeafrica.product.repository.ProductRepository;
import com.codeafrica.product.response.ProductCheckResponse;
import com.codeafrica.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final RestTemplate restTemplate;

    @Override
    public Product registerProduct(ProductRegistrationRequest request) {
        if(Objects.nonNull(productRepository.findByNafdacRegNum(request.getNafdacRegNum()))){
            throw new IllegalArgumentException("Product with NAFDAC RegNum " + request.getNafdacRegNum()+ " already exist");
        }
        Product product = Product.builder()
                .name(request.getName())
                .price(request.getPrice())
                .produceDate(LocalDateTime.now())
                .nafdacRegNum(request.getNafdacRegNum())
                .build();

        //todo:check if nafdac regNum is valid
        //todo:check if nafdac regNum is not taken
        //todo:check if product is fake
              productRepository.saveAndFlush(product);
         //todo:send notification

                ProductCheckResponse<?> productCheckResponse = restTemplate.getForObject(
                        "http://localhost:9091/api/v1/fake/{productId}",
                        ProductCheckResponse.class,product.getId());

        assert productCheckResponse != null;
        if(productCheckResponse.isFakeProduct()){
                    throw new IllegalStateException("it is a fake Product");
                }

        return product;

    }
}
