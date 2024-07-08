package org.example.dfs;

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }


public class SubTreeOfAnotherTree572 {

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        return isSubTreeUtil(root, subRoot);
    }

    public boolean isSubTreeUtil(TreeNode root, TreeNode subRoot) {
        if (root == null) {
            return false;
        }
        if (isIdentical(root, subRoot)) {
            return true;
        }
        return isSubTreeUtil(root.left, subRoot) || isSubTreeUtil(root.right, subRoot);
    }

    public boolean isIdentical(TreeNode root, TreeNode subRoot) {
        if (root == null || subRoot == null) {
            return root == null && subRoot == null;
        }
        return root.val == subRoot.val && isIdentical(root.left, subRoot.left)
                && isIdentical(root.right, subRoot.right);
    }
}
