package com.cachingservice.algorithmsImp;

public class Node {
    private Node left;
    private Node right;
    private String key;
    private String value;
    public Node(String key, String value) {
        this.key = key;
        this.value = value;
        this.left = null;
        this.right = null;
    }

    public Node getLeftNodeRef() {
        return left;
    }

    public Node getRightNodeRef() {
        return right;
    }

    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }
}
