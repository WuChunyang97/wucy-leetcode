package leetcode.editor.cn.classify.dp.backPackage;
//给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,5,11,5]
//输出：true
//解释：数组可以分割成 [1, 5, 5] 和 [11] 。 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3,5]
//输出：false
//解释：数组不能分割成两个元素和相等的子集。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 200 
// 1 <= nums[i] <= 100 
// 
// 👍 1376 👎 0


public class PartitionEqualSubsetSum{
    public static void main(String[] args) {
         Solution solution = new PartitionEqualSubsetSum().new Solution();
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean canPartition(int[] nums) {
        //排除
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if ((sum & 1) == 1) {
            return false;
        }
        int target = sum / 2;
        int length = nums.length;
        //确定状态：从0-length中能选加起来等于target
        boolean[][] dp = new boolean[length][target+1];
        //初始化
        if (nums[0] < target) {
            dp[0][nums[0]] = true;
        }
        //状态方程
        for (int i = 1; i < length; i++) {
            for (int j = 0; j <= target; j++) {
                //加不加num[i]
                //由此确定的是dp[i-1][j]或是dp[i-1][j-num[i]]的值
                //至少是这个答案dp[i-1][j]
                dp[i][j] = dp[i - 1][j];
                if (nums[i] == j) {
                    dp[i][j] = true;
                    continue;
                }
                if (nums[i] < j) {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i]];
                }
            }
        }
        return dp[length - 1][target];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}