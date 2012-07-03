package com.fourthelephant.enlighter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.concurrent.Future;

/**
 * @author Vadim Bobrov
 */
@Service
public class TaskManager {

    private static final Logger logger = LoggerFactory.getLogger(TaskManager.class);

    @Scheduled(fixedRate = 1000)
    public void collectStats(){
        logger.debug("calling scheduled method");
        retrieveStat();
    }

    @Async
    private Future<Long> retrieveStat() {
        logger.debug("running in a new thread");
        return new AsyncResult<Long>(11L);
    }
}
