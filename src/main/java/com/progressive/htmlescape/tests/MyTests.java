package com.progressive.htmlescape.tests;

import java.text.ParseException;

public class MyTests {
    public static void main(String[] args) throws ParseException {
       /* int number = 0;
        String b = "AG-";
        String s = String.format("%03d", number);
        b = b + s;

        String q = "V-000";
        String[] vs = q.split("-");
        b = "V-" + String.format("%03d", Long.valueOf(vs[vs.length - 1]) + 1);
//        System.out.println(b);

        String source = "Fixed Asset";
        String codeSource = "FA-1001";
        String[] codeArr = codeSource.split("-");
        String[] arrS = source.split(" ");
        String code="";
        System.out.println("output");
        for (int i = 0; i< arrS.length; i++){
            char a = (arrS[i].charAt(0));
            code = code.concat(String.valueOf(a));
        }
        code = code + "-" + String.format("%02d", Long.valueOf(codeArr[codeArr.length-1]) + 1);
        System.out.println(code);*/
        int a = 21%(-4);

        System.out.println(a);

    }



}
