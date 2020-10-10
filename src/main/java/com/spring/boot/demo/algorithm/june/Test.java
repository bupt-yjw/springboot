package com.spring.boot.demo.algorithm.june;

/**
 * Created by weiyongjun on 2020/6/30
 */
public class Test {

    public static void main(String[] a) {
        Thread thread = new Thread(new MyRunnable());
        thread.start();
        MyRunnable runnable = new MyRunnable();
        runnable.run();
    }
}

class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println(11);
    }
}
