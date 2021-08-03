package com.cachingservice.algorithmsImp;

import java.util.HashMap;

public class KeyNodeMapper {
    private HashMap<String, Node> keyNodeMap;

    public KeyNodeMapper() {
        this.keyNodeMap = new HashMap<>();
    }

    public boolean isKeyPresent(String key) {
        return keyNodeMap.containsKey(key);
    }

    public Node findByKey(String key) {
        return keyNodeMap.get(key);
    }

    public void deleteByKey(String key) {
        keyNodeMap.remove(key);
    }

    public void add(String key, Node node) {
        keyNodeMap.put(key, node);
    }

    public int getSize() {
        return keyNodeMap.size();
    }
}
