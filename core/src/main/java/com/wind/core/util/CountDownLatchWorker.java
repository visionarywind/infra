package com.wind.core.util;

import com.google.common.base.Preconditions;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by shanfeng on 2018/7/4.
 */
public class CountDownLatchWorker {
    private static final Logger logger = LogManager.getLogger(CountDownLatchWorker.class);

    private final CountDownLatch startGate;
    private final CountDownLatch endGate;
    private final AtomicInteger workerCounter;

    public static int DEFAULT_START_GATE_NUM = 1;

    public CountDownLatchWorker(int waiterNum, int workerNum) {
        startGate = new CountDownLatch(waiterNum);
        endGate = new CountDownLatch(workerNum);
        workerCounter = new AtomicInteger();
    }

    public CountDownLatchWorker(int workerNum) {
        this(DEFAULT_START_GATE_NUM, workerNum);
    }

    public void start() {
        logger.debug("start");
        Preconditions.checkState(workerCounter.get() == endGate.getCount());
        startGate.countDown();
    }

    public <V> Callable<V> wrap(Callable<V> task) {
        return () -> {
            workerCounter.getAndIncrement();
            try {
                startGate.await();
                logger.debug("task start");
                return task.call();
            } finally {
                endGate.countDown();
                logger.debug("task end");
            }
        };
    }

    public <V> FutureTask<V> submit(Callable<V> task) throws Exception {
        logger.debug("submit");
        FutureTask<V> futureTask = new FutureTask<V>(wrap(task));
        new Thread(futureTask).start();
        return futureTask;
    }


    public <V> FutureTask<V> safeSubmit(Callable<V> task) {
        try {
            return submit(task);
        } catch (Exception e) {
            logger.error("safeSubmit failed", e);
            return null;
        }
    }

    public void await() throws InterruptedException {
        logger.debug("await");
        endGate.await();
    }

    public void run() throws InterruptedException {
        start();
        await();
    }
}
