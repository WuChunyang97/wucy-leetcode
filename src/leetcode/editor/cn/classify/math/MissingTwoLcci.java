package leetcode.editor.cn.classify.math;
//给定一个数组，包含从 1 到 N 所有的整数，但其中缺了两个数字。
// 你能在 O(N) 时间内只用 O(1) 的空间找到它们吗？
//
// 以任意顺序返回这两个数字均可。 
//
// 示例 1: 
//
// 输入: [1]
//输出: [2,3] 
//
// 示例 2: 
//
// 输入: [2,3]
//输出: [1,4] 
//
// 提示： 
//
// 
// nums.length <= 30000 
// 
//
// 👍 157 👎 0

//https://leetcode.cn/problems/missing-two-lcci/

public class MissingTwoLcci{
    public static void main(String[] args) {
         Solution solution = new MissingTwoLcci().new Solution();
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] missingTwo(int[] nums) {
        //数学题
        int n= nums.length+2,cur=n*(n+1)/2;
        for (int num : nums) {
            cur -= num;
        }
        int sum = cur;
        int t=cur/2;
        cur=t*(t+1)/2;
        for (int num : nums) {
            if (num<=t) cur -= num;
        }
        return new int[]{cur,sum-cur};
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}