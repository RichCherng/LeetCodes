/**
 * 257 Binary Tree Paths
 * 
 * Solution: Binary Tree Traversal
 * 
 * Run Time Complexity: O(N)
 * N is the number of node in the tree
 * 
 * Space Complexity: O(N)
 */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
  public List<String> binaryTreePaths(TreeNode root) {
      List<String> ans = new ArrayList<String>();
      traverse(root, "", ans);
      return ans;
  }
  
  private void traverse(TreeNode root, String path, List<String> ans) {
      if(root == null) return;
      
      path += root.val;
      
      if(root.left == null && root.right == null) {    
          ans.add(path);
      } 
      
      traverse(root.left, path + "->", ans);
      traverse(root.right, path + "->", ans);
  }
}