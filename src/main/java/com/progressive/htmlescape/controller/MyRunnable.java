package com.progressive.htmlescape.controller;

public class MyRunnable implements Runnable{

    private String name;

    public MyRunnable(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        try{
            Thread.sleep(60000L);
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("Hello "+name);
    }
}
