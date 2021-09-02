package com.progressive.htmlescape.generics;

import java.util.*;

public class MyMain {

    public static <T extends Comparable<T>> int count(T[] array, T compare){
        int count = 0;
        for(T a:array){
            if(a.compareTo(compare) > 0){
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        PairsImpl<String, String> pairs = new PairsImpl<>("Hello", "World");
        PairsImpl<String, List<String>> pairs1 = new PairsImpl<>("List", Arrays.asList("ab", "bc"));
        Map<String, String> asd = new HashMap<>();
        asd.put("key1","value");
        asd.put("key2","value");
        asd.put("key3","value");
        PairsImpl<String, Map<String, String>> pairs2 = new PairsImpl<>("Map",asd);
//        System.out.println(pairs1.getValue());

        String[] asd1 = {"a","b","c","d","e"};
//        System.out.println(count(asd1,"b"));

        List<Integer> a = new ArrayList<>();
        a.add(1);
        a.add(2);
        a.remove(1);
        System.out.println(a);

    }
}
