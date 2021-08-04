package com.cachingservice.algorithmsImp;

import com.cachingservice.algorithmIterfaces.Mapper;

import java.util.HashMap;

public class LevelMapper implements Mapper<Integer, DoublyLinkedList> {

    private final HashMap<Integer, DoublyLinkedList> levelMap;

    public LevelMapper() {
        this.levelMap = new HashMap<>();
    }

    @Override
    public boolean isKeyPresent(Integer level) {
        return levelMap.containsKey(level);
    }

    @Override
    public DoublyLinkedList findByKey(Integer level) {
        return levelMap.get(level);
    }

    @Override
    public void deleteByKey(Integer level) {
        if(isKeyPresent(level))
            levelMap.remove(level);
    }

    @Override
    public void add(Integer level, DoublyLinkedList list) {

    }

    @Override
    public int getSize() {
        return levelMap.size();
    }

    public void addValueToLevel(Integer level, Node node) {
        DoublyLinkedList list = getOrCreateList(level);
        list.addAfterHead(node);
    }

    private DoublyLinkedList getOrCreateList(Integer level) {
        if(!levelMap.containsKey(level))
            levelMap.put(level, new DoublyLinkedList());
        return levelMap.get(level);
    }
}
