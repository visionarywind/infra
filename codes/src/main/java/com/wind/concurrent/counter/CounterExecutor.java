package com.wind.concurrent.counter;

import java.util.Arrays;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.FutureTask;
import java.util.function.Function;

public class CounterExecutor {
    public void start() {
        long[] counts = { 10_000L, 10_000_000L };
        Arrays.stream(counts).forEach(count -> {
            System.out.println("Start to test count : " + count);
            try {
                execute(new VolatileCounter(), count, String::valueOf);
                execute(new SampleCounter(), count, String::valueOf);
                execute(new SynchronizedObjectCounter(), count, String::valueOf);
                execute(new ReentrantLockCounter(), count, String::valueOf);
                execute(new ReentrantReadLockCounter(), count, String::valueOf);
                execute(new StampedLockCounter(), count, String::valueOf);
                execute(new AtomicLongCounter(), count, String::valueOf);
                execute(new HashAtomicLongCounter(), count, String::valueOf);
                execute(new AtomicLongAdderCounter(), count, String::valueOf);

                System.out.println("-------- multi keys --------");
                HashCounter counter = new HashCounter();
                execute(counter, count, String::valueOf);
                execute(new ConcurrentHashCounter(), count, String::valueOf);
                execute(new GuavaCacheCounter(), count, String::valueOf);
            } catch (Exception e) { e.printStackTrace(); }
            System.out.println();
        });
    }

    public void execute(Counter calculator, long count, Function<Long, String> transformer) throws Exception {
        String name = calculator.getClass().getSimpleName();
        int threadCount = Runtime.getRuntime().availableProcessors();
        long countP = count / threadCount;
        CountDownLatch countDownLatch = new CountDownLatch(threadCount);
        long start = System.nanoTime();
        for (int i=0; i!=threadCount; i++) {
            int finalI = i;
            Callable<Long> exec = () -> {
                for (int j=0; j!=countP; j++) {
                    long value = calculator.get(transformer == null ? null : transformer.apply((long) j));
                    calculator.inc(transformer == null ? null : transformer.apply(value));
                }
                countDownLatch.countDown();
                return calculator.get(String.valueOf(finalI));
            };
            FutureTask<Long> f = new FutureTask<>(exec);
            new Thread(f).start();
        }

        long last = count - (countP * threadCount);
        for (int i=0; i!=last; i++) {
            calculator.inc(transformer == null ? null : transformer.apply((long) i));
        }
        countDownLatch.await();
        long end = System.nanoTime();
        long sum = calculator.sum();
        long take = System.nanoTime();
        System.out.println(name + " - calc cost : " + (end-start)/1000000.0 + " ms, take : "
            + (take-end)/1000000.0 + "ms, sum : " + sum);
    }
}
