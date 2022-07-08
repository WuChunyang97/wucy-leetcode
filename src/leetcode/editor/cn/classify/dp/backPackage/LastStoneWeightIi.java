package leetcode.editor.cn.classify.dp.backPackage;
//有一堆石头，用整数数组 stones 表示。其中 stones[i] 表示第 i 块石头的重量。
//
// 每一回合，从中选出任意两块石头，然后将它们一起粉碎。假设石头的重量分别为 x 和 y，且 x <= y。那么粉碎的可能结果如下： 
//
// 
// 如果 x == y，那么两块石头都会被完全粉碎； 
// 如果 x != y，那么重量为 x 的石头将会完全粉碎，而重量为 y 的石头新重量为 y-x。 
// 
//
// 最后，最多只会剩下一块 石头。返回此石头 最小的可能重量 。如果没有石头剩下，就返回 0。 
//
// 
//
// 示例 1： 
//
// 
//输入：stones = [2,7,4,1,8,1]
//输出：1
//解释：
//组合 2 和 4，得到 2，所以数组转化为 [2,7,1,8,1]，
//组合 7 和 8，得到 1，所以数组转化为 [2,1,1,1]，
//组合 2 和 1，得到 1，所以数组转化为 [1,1,1]，
//组合 1 和 1，得到 0，所以数组转化为 [1]，这就是最优值。
// 
//
// 示例 2： 
//
// 
//输入：stones = [31,26,33,21,40]
//输出：5
// 
//
// 
//
// 提示： 
//
// 
// 1 <= stones.length <= 30 
// 1 <= stones[i] <= 100 
// 
// 👍 487 👎 0


public class LastStoneWeightIi{
    public static void main(String[] args) {
         Solution solution = new LastStoneWeightIi().new Solution();
        solution.lastStoneWeightII(new int[]{1,2});
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int lastStoneWeightII(int[] stones) {
        if (stones.length == 1) {
            return stones[0];
        }
        //在石头中找到和等于sum/2可返回0
        //找到和最接近sum/2的，大-小
        int sum = 0;
        for (int stone : stones) {
            sum += stone;
        }
        int target = sum / 2;
        int length = stones.length;
        boolean[][] dp = new boolean[length][target + 1];
        //初始化
        if (stones[0] <= target) {
            dp[0][stones[0]] = true;
        }
        for (int i = 1; i < length; i++) {
            for (int j = 0; j <= target; j++) {
                dp[i][j] = dp[i - 1][j];
                if (stones[i] == j) {
                    dp[i][j] = true;
                    continue;
                }
                if (stones[i] < j) {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - stones[i]];
                }
            }}
        int res = 0;
        for (int i = dp[length - 1].length - 1; i >= 0; i--) {
            if (dp[length-1][i]){
                res = sum - 2 * i;
                break;
            }
        }
        return res;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}