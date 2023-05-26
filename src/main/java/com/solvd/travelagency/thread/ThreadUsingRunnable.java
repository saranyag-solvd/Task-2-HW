package com.solvd.travelagency.thread;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ThreadUsingRunnable implements Runnable {
    private static final Logger LOGGER = LogManager.getLogger(ThreadUsingRunnable.class);

    @Override
    public void run() {
        LOGGER.debug("Running Thread by Implementing Runnable :" + Thread.currentThread());
    }
}
