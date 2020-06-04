package com.wind.concurrent.hb;

public class ThreadHappenBefore {
    private int num = 0;
    private volatile boolean flag = false;

    public void start() throws InterruptedException {
        for (int i=0; i!=100; i++) {
            int expected = 3;
            int result = counting(expected);
            if (expected != result) {
                System.out.println("expected [" + expected + "], real [" + result + "]");
            }
        }
    }

    public int counting(int count) throws InterruptedException {
        this.num = 0;
        Thread odd = new Thread(() -> {
            while(count > num) {
                if (!flag) {
                    if (++num % 2 != 0) {
                        flag = true;
                    }
                }
            }
        });

        Thread t2 = new Thread(() -> {
            while (count > num) {
                if (flag) {
                    if (++num % 2 == 0) {
                        flag = false;
                    }
                }
            }
        });

        odd.start(); t2.start();
        odd.join(); t2.join();

        return this.num;
    }
}
