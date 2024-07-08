package com.challenge.magalums.scheduler;

import com.challenge.magalums.service.NotificationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

@Component
public class ScheduleTasks {

    private static final Logger logger = LoggerFactory.getLogger(ScheduleTasks.class);

    private final NotificationService notificationService;

    public ScheduleTasks(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @Scheduled(fixedDelay = 1, timeUnit = TimeUnit.MINUTES)
    public void checkTasks() {

        var dateTime = LocalDateTime.now();
        logger.info("running at {}", dateTime);

        notificationService.checkAndSendPendingNotifications(dateTime);
    }

}
