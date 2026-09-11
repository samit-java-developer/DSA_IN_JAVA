package com.samit.multithreading.advance.executors;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.*;

public class ExecutorsUtil {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        List<Future<String>> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(executorService.submit(() -> {
                Thread.sleep(2000);
                return "Hello ExecutorService";
            }));
        }
        int i = 0;
        for (Future<String> stringFuture : list) {
            System.out.println("Running: " + Thread.currentThread().getName());
            System.out.println("Output of " + (i + 1) + " " + stringFuture.get());
            i++;
        }
        executorService.shutdown();

        System.out.println("-------------You can delay task execution or schedule it periodically—useful for cron-like jobs or time-based tasks.---------------------");

        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
        scheduler.schedule(() -> {
            System.out.println("Executed after 3 seconds!");
        }, 3, TimeUnit.SECONDS);
        scheduler.shutdown();

        System.out.println("---------Monitoring and management facilities--------");
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(2);
        executor.submit(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ignored) {
            }
        });
        System.out.println("Active Threads: " + executor.getActiveCount());
        System.out.println("Queued Tasks: " + executor.getQueue().size());
        executor.shutdown();

//        ThreadPoolExecutor customPool = new ThreadPoolExecutor(
//        int corePoolSize,
//        int maximumPoolSize,
//        long keepAliveTime,
//        TimeUnit unit,
//        BlockingQueue<Runnable> workQueue
//);

        //ThreadPoolExecutor: Primary implementation of ExecutorService
        ThreadPoolExecutor customPool = new ThreadPoolExecutor(
                2, 4, 60, TimeUnit.SECONDS,
                new LinkedBlockingQueue<>()
        );

        customPool.execute(() -> System.out.println("Task in custom pool"));

        //Definition ::: ScheduledThreadPoolExecutor: Implementation of ScheduledExecutorService

       // ScheduledThreadPoolExecutor scheduledPool = new ScheduledThreadPoolExecutor(int corePoolSize);
        //ScheduledFuture<?> schedule(Runnable command, long delay, TimeUnit unit);
        ScheduledThreadPoolExecutor scheduledPool = new ScheduledThreadPoolExecutor(1);
        scheduledPool.schedule(() -> System.out.println("Scheduled once"), 5, TimeUnit.SECONDS);
        scheduledPool.shutdown();
        //  Executors: Factory class for creating executor instances
        //Essential Methods of ExecutorService

        //void execute(Runnable command) :
        ExecutorService executor5 = Executors.newFixedThreadPool(1);
        executor5.execute(() -> System.out.println("Task executed"));
        executor5.shutdown();
        //Failure Scenarios:
        //▪ If the task throws an exception, it's lost unless the thread is wrapped
        // with error logging, where the log can be made to track the same.
        //▪ You won’t know if it failed, retried, or completed — no result tracking.
        //▪ If the machine crashes or process exits, task is lost.

        //Future<?> submit :
        //✅ Success:
        //▪ Returns a Future. You can block and get the result using future.get()
        //⚠️ Failure Scenarios:
        //▪ If the task fails (e.g., throws an exception), future.get() will throw ExecutionException.
        //▪ You can still check future.isCancelled() or future.isDone().
        //▪ If machine crashes or JVM exits — in-flight tasks are lost.

        //invokeAll(Collection<? extends Callable<T>> tasks):
        //invokeAll(Collection<? extends Callable<T>> tasks):
        //✅ Success:
        //▪ Runs all tasks in parallel. Waits until all finish. You get a list of Futures.
        //⚠️ Failure Scenarios:
        //▪ If one task fails, its Future will throw an exception on get(), but others keep running.
        //▪ If the executor shuts down in the middle, only the remaining tasks are interrupted.
        //▪ Machine crash = all tasks in memory are lost.
        //Note: We also have an overloaded method invokeAll(Collection<? extends Callable<T>> tasks,
        // long timeout, TimeUnit unit)
        // that allows you to specify a timeout for the completion of all tasks.

        ExecutorService executorInvokeAll = Executors.newFixedThreadPool(2); // takes the number of threads as arguments
        // invokeAll Example
        Collection<Callable<String>> allTasks = Arrays.asList(() -> "Task 1", () -> "Task 2");
        try {
            // Process results
            List<Future<String>> results = executorInvokeAll.invokeAll(allTasks);
            // Process timeout results
            List<Future<String>> timeoutResults = executorInvokeAll.invokeAll(allTasks, 1, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
