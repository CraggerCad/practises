package com.progressive.htmlescape.lock;

public class MyThread1 extends Thread{
    Table t;
    public MyThread1(Table t){
        this.t = t;
    }

    public void run(){
        t.print(5);
    }
}
