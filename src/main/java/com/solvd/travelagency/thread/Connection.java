package com.solvd.travelagency.thread;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Connection {
    private static final Logger LOGGER = LogManager.getLogger(Connection.class);

    private String id;
    private boolean inUse = false;
    private String threadName = Thread.currentThread().getName();

    public Connection(String id) {
        this.id = id;
    }

    public void setThreadName(String threadName) {
        this.threadName = threadName;
    }

    public void connect() {
        this.inUse = true;
        LOGGER.debug(this.threadName + " GOT Connection :" + id + " >>>>>>>>");
    }

    public void close() {
        this.inUse = false;
        LOGGER.debug(this.threadName + " CLOSED Connection :" + id + " ###");
    }

    public void doStuff() {
        if (this.isConnectionInUse()) {
            LOGGER.debug(this.threadName + " Operation completed :" + id);
        } else {
            LOGGER.debug(this.threadName + " Operation NOT performed. Connection is not Active :" + id);
        }

    }

    public boolean isConnectionInUse() {
        return this.inUse;
    }
}
