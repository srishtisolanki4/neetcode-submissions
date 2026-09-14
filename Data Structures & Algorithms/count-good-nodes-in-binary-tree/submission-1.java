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
    int ans=0;
    public void dfs(TreeNode node, int maxi){
        if(node==null)return;

        if(node.val>=maxi){
            ans++;
            maxi=node.val;
        }
        dfs(node.left,maxi);
        dfs(node.right,maxi);
    }
    public int goodNodes(TreeNode root) {
        dfs(root,root.val);
        return ans;
    }
}
