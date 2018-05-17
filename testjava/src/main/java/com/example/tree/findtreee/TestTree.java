package com.example.tree.findtreee;

/**
 * 二叉树的三种遍历算法(递归)
 * 先序遍历：中 左 右
 * 中序遍历：左 中 右
 * 后序遍历：左 右 中
 */
public class TestTree {

    public static void main(String[] args) {
        FindTree ft = new FindTree();
        int[] array = {12, 76, 35, 22, 16, 48, 90, 46, 9, 40};
        int j = 0;
        Node root = new Node(array[j]);
        for (int i = 1; i < array.length; i++) {
            insert(root, array[i]);
        }
        System.out.println("preorder----------------------------------");
        ft.preOrder(root);

        System.out.println("\n\ninorder----------------------------------");
        ft.inOrder(root);

        System.out.println("\n\nafterorder----------------------------------");
        ft.afterOrder(root);

    }

    private static void insert(Node root, int data) {
        //二叉树中左边的孩子节点小于父节点，右边的孩子节点大于父节点
        if (root.getData() < data) {
            if (root.getRight() == null) {
                root.setRight(new Node(data));
            } else {
                insert(root.getRight(), data);
            }
        } else {
            if (root.getLeft() == null) {
                root.setLeft(new Node(data));
            } else {
                insert(root.getLeft(), data);
            }
        }
    }
}  