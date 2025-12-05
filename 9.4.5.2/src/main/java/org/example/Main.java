package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) {
        System.out.println("Main class started");

        // gettingStarted();
        // nameWithThread();
        // withExecutor();
        // representConcurrentTaskAsVirtualThread();
        // limitConcurrency();
        limitConcurrencyDatabase();


    }

    private static void limitConcurrencyDatabase() {

        try (ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor()) {
            long now = System.nanoTime();
            for (int i = 0; i < 100; i++) {
                executor.submit(() -> {
                    try {
                        executeDatabaseReal(now);
                    } catch (ClassNotFoundException | SQLException e) {
                        throw new RuntimeException(e);
                    }
                });
            }
        }

    }

    private static void executeDatabaseReal(long now) throws ClassNotFoundException, SQLException {
        Connection connection = DBCPDataSource.getConnection(); // 최대 10개의 Connection을 허용
        System.out.println("Connected : " + (System.nanoTime() - now) / 1000000 + "ms");

        PreparedStatement statement = connection.prepareStatement("select sleep(5)");
        statement.executeQuery();
        statement.close();
        connection.close();
    }


    private static void limitConcurrency() throws InterruptedException {
        // Bad
//        ExecutorService es = Executors.newFixedThreadPool(10);
//        for (int i = 0; i < 100; i++) {
//            es.submit(() -> {
//                try {
//                    executeDatabase();
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
//            });
//        }

        // Good
        Semaphore semaphore = new Semaphore(10); // 10개의 Virtual thread만 허용

        try (ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor()) {
            for (int i = 0; i < 100; i++) {
                executor.submit(() -> {
                    try {
                        semaphore.acquire(); // semaphore를 획득
                        executeDatabase();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    } finally {
                        semaphore.release(); // semaphore를 반환
                    }
                });
            }
        }


    }

    private static void executeDatabase() throws InterruptedException {
        System.out.printf("Thread ID: %d, Thread Name: %s\n", Thread.currentThread().threadId(), Thread.currentThread().getName());
        Thread.sleep(3000);
    }

    private static void representConcurrentTaskAsVirtualThread() {

        // Bad
        ExecutorService sharedThreadPool = Executors.newFixedThreadPool(10);
        Future<String> f1 = sharedThreadPool.submit(() -> "Hello thread No. 1");
        Future<String> f2 = sharedThreadPool.submit(() -> "Hello thread No. 2");

        try {
            System.out.println(f1.get());
            System.out.println(f2.get());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        // Good
        try (ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor()) {
            Future<String> f3 = executor.submit(() -> "Hello Virtual thread No. 3"); // Virtual thread 생성
            Future<String> f4 = executor.submit(() -> "Hello Virtual thread No. 4"); // Virtual thread 생성

            System.out.println(f3.get());
            System.out.println(f4.get());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    private static void gettingStarted() throws InterruptedException {


        Thread thread = Thread.ofVirtual() // Thread.Builder instance 생성
                .start(() -> System.out.println("Hello"));

        thread.join(); // Waits for this thread to terminate.


        String threadName = "thread No.1";
        Thread.Builder builder = Thread.ofVirtual().name(threadName); // Thread.Builder instance 생성
        Runnable task = () -> System.out.println("Running thread");

        Thread t = builder.start(task); // Runnable을 Thread에 등록하고 Thread를 실행

        System.out.println("Running thread name : " + t.getName()); // Running thread name : thread No.1

        t.join();
    }

    private static void withExecutor() {
        try (ExecutorService myExecutor = Executors.newVirtualThreadPerTaskExecutor()) {

            Future<?> future = myExecutor.submit(() -> System.out.println("Running thread"));
            future.get();
            System.out.println("Task completed");

            // some task

            Future<?> future2 = myExecutor.submit(() -> System.out.println("Running thread2 something else"));
            future2.get();
            System.out.println("Task completed2");

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static void nameWithThread() throws InterruptedException {

        Thread.Builder builder = Thread.ofVirtual().name("worker-", 0); // worker-0, worker-1, worker-2, ...
        Runnable task = () -> {
            System.out.println("Thread ID: " + Thread.currentThread().threadId());
        };

        // name "worker-0"
        Thread t1 = builder.start(task);
        t1.join();
        System.out.println(t1.getName() + " terminated");

        // name "worker-1"
        Thread t2 = builder.start(task);
        t2.join();
        System.out.println(t2.getName() + " terminated");

    }

}
