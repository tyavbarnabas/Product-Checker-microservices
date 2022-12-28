package com.codeafrica.product.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductRegistrationRequest{

    private String name;
    private Float price;
    private LocalDateTime produceDate;
    private String nafdacRegNum;


}
