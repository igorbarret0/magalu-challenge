package com.challenge.magalums.controller;


import com.challenge.magalums.dtos.ScheduleNotificationDto;
import com.challenge.magalums.entity.Notification;
import com.challenge.magalums.service.NotificationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/notification")
public class NotificationController {

    private final NotificationService notificationService;

    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @PostMapping
    public ResponseEntity<Void> scheduleNotification(@RequestBody ScheduleNotificationDto requestDto) {

        notificationService.scheduleNotification(requestDto);

        return ResponseEntity.accepted().build();
    }

    @GetMapping("/{notificationId}")
    public ResponseEntity<Notification> getNotification(@PathVariable(name = "notificationId")
                                                            Long notificationId) {

        var notification = notificationService.findById(notificationId);

        if (notification.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return new ResponseEntity<>(notification.get(), HttpStatus.FOUND);

    }

    @DeleteMapping("/{notificationId}")
    public ResponseEntity<Void> cancelNotification(@PathVariable(name = "notificationId")
                                                   Long id) {

        notificationService.cancelNotification(id);

        return ResponseEntity.ok().build();
    }


}
