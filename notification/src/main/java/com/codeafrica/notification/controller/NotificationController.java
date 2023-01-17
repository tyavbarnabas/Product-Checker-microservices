package com.codeafrica.notification.controller;

import com.codeafrica.notification.dto.NotificationRequest;
import com.codeafrica.notification.response.ApiResponse;
import com.codeafrica.notification.service.NotificationService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@Slf4j
@RequestMapping("/api/v1/notification")
public class NotificationController {
    private final NotificationService notificationService;

    @PostMapping
    public ResponseEntity<ApiResponse<?>> sendNotification(@RequestBody NotificationRequest notificationRequest) {
        log.info("New notification... {}", notificationRequest);
        try {
            notificationService.send(notificationRequest);
            return new ResponseEntity<>(new ApiResponse<>(true,
                     notificationRequest.getMessage() , notificationRequest), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(new ApiResponse<>(false,e.getMessage(),"Notification could not be sent"),HttpStatus.CONFLICT);
        }
    }

}
