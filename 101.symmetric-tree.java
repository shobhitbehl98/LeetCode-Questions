import java.util.ArrayList;
import java.util.LinkedList;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode id=101 lang=java
 *
 * [101] Symmetric Tree
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
    public boolean isSymmetric(TreeNode root) {
        if(root==null)return false;
        LinkedList<TreeNode> li=new LinkedList<>();
        li.addLast(root);
        while(li.size()>0){
            int size=li.size();
            ArrayList<TreeNode> al=new ArrayList<>();
            while(size-->0){
               TreeNode rem=li.removeFirst();
               if(rem!=null){
                   al.add(rem);
                   li.add(rem.left);
                   li.add(rem.right);
               }else{
                   al.add(new TreeNode(-101,null,null));
               }
                 
            }
            if(!check(al)){
                return false;
            }
        }
        return true;

    }

    public boolean check(ArrayList<TreeNode> al){
        int i=0;
        int j=al.size()-1;
        while(i<j){
            if(al.get(i).val!=al.get(j).val){
                 return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
// @lc code=end

