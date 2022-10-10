package leetcode.editor.cn.classify.dp;
//给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组
// （子数组最少包含一个元素），返回其最大和。
//
// 子数组 是数组中的一个连续部分。
//输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
//输出：6
//解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
//输入：nums = [1]
//输出：1
//输入：nums = [5,4,-1,7,8]
//输出：23
// 提示： 

// 1 <= nums.length <= 10⁵ 
// -10⁴ <= nums[i] <= 10⁴
// 进阶：如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的 分治法 求解。 
//
// 👍 5342 👎 0

//https://leetcode.cn/problems/maximum-subarray
public class MaximumSubarray{
    public static void main(String[] args) {
         Solution solution = new MaximumSubarray().new Solution();
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxSubArray(int[] nums) {
        //“清楚”地定义dp
        //我想的是从i开始，应该以i结尾---意思就是只用考虑dp[i-1]要不要就行了
        //即
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        int res = dp[0];
        for (int i = 1; i < n; i++) {
            dp[i] = dp[i - 1] > 0 ? dp[i - 1] + nums[i] : nums[i];
            res = Math.max(dp[i], res);
        }
        return res;



    }
}
//leetcode submit region end(Prohibit modification and deletion)

}