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

    @Override
    public void addAfterHead(Node node) {
        Node currentNode = head.getRightNodeRef();
        head.setRightNodeRef(node);
        currentNode.setLeftNodeRef(node);
        node.setLeftNodeRef(head);
        node.setRightNodeRef(currentNode);
        size++;
    }

    @Override
    public void deleteNodeByRef(Node node) {
        node.getLeftNodeRef().setRightNodeRef(node.getRightNodeRef());
        node.getRightNodeRef().setLeftNodeRef(node.getLeftNodeRef());
        size--;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public Node getHeadNodeRef() {
        return head;
    }

    @Override
    public Node getTailNodeRef() {
        return tail;
    }
}
