package com.fourthelephant.enlighter;

import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.scheduling.annotation.Scheduled;

/**
 * @author Vadim Bobrov
 */
public interface TaskManager {
    @ManagedOperation
    void stop();

    @ManagedOperation
    void start();

    @ManagedAttribute
    int getRate();

    @ManagedAttribute
    void setRate(int rate);

    @Scheduled(fixedRate = 1000)
    void collectStats();
}
