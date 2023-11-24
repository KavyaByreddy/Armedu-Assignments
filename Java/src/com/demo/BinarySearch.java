package com.demo;

class Node {
    int data;
    Node left, right;

    public Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class BSTree {
    Node root;

    public BSTree() {
        root = null;
    }

    public void insert(int data) {
        root = insertRec(root, data);
    }

    private Node insertRec(Node root, int data) {
        if (root == null) {
            root = new Node(data);
            return root;
        }

        if (data < root.data) {
            root.left = insertRec(root.left, data);
        } else if (data > root.data) {
            root.right = insertRec(root.right, data);
        }

        return root;
    }

    public void inOrder() {
        inOrderRec(root);
    }

    private void inOrderRec(Node root) {
        if (root != null) {
            inOrderRec(root.left);
            System.out.println(root.data);
            inOrderRec(root.right);
        }
    }
}

public class BinarySearch {
    public static void main(String[] args) {
        BSTree tree = new BSTree();

        int[] nodesToInsert = {5, 3, 8, 2, 4, 11};

        for (int nodeData : nodesToInsert) {
            tree.insert(nodeData);
        }

        tree.inOrder();
    }
}
