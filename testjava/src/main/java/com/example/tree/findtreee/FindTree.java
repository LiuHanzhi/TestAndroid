package com.example.tree.findtreee;

public class FindTree {
  
    private void visit(int data) {  
        System.out.print(data+"--");  
    }  
      
    public void preOrder(Node root) {  
        if(root == null) {  
            return;  
        }  
        visit(root.getData());  
        preOrder(root.getLeft());  
        preOrder(root.getRight());  
    }  
      
    public void inOrder(Node root) {  
        if(root == null) {  
            return;  
        }  
        inOrder(root.getLeft());  
        visit(root.getData());  
        inOrder(root.getRight());  
    }  
      
    public void afterOrder(Node root) {  
        if(root == null) {  
            return;  
        }  
        afterOrder(root.getLeft());  
        afterOrder(root.getRight());  
        visit(root.getData());  
    }  
      
}  
