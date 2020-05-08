package com.uioqv.datastruct.tree;

/**
 * @author LiuGuoQing
 * @since 2020-04-09
 */
public class ParentNode<T> extends Node<T> {
    private Node<T> parent;

    public ParentNode(T data) {
        super(data);
    }


}
