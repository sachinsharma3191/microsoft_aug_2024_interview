package org.example.dfs;


import java.util.*;

public class BinaryTreeKDistanceFromLeaf {
    public static void main(String[] args) {
        // Example usage
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.left = new TreeNode(6);
        root.left.right.right = new TreeNode(7);

        BinaryTreeKDistanceFromLeaf solution = new BinaryTreeKDistanceFromLeaf();
        Set<TreeNode> result = solution.findNodesAtDistanceKFromLeaf(root, 1);

        System.out.println("Nodes at distance 3 from leaf nodes:");
        for (TreeNode node : result) {
            System.out.println(node.val);
        }
    }

    public Set<TreeNode> findNodesAtDistanceKFromLeaf(TreeNode root, int K) {
        Set<TreeNode> result = new HashSet<>();
        findNodes(root, K, result);
        return result;
    }

    private int findNodes(TreeNode node, int K, Set<TreeNode> result) {
        if (node == null) {
            return -1; // If node is null, return -1 indicating no node
        }
        if (node.left == null && node.right == null) {
            return 0; // Leaf node, return 0
        }

        int leftDistance = findNodes(node.left, K, result);
        int rightDistance = findNodes(node.right, K, result);

        int currentDistance = Math.max(leftDistance, rightDistance) + 1;

        if (currentDistance == K) {
            result.add(node);
        }

        return currentDistance;
    }
}
