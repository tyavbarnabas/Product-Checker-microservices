package com.codeafrica.fakeproduct.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductCheckResponse<T> {
    private String Message;
    private T data;
    private boolean isFakeProduct;
}
