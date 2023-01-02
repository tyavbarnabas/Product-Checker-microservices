package com.codeafrica.client.fake.notification;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class NotificationRequest {
        private Integer toProductId;
        private String toNafdacRegNum;
        private String message;

}
