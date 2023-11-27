package leetcode.editor.cn;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
//给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
//
// 求在该柱状图中，能够勾勒出来的矩形的最大面积。 
//
// 
//
// 示例 1: 
//
// 
//
// 
//输入：heights = [2,1,5,6,2,3]
//输出：10
//解释：最大的矩形为图中红色区域，面积为 10
// 
//
// 示例 2： 
//
// 
//
// 
//输入： heights = [2,4]
//输出： 4 
//
// 
//
// 提示： 
//
// 
// 1 <= heights.length <=10⁵ 
// 0 <= heights[i] <= 10⁴ 
// 
//
// 👍 2608 👎 0

//https://leetcode.cn/problems/largest-rectangle-in-histogram
public class LargestRectangleInHistogram{
    public static void main(String[] args) {
         Solution solution = new LargestRectangleInHistogram().new Solution();
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] l = new int[n], r = new int[n];
        Arrays.fill(l, -1);
        Arrays.fill(r, n);
        Deque<Integer> d = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            while (!d.isEmpty()&&heights[d.peekLast()]>heights[i]) r[d.pollLast()] = i;
            d.addLast(i);
        }
        d.clear();
        for (int i = n-1; i >= 0; i--) {
            while (!d.isEmpty()&&heights[d.peekLast()]>heights[i]) l[d.pollLast()] = i;
            d.addLast(i);
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            res = Math.max(res, heights[i] * (r[i] - l[i] - 1));
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}