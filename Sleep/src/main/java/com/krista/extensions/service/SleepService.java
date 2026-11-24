/*
 * Sleep Extension for Krista
 * Copyright (C) 2025 Krista Software
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

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

