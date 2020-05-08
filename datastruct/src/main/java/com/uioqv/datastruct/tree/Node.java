package com.uioqv.datastruct.tree;

/**
 * @author LiuGuoQing
 * @since 2020-04-09
 */
public class Node<T> {
    public T data;
    public Node<T> left;
    public Node<T> right;

    public Node(T data) {
        this.data = data;
    }


    Node<T> getLeft() {
        return left;
    }

    Node<T> getRight() {
        return right;
    }

    public void setParent(Node<T> parent) {

    }


    abstract class AbstractOutherNode<T> {

    }

    class ParentNode<T> extends Node<T> {
        public Node<T> parent;

        public ParentNode(T data) {
            super(data);
        }
    }
}
