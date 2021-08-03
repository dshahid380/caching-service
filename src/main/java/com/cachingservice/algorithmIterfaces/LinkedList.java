package com.cachingservice.algorithmIterfaces;

import com.cachingservice.algorithmsImp.Node;

public interface LinkedList {
    public void addAfterHead(Node node);

    public void deleteNodeByRef(Node node);

    public int getSize();

    public Node getHeadNodeRef();

    public Node getTailNodeRef();
}
