package com.codeafrica.product.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductCheckResponse<T> {

    private boolean isFakeProduct;
    private String Message;
    private T data;
}
