package com.progressive.htmlescape.collections.tree;

import lombok.Data;

@Data
public class BinaryTree {

    Node root;

    private Node addRecursive(Node current, int value){

        if(current == null) return new Node(value);
        if (value < current.value){
            current.left = addRecursive(current.left, value);
        }else if (value > current.value){
            current.right = addRecursive(current.right, value);
        }else {
            return current;
        }
        return current;
    }

    public void add(int value){
        root = addRecursive(root, value);
    }

    private boolean recursiveContainsNode(Node current, int value){
        if(current == null) return false;
        if (current.value == value) return true;
        return value < current.value ?
                recursiveContainsNode(current.left, value) :
                recursiveContainsNode(current.right, value);
    }

    public static void traversePreOrder(Node node) {
        if (node != null) {
            System.out.print(" " + node.value);
            traversePreOrder(node.left);
            traversePreOrder(node.right);
        }
    }

    public boolean containsNode(int value){
        return recursiveContainsNode(root, value);
    }

    private static BinaryTree binaryTree(){
        BinaryTree bt = new BinaryTree();
        bt.add(6);
        bt.add(4);
        bt.add(8);
        bt.add(3);
        bt.add(5);
        bt.add(7);
        bt.add(9);
        return bt;
    }

    public static void main(String[] args) {
        BinaryTree binaryTree;
        binaryTree = binaryTree();
        traversePreOrder(binaryTree.root);
    }

}
