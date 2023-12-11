package leetcode.editor.cn;
//给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,1]
//输出：[[0,1],[1,0]]
// 
//
// 示例 3： 
//
// 
//输入：nums = [1]
//输出：[[1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 6 
// -10 <= nums[i] <= 10 
// nums 中的所有整数 互不相同 
// 
//
// 👍 2763 👎 0

import java.util.*;

class 全排列{
	public static void main(String[] args) {
		Solution solution = new 全排列().new Solution();
		solution.permute(new int[]{1,2,3});
	}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		Deque<Integer> list = new ArrayDeque<>();
		dfs(res, nums, list);
		return res;
	}

	public void dfs(List<List<Integer>> res, int[] nums, Deque<Integer> list) {
		if (list.size() == nums.length) {
			res.add(new ArrayList<>(list));
			return;
		}
		for (int i = 0; i < nums.length; i++) {
			if (list.contains(nums[i])) {
				continue;
			}
			list.addLast(nums[i]);
			dfs(res, nums, list);
			list.removeLast();
		}
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}