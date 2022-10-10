package leetcode.editor.cn.classify.greed;
//给你一个整数数组 nums ，请你求出乘积为正数的最长子数组的长度。
//
// 一个数组的子数组是由原数组中零个或者更多个连续数字组成的数组。 
//
// 请你返回乘积为正数的最长子数组长度。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,-2,-3,4]
//输出：4
//解释：数组本身乘积就是正数，值为 24 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,1,-2,-3,-4]
//输出：3
//解释：最长乘积为正数的子数组为 [1,-2,-3] ，乘积为 6 。
//注意，我们不能把 0 也包括到子数组中，因为这样乘积为 0 ，不是正数。 
//
// 示例 3： 
//
// 
//输入：nums = [-1,-2,-3,0,1]
//输出：2
//解释：乘积为正数的最长子数组是 [-1,-2] 或者 [-2,-3] 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10^5 
// -10^9 <= nums[i] <= 10^9 
// 
//
// 
//
// 👍 183 👎 0

//https://leetcode.cn/problems/maximum-length-of-subarray-with-positive-product
public class MaximumLengthOfSubarrayWithPositiveProduct{
    public static void main(String[] args) {
         Solution solution = new MaximumLengthOfSubarrayWithPositiveProduct().new Solution();
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int getMaxLen(int[] nums) {
        //该段子数组中没有0且负数的个数为偶数
        //属于是又没解释题意，也没发现关键步骤
        int pos=0,neg=0,first=-1;
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            if (n == 0) {
                pos=0;neg=0;first=-1;
            }else if (n>0){
                pos++;
            }else {
                if (first == -1) {
                    first = i;
                }
                neg++;
            }
            if (neg % 2 == 0) {
                ans = Math.max(ans, pos + neg);
            }else {
                ans = Math.max(ans, i - first);//是截取第一个负数到i
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}