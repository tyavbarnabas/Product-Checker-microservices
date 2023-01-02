package com.codeafrica.notification.serviceImpl;

import com.codeafrica.notification.dto.NotificationRequest;
import com.codeafrica.notification.model.Notification;
import com.codeafrica.notification.repository.NotificationRepository;
import com.codeafrica.notification.service.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class NotificationServiceImpl implements NotificationService {

    private final NotificationRepository notificationRepository;
    @Override
    public void send(NotificationRequest notificationRequest) {
        notificationRepository.save(
                Notification.builder()
                        .toProductId(notificationRequest.getToProductId())
                        .toNafdacRegNum(notificationRequest.getToNafdacRegNum())
                        .sender("codeafrica")
                        .message(notificationRequest.getMessage())
                        .sentAt(LocalDateTime.now())
                        .build()
        );
    }
}
