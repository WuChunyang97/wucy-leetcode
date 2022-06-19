package leetcode.editor.cn.classify.tree;

import leetcode.editor.structure.*;

////给定一个二叉树，找出其最大深度。
////
//// 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
////
//// 说明: 叶子节点是指没有子节点的节点。
////
//// 示例：
////给定二叉树 [3,9,20,null,null,15,7]，
////
//// 3
//// / \
//// 9 20
//// / \
//// 15 7
////
//// 返回它的最大深度 3 。
//// 👍 1272 👎 0
//

 /**
 *  2022-06-18 22:05:16
 *  [104]二叉树的最大深度
 */
public class MaximumDepthOfBinaryTree{
      public static void main(String[] args) {
           Solution solution = new MaximumDepthOfBinaryTree().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
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
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(maxDepth(root.left),maxDepth(root.right)) + 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }
