package com.challenge.magalums.service;

import com.challenge.magalums.dtos.ScheduleNotificationDto;
import com.challenge.magalums.entity.Notification;
import com.challenge.magalums.entity.Status;
import com.challenge.magalums.repository.NotificationRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.ToDoubleBiFunction;

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

    public void cancelNotification(Long id) {

        var foundNotification = findById(id);

        if (foundNotification.isPresent()) {
            foundNotification.get().setStatus(Status.Values.CANCELED.toStatus());
            notificationRepository.save(foundNotification.get());
        }
    }

    public void checkAndSendPendingNotifications(LocalDateTime dateTime) {

        var notifications = notificationRepository.findByStatusInAndDateTimeBefore(List.of(
                Status.Values.PENDING.toStatus(),
                Status.Values.ERROR.toStatus()
        ), dateTime);

        notifications.forEach(sendNotification());
    }

    private Consumer<Notification> sendNotification() {

        return n -> {
          // TODO - realize the send notification

            n.setStatus(Status.Values.SUCCESS.toStatus());
            notificationRepository.save(n);
        };
    }

}
