package com.solvd.travelagency.thread;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ConnectionPool {
    private static final Logger LOGGER = LogManager.getLogger(ConnectionPool.class);

    private static ConnectionPool connectionPool;
    private BlockingQueue<Connection> connections;
    private int poolSize = 5;

    private ConnectionPool() {
        this.connections = new ArrayBlockingQueue<>(poolSize);

        for (int i = 0; i < poolSize; i++) {
            Connection connection = new Connection("Conn-" + i);
            this.connections.add(connection);
        }
    }

    public static synchronized ConnectionPool getInstance() { //thread safe
        if (connectionPool == null) { //Lazy initialization
            connectionPool = new ConnectionPool();
        }
        return connectionPool;
    }

    public Connection getConnection() throws InterruptedException {
        return connections.take();
    }

    public void releaseConnection(Connection conn) {
        this.connections.offer(conn);
    }
}
