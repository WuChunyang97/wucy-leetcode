package leetcode.editor.cn;
import java.util.*;
//给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。 
//
// 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0]
//输出：[[],[0]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10 
// -10 <= nums[i] <= 10 
// nums 中的所有元素 互不相同 
// 
//
// 👍 2201 👎 0

class 子集{
	public static void main(String[] args) {
		Solution solution = new 子集().new Solution();
		
	}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
	List<Integer> list = new ArrayList<>();
	LinkedList<Integer> path = new LinkedList<>();
	List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
//		dfs(0, nums);
		subsetsHelper(0, nums);
		return res;
    }
	//todo 回溯没弄懂
	private void subsetsHelper(int startIndex, int[] nums) {
		res.add(new ArrayList<>(path));
		for (int i = startIndex; i < nums.length; i++) {
			path.add(nums[i]);
			subsetsHelper(i + 1,nums);
			path.removeLast();
		}
	}

	private void dfs(int cur, int[] nums) {
		if (cur == nums.length) {
			// 记录答案
			res.add(new ArrayList<>(list));
			return;
		}
		// 考虑选择当前位置
		list.add(nums[cur]);
		dfs(cur + 1, nums);
		// 考虑不选择当前位置
		list.remove(list.size() - 1);
		dfs(cur + 1, nums);
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}