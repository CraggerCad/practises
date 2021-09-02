package com.progressive.htmlescape.lock;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class MyMain {
    public static void main(String[] args) {
        /*Table t = new Table();
        MyThread1 myThread1 = new MyThread1(t);
        MyThread2 myThread2 = new MyThread2(t);
        myThread1.start();
        myThread2.start();*/
        Date date = new Date(new Date().getTime() + TimeUnit.DAYS.toMillis(90));

        System.out.println(date);
    }
}
