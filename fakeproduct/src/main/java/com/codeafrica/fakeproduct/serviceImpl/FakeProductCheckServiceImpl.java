package com.codeafrica.fakeproduct.serviceImpl;

import com.codeafrica.fakeproduct.model.FakeProductCheck;
import com.codeafrica.fakeproduct.repository.FakeProductCheckRepository;
import com.codeafrica.fakeproduct.service.FakeProductCheckService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class FakeProductCheckServiceImpl implements FakeProductCheckService {

    private final FakeProductCheckRepository fakeProductCheckRepository;

    public boolean isFakeProduct(Integer productId){
        fakeProductCheckRepository.save(
                FakeProductCheck.builder()
                        .productId(productId)
                        .isFakeProduct(false)
                        .createdAt(LocalDateTime.now())
                        .build()
                );

        return false;
    }
}
