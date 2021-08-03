package com.cachingservice.algorithmsImp;

import com.cachingservice.algorithmIterfaces.LinkedList;

public class DoublyLinkedList implements LinkedList {
    private final Node head;
    private final Node tail;
    private int size;

    public DoublyLinkedList() {
        head = new Node("-1", "-1");
        tail = new Node("-1", "-1");
        head.setRightNodeRef(tail);
        tail.setLeftNodeRef(head);
        size = 0;
    }

    public void addAfterHead(Node node) {
        Node currentNode = head.getRightNodeRef();
        head.setRightNodeRef(node);
        currentNode.setLeftNodeRef(node);
        node.setLeftNodeRef(head);
        node.setRightNodeRef(currentNode);
        size++;
    }

    public void deleteNodeByRef(Node node) {
        node.getLeftNodeRef().setRightNodeRef(node.getRightNodeRef());
        node.getRightNodeRef().setLeftNodeRef(node.getLeftNodeRef());
        size--;
    }

    public int getSize() {
        return size;
    }

    public Node getHeadNodeRef() {
        return head;
    }

    public Node getTailNodeRef() {
        return tail;
    }
}
