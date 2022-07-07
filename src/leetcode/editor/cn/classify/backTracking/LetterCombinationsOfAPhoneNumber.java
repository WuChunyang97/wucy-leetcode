package leetcode.editor.cn.classify.backTracking;

import java.util.ArrayList;
import java.util.List;
//给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。 
//
// 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。 
//
// 
//
// 
//
// 示例 1： 
//
// 
//输入：digits = "23"
//输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
// 
//
// 示例 2： 
//
// 
//输入：digits = ""
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：digits = "2"
//输出：["a","b","c"]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= digits.length <= 4 
// digits[i] 是范围 ['2', '9'] 的一个数字。 
// 
// 👍 1984 👎 0


public class LetterCombinationsOfAPhoneNumber{
    public static void main(String[] args) {
         Solution solution = new LetterCombinationsOfAPhoneNumber().new Solution();
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    String[] letterMap = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    List<String> res = new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return res;
        }
        backTracking(digits, 0);
        return res;
    }

    StringBuilder sb = new StringBuilder();
    private void backTracking(String digits, int index) {
        if (index == digits.length()) {
            res.add(sb.toString());
            return;
        }
        int val = digits.charAt(index) - '0';
        String s = letterMap[val];
        for (int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(i)) ;
            backTracking(digits,index+1);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}