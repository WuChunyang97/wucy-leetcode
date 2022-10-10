package leetcode.editor.cn.classify.dp;
//给你一个正整数数组 values，其中 values[i] 表示第 i 个观光景点的评分，并且两个景点 i 和 j 之间的 距离 为 j - i。
//
// 一对景点（i < j）组成的观光组合的得分为 values[i] + values[j] + i - j ，也就是景点的评分之和 减去 它们两者之间的距离
//。 
//
// 返回一对观光景点能取得的最高分。 
//
// 
//
// 示例 1： 
//
// 
//输入：values = [8,1,5,2,6]
//输出：11
//解释：i = 0, j = 2, values[i] + values[j] + i - j = 8 + 5 + 0 - 2 = 11
// 
//
// 示例 2： 
//
// 
//输入：values = [1,2]
//输出：2
//
//
// 
//
// 提示： 
//
// 
// 2 <= values.length <= 5 * 10⁴ 
// 1 <= values[i] <= 1000 
// 
//
// 👍 339 👎 0

//https://leetcode.cn/problems/best-sightseeing-pair
public class BestSightseeingPair{
    public static void main(String[] args) {
         Solution solution = new BestSightseeingPair().new Solution();
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        //只需要算values[i]+i 和values[j]-j，遍历j求出左边的最大值即可
        int imax=0;
        int max=0;
        int left=0;
        for (int j = 1; j < values.length; j++) {
            left = Math.max(left, values[j - 1] + j - 1);
            imax = left + values[j] - j;
            max = Math.max(imax, max);
        }
        return max;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}