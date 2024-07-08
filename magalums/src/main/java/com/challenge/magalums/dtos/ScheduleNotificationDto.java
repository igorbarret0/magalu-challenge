package com.challenge.magalums.dtos;

import com.challenge.magalums.entity.Channel;
import com.challenge.magalums.entity.Notification;
import com.challenge.magalums.entity.Status;

import java.time.LocalDateTime;

public record ScheduleNotificationDto(
        LocalDateTime dateTime,
        String destination,
        String message,
        Channel.Values channel
) {

    public Notification toNotificationEntity() {
        return new Notification(dateTime, destination, message, channel.toChannel(), Status.Values.PENDING.toStatus());
    }

}
