package leetcode.editor.cn;

//给定一个二叉树的 根节点 root，请找出该二叉树的 最底层 最左边 节点的值。
//
// 假设二叉树中至少有一个节点。 
//
// 
//
// 示例 1: 
//
// 
//
// 
//输入: root = [2,1,3]
//输出: 1
// 
//
// 示例 2: 
//
// 
//
// 
//输入: [1,2,3,4,null,5,6,null,null,7]
//输出: 7
// 
//
// 
//
// 提示: 
//
// 
// 二叉树的节点个数的范围是 [1,10⁴] 
// 
// -2³¹ <= Node.val <= 2³¹ - 1 
// 
//
// 👍 548 👎 0

import leetcode.editor.structure.TreeNode;

class Test513{
	public static void main(String[] args) {
//		Solution solution = new Solution();
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
        int max,ans;
        public int findBottomLeftValue(TreeNode root) {
            //使用 BFS 进行「层序遍历」，每次用当前层的首个节点来更新 ans，当 BFS 结束后，ans 存储的是最后一层最靠左的节点。
//        Deque<TreeNode> d = new ArrayDeque<>();
//        d.addLast(root);
//        int ans = root.val;
//        while (!d.isEmpty()) {
//            int size = d.size();
//            ans = d.peek().val;
//            while (size-- > 0) {
//                TreeNode poll = d.pollFirst();
//                if (poll.left!=null) d.addLast(poll.left);
//                if (poll.right!=null) d.addLast(poll.right);
//            }
//        }
//        return ans;
            //----------------------------------
            dfs(root, 1);
            return ans;
        }
        //每次优先 DFS 当前节点的左子树，每次第一次搜索到当前深度 depth 时，必然是当前深度的最左节点，此时用当前节点值来更新 ans。
        private void dfs(TreeNode root, int depth) {
            if (root==null) return;
            if (depth > max) {
                max = depth;
                ans= root.val;
            }
            dfs(root.left, depth + 1);
            dfs(root.right, depth + 1);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}

