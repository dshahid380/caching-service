package com.cachingservice.algorithmsImp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DoublyLinkedListTest {
    DoublyLinkedList doublyLinkedList;
    @BeforeEach
    void setUp() {
        doublyLinkedList = new DoublyLinkedList();
        Node node1 = new Node("key1", "value1");
        Node node2 = new Node("key2", "value2");
        doublyLinkedList.addAfterHead(node1);
        doublyLinkedList.addAfterHead(node2);
    }

    @Test
    void TestDoublyLinkedListShouldIncrementSizeAfterNodeAddition() {
        assertEquals(doublyLinkedList.getSize(), 2);
    }

    @Test
    void TestDoublyLinkedListShouldAddNewElementAfterHeadNode() {
        assertEquals(doublyLinkedList.getHeadNodeRef().getRightNodeRef().getKey(), "key2");
        assertEquals(doublyLinkedList.getTailNodeRef().getLeftNodeRef().getKey(), "key1");
        assertEquals(doublyLinkedList.getHeadNodeRef().getRightNodeRef().getValue(), "value2");
        assertEquals(doublyLinkedList.getTailNodeRef().getLeftNodeRef().getValue(), "value1");
    }

    @Test
    void TestDoublyLinkedListShouldDeleteNodeByReference() {
        Node node3 = new Node("key3", "value3");
        Node node4 = new Node("key4", "value4");
        doublyLinkedList.addAfterHead(node3);
        doublyLinkedList.addAfterHead(node4);

        doublyLinkedList.deleteNodeByRef(node4);
        doublyLinkedList.deleteNodeByRef(node3);

        assertEquals(doublyLinkedList.getHeadNodeRef().getRightNodeRef().getKey(), "key2");
        assertEquals(doublyLinkedList.getTailNodeRef().getLeftNodeRef().getKey(), "key1");
        assertEquals(doublyLinkedList.getHeadNodeRef().getRightNodeRef().getValue(), "value2");
        assertEquals(doublyLinkedList.getTailNodeRef().getLeftNodeRef().getValue(), "value1");
        assertEquals(doublyLinkedList.getSize(), 2);
    }
}