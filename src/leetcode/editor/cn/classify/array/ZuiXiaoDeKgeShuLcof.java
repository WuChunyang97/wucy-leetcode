package leetcode.editor.cn.classify.array;

import java.util.*;
//////输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
//////
//////
//////
////// 示例 1：
//////
////// 输入：arr = [3,2,1], k = 2
//////输出：[1,2] 或者 [2,1]
//////
//////
////// 示例 2：
//////
////// 输入：arr = [0,1,2,1], k = 1
//////输出：[0]
//////
//////
//////
////// 限制：
//////
//////
////// 0 <= k <= arr.length <= 10000
////// 0 <= arr[i] <= 10000
//////
////// 👍 443 👎 0
////
//


  public class ZuiXiaoDeKgeShuLcof{
      public static void main(String[] args) {
           Solution solution = new ZuiXiaoDeKgeShuLcof().new Solution();
          int[] ints = {3, 2, 1,4};
          solution.getLeastNumbers(ints, 2);
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] getLeastNumbers(int[] arr, int k) {
//特值
        if (k == 0 || arr.length == 0) {
            return new int[0];
        }
        //java的堆实现priorityQueue,默认是小顶堆
        Queue<Integer> queue = new PriorityQueue<>();
        for (int i : arr) {
            queue.offer(i);
        }
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = queue.poll();
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }
