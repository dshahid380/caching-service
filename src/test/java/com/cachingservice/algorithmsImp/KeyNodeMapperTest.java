package com.cachingservice.algorithmsImp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KeyNodeMapperTest {

    KeyNodeMapper keyNodeMapper;

    @BeforeEach
    void setUp() {
        keyNodeMapper = new KeyNodeMapper();
        Node node1 = new Node("key1", "value1");
        keyNodeMapper.add(node1.getKey(), node1);
    }

    @Test
    public void testKeyMapperShouldAbleToRemoveElement() {
        keyNodeMapper.deleteByKey("key1");

        assertEquals(keyNodeMapper.getSize(), 0);
    }

    @Test
    public void testKeyMapperShouldAbleToFindNode() {
        assertTrue(keyNodeMapper.isKeyPresent("key1"));
    }

    @Test
    public void testKeyMapperShouldAbleToReturnSpecificNode() {
        Node node2 = new Node("key2", "value2");
        Node node3 = new Node("key3", "value3");
        keyNodeMapper.add(node2.getKey(), node2);
        keyNodeMapper.add(node3.getKey(), node3);
        assertEquals(keyNodeMapper.findByKey("key2"), node2);
        assertEquals(keyNodeMapper.findByKey("key3"), node3);
    }
}