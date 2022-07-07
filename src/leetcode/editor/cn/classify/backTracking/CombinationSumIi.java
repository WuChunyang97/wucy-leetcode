package leetcode.editor.cn.classify.backTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
//给定一个候选人编号的集合 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。 
//
// candidates 中的每个数字在每个组合中只能使用 一次 。 
//
// 注意：解集不能包含重复的组合。 
//
// 
//
// 示例 1: 
//
// 
//输入: candidates = [10,1,2,7,6,1,5], target = 8,
//输出:
//[
//[1,1,6],
//[1,2,5],
//[1,7],
//[2,6]
//] 
//
// 示例 2: 
//
// 
//输入: candidates = [2,5,2,1,2], target = 5,
//输出:
//[
//[1,2,2],
//[5]
//] 
//
// 
//
// 提示: 
//
// 
// 1 <= candidates.length <= 100 
// 1 <= candidates[i] <= 50 
// 1 <= target <= 30 
// 
// 👍 1021 👎 0


public class CombinationSumIi{
    public static void main(String[] args) {
         Solution solution = new CombinationSumIi().new Solution();
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);//剪枝前应该先排序

        backTracking(candidates, target, 0, 0);
        return res;
    }

    private void backTracking(int[] candidates, int target, int startIndex, int sum) {
        if (target == sum) {
            res.add(new ArrayList<>(path));
            return;
        }
        if (sum > target) {
            return;
        }
        for (int i = startIndex; i < candidates.length; i++) {
            if (sum + candidates[i] > target) break;//剪枝
            if (i>startIndex&&candidates[i]==candidates[i-1]) continue;//去重！这应该能加强理解横着走是怎么回事
            path.add(candidates[i]);
            sum+=candidates[i];
            backTracking(candidates,target,i+1,sum);
            sum-=candidates[i];
            path.removeLast();

        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}