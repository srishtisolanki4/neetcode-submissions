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
    List<Integer> list;
    public void build(TreeNode node){
        if(node==null)return;

        build(node.left);
        list.add(node.val);
        build(node.right);
    }
    public int kthSmallest(TreeNode root, int k) {
        list=new ArrayList<>();
        build(root);
        return list.get(k-1);

        
    }
}
