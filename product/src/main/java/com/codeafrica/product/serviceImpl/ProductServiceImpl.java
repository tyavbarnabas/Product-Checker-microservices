package com.codeafrica.product.serviceImpl;

import com.codeafrica.client.fake.fakeproduct.FakeProductClient;
import com.codeafrica.client.fake.notification.NotificationClient;
import com.codeafrica.client.fake.notification.NotificationRequest;
import com.codeafrica.client.fake.fakeproduct.ProductCheckResponse;
import com.codeafrica.product.dto.ProductRegistrationRequest;
import com.codeafrica.product.model.Product;
import com.codeafrica.product.repository.ProductRepository;
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
    private final FakeProductClient fakeProductClient;
    private final NotificationClient notificationClient;

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


        ProductCheckResponse<?> productCheckResponse = fakeProductClient.isFakeProduct(product.getId());

        assert productCheckResponse != null;
        if(productCheckResponse.isFakeProduct()){
                    throw new IllegalStateException("it is a fake Product");
                }
        //todo:make it async. i.e add to queue
        notificationClient.sendNotification(
                new NotificationRequest(
                        product.getId(),
                        product.getNafdacRegNum(),
                        String.format("Hi %s, welcome to codeafrca...",
                                product.getName())
                )
        );
        return product;

    }
}
