package com.uioqv.datastruct.tree.sort;

import com.uioqv.datastruct.tree.AbstractTree;
import com.uioqv.datastruct.tree.Node;

/**
 * @author LiuGuoQing
 * @since 2020-04-09
 */
public class SortTree<T extends Comparable<T>> extends AbstractTree<T> {


    public void insert(T data) {
        if (getRoot() == null) {
            setRoot(new Node<T>(data));
        } else {
            insert0(data);
        }
    }

    private void insert0(T data) {
        Node<T> current = getRoot();
        Node<T> newNode = new Node<T>(data);
        while (current != null) {
            int compareValue = current.data.compareTo(data);
            if (compareValue > 0) {
                if(current.left == null) {
                    current.left = newNode;
                    break;
                }
                current = current.left;
            } else if (compareValue < 0) {
                if(current.right == null) {
                    current.right = newNode;
                    break;
                }
                current = current.right;
            } else {
                current.data = data;
                break;
            }
        }


    }



}
