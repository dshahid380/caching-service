package com.cachingservice.algorithmsImp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LevelMapperTest {

    LevelMapper levelMapper;
    Node node1, node2;

    @BeforeEach
    void setUp() {
        levelMapper = new LevelMapper();
        node1 = new Node("key1", "value1");
        node2 = new Node("key2", "value2");
    }

    @Test
    public void testLevelMapperShouldBeAbleToCreateListIfNotPresent() {
        levelMapper.addValueToLevel(1, node1);
        assertEquals(levelMapper.findByKey(1).getSize(), 1);
    }

    @Test
    public void testLevelMapperShouldBeDeleteLevelIfPresent() {
        levelMapper.addValueToLevel(1, node1);
        levelMapper.deleteByKey(1);
        assertNull(levelMapper.findByKey(1));
        assertFalse(levelMapper.isKeyPresent(1));
    }
}