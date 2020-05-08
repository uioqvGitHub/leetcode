package com.uioqv.datastruct.tree;


import java.util.LinkedList;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * @author LiuGuoQing
 * @since 2020-04-09
 */
public abstract class AbstractTree<T> {
    private Node<T> root;


    protected void setRoot(Node<T> root) {
        this.root = root;
    }

    protected Node<T> getRoot() {
        return root;
    }

    public void beforeLoop(Consumer<T> consumer) {
        loopConsumer(consumer, Node::getLeft, Node::getRight);
    }

    public void afterLoop(Consumer<T> consumer) {
        loopConsumer(consumer, Node::getRight, Node::getLeft);
    }

    public void centerLoop(Consumer<T> consumer) {
        if (getRoot() == null) {
            return;
        }
        LinkedList<Node<T>> queue = new LinkedList<>();
        queue.offer(getRoot());
        while (!queue.isEmpty()) {
            Node<T> node = queue.poll();
            consumer.accept(node.data);
            if(node.left != null) {
                queue.offer(node.left);
            }
            if(node.right != null) {
                queue.offer(node.right);
            }
        }
    }


    private void loopConsumer(Consumer<T> consumer,
                              Function<Node<T>, Node<T>> getBeforeNode,
                              Function<Node<T>, Node<T>> getAfterNode) {
        if (getRoot() == null) {
            return;
        }
        LinkedList<Node<T>> stack = new LinkedList<>();

        pushLeft(getRoot(), stack, getBeforeNode);
        while (!stack.isEmpty()) {
            Node<T> current = stack.pop();
            consumer.accept(current.data);
            Node<T> afterNode = getAfterNode.apply(current);
            if (afterNode != null) {
                pushLeft(afterNode, stack, getBeforeNode);
            }
        }
    }


    private void pushLeft(Node<T> current, LinkedList<Node<T>> stack, Function<Node<T>, Node<T>> getBeforeNode) {
        while (current != null) {
            stack.push(current);
            current = getBeforeNode.apply(current);
        }
    }


}
