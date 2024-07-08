package org.example.tree;
import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeDistanceSum {
    public static void main(String[] args) {
        // Example binary tree:
        //      1
        //     / \
        //    2   3
        //   / \   \
        //  4   5   6

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);

        int i = 1;
        int j = 2;

        int result = sumNodesAtDistance(root, i, j);
        System.out.println("Sum of nodes at distance " + j + " from node " + i + " is: " + result);
    }

    public static int sumNodesAtDistance(TreeNode root, int i, int j) {
        // Find the target node
        TreeNode targetNode = findNode(root, i);
        if (targetNode == null) {
            return 0;
        }

        // Find the sum of nodes at distance j from the target node
        return sumAtDistance(targetNode, j);
    }

    private static TreeNode findNode(TreeNode root, int value) {
        if (root == null) {
            return null;
        }
        if (root.val == value) {
            return root;
        }

        TreeNode leftResult = findNode(root.left, value);
        if (leftResult != null) {
            return leftResult;
        }

        return findNode(root.right, value);
    }

    private static int sumAtDistance(TreeNode node, int distance) {
        if (node == null) {
            return 0;
        }
        if (distance == 0) {
            return node.val;
        }

        int leftSum = sumAtDistance(node.left, distance - 1);
        int rightSum = sumAtDistance(node.right, distance - 1);

        return leftSum + rightSum;
    }
}

