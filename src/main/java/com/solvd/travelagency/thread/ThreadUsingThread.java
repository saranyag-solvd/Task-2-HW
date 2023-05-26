package com.solvd.travelagency.thread;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ThreadUsingThread extends Thread {
    private static final Logger LOGGER = LogManager.getLogger(ThreadUsingThread.class);

    @Override
    public void run() {
        super.run();
        LOGGER.debug("Running Thread by Extending Thread :" + Thread.currentThread());
    }
}
