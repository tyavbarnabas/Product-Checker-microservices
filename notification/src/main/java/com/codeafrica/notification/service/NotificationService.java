package com.codeafrica.notification.service;

import com.codeafrica.notification.dto.NotificationRequest;

public interface NotificationService {

    void send(NotificationRequest notificationRequest);
}
