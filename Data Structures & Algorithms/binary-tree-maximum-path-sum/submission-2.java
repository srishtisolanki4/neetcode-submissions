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
    int maxi=Integer.MIN_VALUE;
    public int helper(TreeNode node){
        if(node==null)return 0;

        int leftSum=Math.max(helper(node.left),0);
        int rightSum=Math.max(helper(node.right),0);
        maxi=Math.max(maxi,node.val+leftSum+rightSum);

        return node.val+Math.max(leftSum,rightSum);
    }
    public int maxPathSum(TreeNode root) {
        helper(root);
        return maxi;
    }
}
