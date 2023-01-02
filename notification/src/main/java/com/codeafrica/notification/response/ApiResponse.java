package com.codeafrica.notification.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ApiResponse<T> {
    private boolean Success;
    private String Message;
    private T data;
}
