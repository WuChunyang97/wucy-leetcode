package leetcode.editor.cn.classify.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L15ThreeSum{
////给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？
// 请你找出所有和为 0 且
//不重
////复的三元组。
////
//// 注意：答案中不可以包含重复的三元组。
////
////
////
//// 示例 1：
////
////
////输入：nums = [-1,0,1,2,-1,-4]
////输出：[[-1,-1,2],[-1,0,1]]
////
////
//// 示例 2：
////
////
////输入：nums = []
////输出：[]
////
////
//// 示例 3：
////
////
////输入：nums = [0]
////输出：[]
////
////
////
////
//// 提示：
////
////
//// 0 <= nums.length <= 3000
//// -10⁵ <= nums[i] <= 10⁵
////
//// 👍 4861 👎 0
//

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length < 3) return res;
        Arrays.sort(nums);
        for (int i = 0, n = nums.length; i < n; i++) {
            if (nums[i] > 0) break;
            if (i>0&&nums[i] == nums[i - 1]) continue;//应该是判断与前一个
            int l = i + 1;
            int r = n - 1;
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (sum == 0) {
                    res.add(Arrays.asList(nums[i] , nums[l] , nums[r]));
                    while (l < r && nums[l] == nums[l+1]) {
                        l++;
                    }
                    while (l < r && nums[r] == nums[r-1]) {
                        r--;
                    }
                    l++;r--;
                } else if (sum > 0) {
                    r--;
                }else {
                    l++;
                }
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
