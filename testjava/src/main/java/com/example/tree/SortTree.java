package com.example.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


/**
 * 树的遍历：给定一个树，请按照以下规则打印这个树：顺序打印第一层，倒序打印第二层，顺序打印第三层...
 */

public class SortTree {


    private static class Node {

        public Node(String key, Node... nodes) {
            this.key = key;
            if (nodes != null) {
                for (Node node : nodes) {
                    list.add(node);
                }
            }

        }

        String key;
        ArrayList<Node> list = new ArrayList<>();

        public String getKey() {
            return key;
        }

        public List<Node> getList() {
            return list;
        }
    }


    public static void main(String[] args) {
        Node k = new Node("k", null);
        Node j = new Node("j", null);
        Node i = new Node("i", null);
        Node h = new Node("h", null);
        Node g = new Node("g", null);
        Node f = new Node("f", j, k);
        Node e = new Node("e", null);
        Node d = new Node("d", h, i);
        Node c = new Node("c", null);
        Node b = new Node("b", e, f, g);
        Node a = new Node("a", b, c, d);

        sort(a);

        String packageList = System.getProperty("java.protocol.handler.pkgs");
        System.out.println(packageList);

    }

    private static void sort(Node node) {
        Stack<Node> s = new Stack<>();
        Stack<Node> s1 = new Stack<>();
        int count = 0;

        s.add(node);
        while (!s.empty() || !s1.empty()) {
            Node n = s.pop();
            System.out.println(n.getKey());
            if (count % 2 == 0) {
                for (int i = 0; i < n.getList().size(); i++) {
                    s1.add(n.getList().get(i));
                }
            } else {
                for (int i = n.getList().size() - 1; i >= 0; i--) {
                    s1.add(n.getList().get(i));
                }
            }
//            for (Node i : s1) {
//                System.out.println("---" + i.getKey());
//            }

            if (s.empty()) {
//                s = (Stack<Node>) s1.clone();
                s.addAll(s1);
                s1.clear();

                count++;
            }
        }
    }


}




