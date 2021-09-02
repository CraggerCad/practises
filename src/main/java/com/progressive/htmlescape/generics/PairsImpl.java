package com.progressive.htmlescape.generics;

public class PairsImpl<K, V> implements Pairs{
    private K key;
    private V value;

    public PairsImpl(K key, V value){
        this.key = key;
        this.value = value;
    }
    @Override
    public K getKey() {
        return this.key;
    }

    @Override
    public V getValue() {
        return this.value;
    }
}
