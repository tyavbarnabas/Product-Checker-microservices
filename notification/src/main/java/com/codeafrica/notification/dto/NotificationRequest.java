package com.codeafrica.notification.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class NotificationRequest{
        private Integer toProductId;
        private String toNafdacRegNum;
        private String message;

}
