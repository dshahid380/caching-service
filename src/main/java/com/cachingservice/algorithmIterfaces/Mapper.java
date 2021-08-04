package com.cachingservice.algorithmIterfaces;

import com.cachingservice.algorithmsImp.Node;

import java.util.HashMap;

public interface Mapper<K, V> {

    public boolean isKeyPresent(K key);

    public V findByKey(K key);

    public void deleteByKey(K key);

    public void add(K key, V value);

    public int getSize();
}
