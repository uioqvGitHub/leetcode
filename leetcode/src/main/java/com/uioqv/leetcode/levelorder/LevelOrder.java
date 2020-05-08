package com.uioqv.leetcode.levelorder;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author LiuGuoQing
 * @since 2020-04-29
 */
public class LevelOrder {
    static class Node {
        public int val;
        public List<Node> children;

        public Node() {}



        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };
    public List<List<Integer>> levelOrder(Node root) {
        if(root == null) {
            return new ArrayList<>();
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        List<List<Integer>> result =  new ArrayList<>();
        while (!queue.isEmpty()) {
            List<Node> nodes = new ArrayList<>();
            while (!queue.isEmpty()) {
                nodes.add(queue.poll());
            }

            if(!nodes.isEmpty()) {
                List<Integer> chList = new ArrayList<>();
                result.add(chList);
                for (Node pr : nodes) {
                    chList.add(pr.val);
                    if(pr.children == null || pr.children.isEmpty()) {
                        continue;
                    }
                    for(Node ch: pr.children) {
                        queue.offer(ch);
                    }
                }
            }
        }
        return result;
    }


    public static void main(String[] args) {
        Node root = null;
//        Node root = new Node();
//        root.val = 1;
//        root.children = new ArrayList<>();
//        Node node1 = new Node();
//        node1.val = 3;
//        root.children.add(node1);
//
//        Node node2 = new Node();
//        node2.val = 2;
//        root.children.add(node2);
//        Node node3 = new Node();
//        node3.val = 4;
//        root.children.add(node3);
//
//
//        node1.children = new ArrayList<>();
//        node1.children.add(new Node(){{super.val = 5;}});
//        node1.children.add(new Node(){{super.val = 6;}});
        List<List<Integer>> lists = new LevelOrder().levelOrder(root);
        System.out.println(lists);
    }
}
