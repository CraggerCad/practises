package com.progressive.htmlescape.lock;

public class Table {
    int k;
    public synchronized void print(int a){
        this.k = a;
        for (int i = 1; i <= 5; i++){
            System.out.println(a*i);
            try{
                Thread.sleep(400);
            }catch (Exception e){
                e.printStackTrace();
            }
        }

    }
}

