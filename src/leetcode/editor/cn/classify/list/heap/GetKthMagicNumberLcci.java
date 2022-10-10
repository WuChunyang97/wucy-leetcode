package leetcode.editor.cn.classify.list.heap;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;
//有些数的素因子只有 3，5，7，请设计一个算法找出第 k 个数。注意，不是必须有这些素因子，
// 而是必须不包含其他的素因子。例如，前几个数按顺序应该是 1，3，
//5，7，9，15，21。 
//
// 示例 1: 
//
// 输入: k = 5
//
//输出: 9
// 
//
// 👍 180 👎 0

//https://leetcode.cn/problems/get-kth-magic-number-lcci
public class GetKthMagicNumberLcci{
    public static void main(String[] args) {
         Solution solution = new GetKthMagicNumberLcci().new Solution();
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int getKthMagicNumber(int k) {
        int[] factors = {3, 5, 7};
        Set<Long> set = new HashSet<>();
        PriorityQueue<Long> heap = new PriorityQueue<>();
        set.add(1L);
        heap.offer(1L);
        int magic = 0;
        for (int i = 0; i < k; i++) {
            long curr = heap.poll();
            magic = (int)curr;
            for (int factor : factors) {
                if (set.add(factor * curr)) {
                    heap.offer(factor * curr);
                }
            }
        }
        return magic;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}