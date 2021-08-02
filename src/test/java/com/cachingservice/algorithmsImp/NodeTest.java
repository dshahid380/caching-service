package com.cachingservice.algorithmsImp;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NodeTest {

    Node node;

    @BeforeEach
    void setUp() {
        node = new Node("key", "value");
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void TestGetLeftNodeRefShouldReturnNULL() {
        assertNull(node.getLeftNodeRef());
    }

    @Test
    void TestGetRightNodeRefShouldReturnNULL() {
        assertNull(node.getRightNodeRef());
    }

    @Test
    void TestGetKeyShouldReturnValidKey() {
        System.out.println(node.getKey());
        assertNotNull(node.getKey());
    }

    @Test
    void TestGetKeyShouldReturnValidValue() {
        System.out.println(node.getValue());
        assertNotNull(node.getValue());
    }
}