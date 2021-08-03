package com.cachingservice.algorithmsImp;

import java.util.Objects;

public class Node {
    private Node left;
    private Node right;
    private String key;
    private String value;
    private int cnt;

    public Node(String key, String value) {
        this.key = key;
        this.value = value;
        this.left = null;
        this.right = null;
        this.cnt = 1;
    }

    public Node getLeftNodeRef() {
        return left;
    }

    public void incrementCnt() {
        this.cnt++;
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

    public int getCnt() {
        return cnt;
    }

    public void setLeftNodeRef(Node left) {
        this.left = left;
    }

    public void setRightNodeRef(Node right) {
        this.right = right;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Node)) return false;
        Node node = (Node) o;
        return Objects.equals(getLeftNodeRef(), node.getLeftNodeRef())
                && Objects.equals(getRightNodeRef(), node.getRightNodeRef())
                && Objects.equals(getKey(), node.getKey())
                && Objects.equals(getValue(), node.getValue());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getLeftNodeRef(), getRightNodeRef(), getKey(), getValue());
    }
}
