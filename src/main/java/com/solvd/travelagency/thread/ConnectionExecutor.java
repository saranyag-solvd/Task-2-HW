package com.solvd.travelagency.thread;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.*;

public class ConnectionExecutor {
    private static final Logger LOGGER = LogManager.getLogger(ConnectionExecutor.class);

    private ConnectionPool connectionPool = ConnectionPool.getInstance();

    public void executeThreads(){
        int threadSize = 7;

        for (int i = 0; i < threadSize; i++) {
            Thread thread = new Thread(() -> {
                Connection connection = null;
                try {
                    connection = connectionPool.getConnection();
                    connection.setThreadName(Thread.currentThread().getName());
                    connection.connect();
                    Thread.sleep(2000); // sleep for 2 secs
                    connection.doStuff();
                } catch (InterruptedException e) {
                    LOGGER.error("Exception :" + e.getMessage());
                } finally {
                    connection.close();
                    connectionPool.releaseConnection(connection);
                }
            });

            thread.setName("ThreadUsingCP-" + i);
            thread.start();
        }
    }

    public void executeCompletableFutures() {
        int threadSize = 7;

        CompletableFuture[] futures = new CompletableFuture[threadSize];
        for (int i = 0; i < threadSize; i++) {
            CompletableFuture<Void> completableFuture = CompletableFuture.runAsync(() -> {
                Connection connection = null;
                try {
                    connection = connectionPool.getConnection();
                    connection.setThreadName(Thread.currentThread().getName());
                    connection.connect();
                    Thread.sleep(2000); // sleep for 2 secs
                    connection.doStuff();
                } catch (InterruptedException e) {
                    LOGGER.error("Exception :" + e.getMessage());
                } finally {
                    connection.close();
                    connectionPool.releaseConnection(connection);
                }
            });
            futures[i] = completableFuture;
        }
        CompletableFuture<Void> combinedFuture = CompletableFuture.allOf(futures);
        combinedFuture.join();
    }

    public void executeExecutorService(){
        int threadSize = 7;
        ExecutorService executor = Executors.newFixedThreadPool(threadSize);
        for (int i = 0; i < threadSize; i++) {
            Future future = executor.submit(() -> {
                Connection connection = null;
                try {
                    connection = connectionPool.getConnection();
                    connection.setThreadName(Thread.currentThread().getName());
                    connection.connect();
                    Thread.sleep(2000); // sleep for 2 secs
                    connection.doStuff();
                } catch (InterruptedException e) {
                    LOGGER.error("Exception :" + e.getMessage());
                } finally {
                    connection.close();
                    connectionPool.releaseConnection(connection);
                }
            });
        }
        executor.shutdown();
    }

}
