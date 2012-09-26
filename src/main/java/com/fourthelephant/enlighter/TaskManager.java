package com.fourthelephant.enlighter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.jmx.export.notification.NotificationPublisher;
import org.springframework.jmx.export.notification.NotificationPublisherAware;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.management.Notification;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author Vadim Bobrov
 */
@Service
@ManagedResource
public class TaskManager  implements NotificationPublisherAware {

    private static final Logger logger = LoggerFactory.getLogger(TaskManager.class);

    private int rate = 1000;

    private final AtomicLong notificationSequence = new AtomicLong();
    private NotificationPublisher notificationPublisher;

    @Override
    public void setNotificationPublisher(
            final NotificationPublisher notificationPublisher) {
        this.notificationPublisher = notificationPublisher;
    }

    @ManagedOperation
    public void stop() {
    }

    @ManagedOperation
    public void start() {
    }

    private void sendNotification(String message){
        if (notificationPublisher != null) {
            final Notification notification = new Notification("type",
                    getClass().getName(),
                    notificationSequence.getAndIncrement(), message);
            notificationPublisher.sendNotification(notification);
        }
    }

    @ManagedAttribute
    public int getRate() {
        return rate;
    }

    @ManagedAttribute
    public void setRate(int rate) {
        this.rate = rate;
    }

    @Scheduled(fixedRate = 1000)
    public void collectStats(){
        logger.debug("calling scheduled method");
        sendNotification("calling scheduled method");
        retrieveStat();
    }

    @Async
    private Future<Long> retrieveStat() {
        logger.debug("running in a new thread");
        return new AsyncResult<Long>(11L);
    }
}
