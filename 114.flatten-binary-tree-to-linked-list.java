/*
 * @lc app=leetcode id=114 lang=java
 *
 * [114] Flatten Binary Tree to Linked List
 */

// @lc code=start
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
    public void flatten(TreeNode root) {
        if(root==null)return;
        flatten(root.left);
        while(root.left!=null){
        TreeNode l=root.left;
        TreeNode r=root.right;
        TreeNode l2=null;
        if(l!=null){
          l2=root.left.left;
        }
        TreeNode f=l;
        while(l.right!=null){
           l=l.right;
        }
        root.right=f;
        l.right=r;
        root.left=l2;
    }
    flatten(root.right);
    }
}
// @lc code=end

