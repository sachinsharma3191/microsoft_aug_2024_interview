package org.example.tree;

public class BinaryTreeDistanceSumOptimised {
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

        int i = 2;
        int j = 2;

        int result = sumNodesAtDistance(root, i, j);
        System.out.println("Sum of nodes at distance " + j + " from node " + i + " is: " + result);
    }

    public static int sumNodesAtDistance(TreeNode root, int targetVal, int distance) {
        int[] result = new int[1];  // Use an array to hold the sum as we need to modify it inside the DFS
        findTargetAndSum(root, targetVal, distance, result);
        return result[0];
    }

    private static int findTargetAndSum(TreeNode node, int targetVal, int distance, int[] result) {
        if (node == null) {
            return -1;
        }

        if (node.val == targetVal) {
            addNodesAtDistance(node, distance, result);
            return distance - 1;
        }

        int leftDistance = findTargetAndSum(node.left, targetVal, distance, result);
        int rightDistance = findTargetAndSum(node.right, targetVal, distance, result);

        if (leftDistance >= 0) {
            if (leftDistance == 0) {
                result[0] += node.val;
            } else {
                addNodesAtDistance(node.right, leftDistance - 1, result);
            }
            return leftDistance - 1;
        }

        if (rightDistance >= 0) {
            if (rightDistance == 0) {
                result[0] += node.val;
            } else {
                addNodesAtDistance(node.left, rightDistance - 1, result);
            }
            return rightDistance - 1;
        }

        return -1;
    }

    private static void addNodesAtDistance(TreeNode node, int distance, int[] result) {
        if (node == null) {
            return;
        }
        if (distance == 0) {
            result[0] += node.val;
            return;
        }
        addNodesAtDistance(node.left, distance - 1, result);
        addNodesAtDistance(node.right, distance - 1, result);
    }
}

