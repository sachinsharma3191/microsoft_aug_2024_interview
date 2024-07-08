package org.example.string_matching;

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
        // Serialize given Nodes
        StringBuilder rootList = new StringBuilder();
        serialize(root, rootList);
        String r = rootList.toString();

        StringBuilder subRootList = new StringBuilder();
        serialize(subRoot, subRootList);
        String s = subRootList.toString();

        // Check if s is in r
        return r.indexOf(s) != -1;
    }

    // Function to serialize Tree
    private void serialize(TreeNode node, StringBuilder treeStr) {
        if (node == null) {
            treeStr.append("#");
            return;
        }

        treeStr.append("^");
        treeStr.append(node.val);
        serialize(node.left, treeStr);
        serialize(node.right, treeStr);
    }
}
