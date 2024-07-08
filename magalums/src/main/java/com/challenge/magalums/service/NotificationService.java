package com.challenge.magalums.service;

import com.challenge.magalums.dtos.ScheduleNotificationDto;
import com.challenge.magalums.entity.Notification;
import com.challenge.magalums.repository.NotificationRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class NotificationService {

    private NotificationRepository notificationRepository;

    public NotificationService(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    public void scheduleNotification(ScheduleNotificationDto requestDto) {

        notificationRepository.save(requestDto.toNotificationEntity());
    }

    public Optional<Notification> findById(Long notificationId) {

        return notificationRepository.findById(notificationId);

    }

}
