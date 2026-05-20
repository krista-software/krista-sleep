package com.krista.extensions.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for {@link SleepService}.
 *
 * @author Krista Extensions Team
 * @version 1.0.0
 */
@DisplayName("SleepService Tests")
class SleepServiceTest {

    private static final Logger log = LoggerFactory.getLogger(SleepServiceTest.class);

    private SleepService sleepService;

    @BeforeEach
    void setUp() {
        sleepService = new SleepService();
    }

    @Test
    @DisplayName("Should sleep for 1 second successfully")
    void testSleep_OneSecond() {
        // Arrange
        Double secondsToSleep = 1.0;
        long startTime = System.currentTimeMillis();

        // Act
        sleepService.sleep(secondsToSleep);

        // Assert
        long elapsedTime = System.currentTimeMillis() - startTime;
        assertTrue(elapsedTime >= 1000, "Sleep should last at least 1000ms");
        assertTrue(elapsedTime < 1200, "Sleep should not exceed 1200ms (allowing 200ms tolerance)");
        log.info("Sleep for 1 second completed in {}ms", elapsedTime);
    }

    @Test
    @DisplayName("Should sleep for 0.5 seconds successfully")
    void testSleep_HalfSecond() {
        // Arrange
        Double secondsToSleep = 0.5;
        long startTime = System.currentTimeMillis();

        // Act
        sleepService.sleep(secondsToSleep);

        // Assert
        long elapsedTime = System.currentTimeMillis() - startTime;
        assertTrue(elapsedTime >= 500, "Sleep should last at least 500ms");
        assertTrue(elapsedTime < 700, "Sleep should not exceed 700ms (allowing 200ms tolerance)");
        log.info("Sleep for 0.5 seconds completed in {}ms", elapsedTime);
    }

    @Test
    @DisplayName("Should sleep for 2.5 seconds successfully")
    void testSleep_TwoAndHalfSeconds() {
        // Arrange
        Double secondsToSleep = 2.5;
        long startTime = System.currentTimeMillis();

        // Act
        sleepService.sleep(secondsToSleep);

        // Assert
        long elapsedTime = System.currentTimeMillis() - startTime;
        assertTrue(elapsedTime >= 2500, "Sleep should last at least 2500ms");
        assertTrue(elapsedTime < 2700, "Sleep should not exceed 2700ms (allowing 200ms tolerance)");
        log.info("Sleep for 2.5 seconds completed in {}ms", elapsedTime);
    }

    @Test
    @DisplayName("Should sleep for 0 seconds (no-op)")
    void testSleep_ZeroSeconds() {
        // Arrange
        Double secondsToSleep = 0.0;
        long startTime = System.currentTimeMillis();

        // Act
        sleepService.sleep(secondsToSleep);

        // Assert
        long elapsedTime = System.currentTimeMillis() - startTime;
        assertTrue(elapsedTime < 100, "Sleep for 0 seconds should complete almost immediately");
        log.info("Sleep for 0 seconds completed in {}ms", elapsedTime);
    }

    @Test
    @DisplayName("Should handle thread interruption and throw RuntimeException")
    void testSleep_InterruptedThread() throws InterruptedException {
        // Arrange
        Double secondsToSleep = 5.0;
        Thread testThread = new Thread(() -> {
            // Act & Assert
            RuntimeException exception = assertThrows(
                RuntimeException.class,
                () -> sleepService.sleep(secondsToSleep),
                "Should throw RuntimeException when thread is interrupted"
            );

            assertNotNull(exception.getCause());
            assertTrue(exception.getCause() instanceof InterruptedException);
            log.info("Correctly handled thread interruption: {}", exception.getMessage());
        });

        // Start the thread and interrupt it
        testThread.start();
        Thread.sleep(100); // Give the thread time to start sleeping
        testThread.interrupt();
        testThread.join(2000); // Wait for thread to complete

        assertFalse(testThread.isAlive(), "Test thread should have completed");
    }

    @Test
    @DisplayName("Should handle multiple consecutive sleep calls")
    void testSleep_MultipleCalls() {
        // Arrange
        Double firstSleep = 0.1;
        Double secondSleep = 0.2;
        Double thirdSleep = 0.15;
        long startTime = System.currentTimeMillis();

        // Act
        sleepService.sleep(firstSleep);
        sleepService.sleep(secondSleep);
        sleepService.sleep(thirdSleep);

        // Assert
        long elapsedTime = System.currentTimeMillis() - startTime;
        long expectedMinTime = (long) ((firstSleep + secondSleep + thirdSleep) * 1000);
        assertTrue(elapsedTime >= expectedMinTime,
            "Total sleep time should be at least the sum of all sleep durations");
        log.info("Multiple consecutive sleeps completed in {}ms (expected at least {}ms)",
            elapsedTime, expectedMinTime);
    }
}

