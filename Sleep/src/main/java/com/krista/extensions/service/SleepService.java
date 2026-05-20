package com.krista.extensions.service;

import org.jvnet.hk2.annotations.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Service for handling sleep/pause operations in conversations.
 *
 * <p>This service provides functionality to pause execution for a specified
 * duration, useful for introducing delays in conversation flows.</p>
 *
 * @author Krista Extensions Team
 * @version 1.0.0
 * @since 1.0.0
 */
@Service
public class SleepService {

    private static final Logger log = LoggerFactory.getLogger(SleepService.class);

    /**
     * Pauses execution for the specified number of seconds.
     *
     * @param secondsToSleep the number of seconds to sleep
     * @throws RuntimeException if the sleep operation is interrupted
     */
    public void sleep(Double secondsToSleep) {
        try {
            long milliseconds = (long) (secondsToSleep * 1000);
            log.info("sleep() about to sleep for {} milliseconds", milliseconds);
            Thread.sleep(milliseconds);
            log.info("sleep() awake after {} milliseconds", milliseconds);
        } catch (InterruptedException cause) {
            Thread.currentThread().interrupt();
            log.error(cause.getMessage(), cause);
            throw new RuntimeException(cause.getMessage(), cause);
        }
    }
}

