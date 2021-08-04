package com.cachingservice.algorithmsImp;

import com.cachingservice.algorithmIterfaces.Mapper;

import java.util.HashMap;

public class KeyNodeMapper implements Mapper<String, Node> {
    private final HashMap<String, Node> keyNodeMap;

    public KeyNodeMapper() {
        this.keyNodeMap = new HashMap<>();
    }

    @Override
    public boolean isKeyPresent(String key) {
        return keyNodeMap.containsKey(key);
    }

    @Override
    public Node findByKey(String key) {
        return keyNodeMap.get(key);
    }

    @Override
    public void deleteByKey(String key) {
        keyNodeMap.remove(key);
    }

    @Override
    public void add(String key, Node node) {
        keyNodeMap.put(key, node);
    }

    @Override
    public int getSize() {
        return keyNodeMap.size();
    }
}
