package com.habibie.hackerranktraining;

import java.util.ArrayList;
import java.util.List;

class BinaryNode {
    int data;
    BinaryNode left, right;

    BinaryNode(int value) {
        data = value;
        left = right = null;
    }
}

public class LCAinBinaryTree {
    
    public static void main(String[] args) {
        // Sample tree structure:
        //         1
        //        / \
        //       2   3
        //      / \   \
        //     4   5   6

        BinaryNode root = new BinaryNode(1);
        root.left = new BinaryNode(2);
        root.right = new BinaryNode(3);
        root.left.left = new BinaryNode(4);
        root.left.right = new BinaryNode(5);
        root.right.right = new BinaryNode(6);

        System.out.println("LCA of 4 and 5: " + findLCA(root, 4, 5).data); // Expected: 2
        System.out.println("LCA of 4 and 6: " + findLCA(root, 4, 6).data); // Expected: 1
        System.out.println("LCA of 3 and 6: " + findLCA(root, 3, 6).data); // Expected: 3
        System.out.println("LCA of 2 and 6: " + findLCA(root, 2, 6).data); // Expected: 1
    }
    
    // LCA = Lowest Common Ancestor
    public static BinaryNode findLCA(BinaryNode root, int n1, int n2 ) {
        List<BinaryNode> path1 = new ArrayList<>();
        List<BinaryNode> path2 = new ArrayList<>();
        
        if (!findPath(root, path1, n1) || !findPath(root, path2, n2)) return null;
        
        int i;
        for (i=0; i<path1.size() && i<path2.size(); i++) {
            if (path1.get(i) != path2.get(i)) {
                return path1.get(i-1);
            }
        }
        
        return path1.get(i-1);
    }
    
    public static boolean findPath(BinaryNode root, List<BinaryNode> path, int n) {
        if (root == null) return false; // it means the child value is not found in the node
        
        path.add(root);
        
        if (root.data == n ||
                findPath(root.left, path, n) ||
                findPath(root.right, path, n)
                ) {
            return true;            
        }
        
        path.remove(path.size()-1);
        
        return false;
    }
}