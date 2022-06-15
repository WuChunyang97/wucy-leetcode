package leetcode.editor.cn;

import java.util.Arrays;

public class L242ValidAnagram{
//给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
//
// 注意：若 s 和 t 中每个字符出现的次数都相同，则称 s 和 t 互为字母异位词。
//
//
//
// 示例 1:
//
//
//输入: s = "anagram", t = "nagaram"
//输出: true
//
//
// 示例 2:
//
//
//输入: s = "rat", t = "car"
//输出: false
//
//
//
// 提示:
//
//
// 1 <= s.length, t.length <= 5 * 10⁴
// s 和 t 仅包含小写字母
//
//
//
//
// 进阶: 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
// 👍 600 👎 0

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isAnagram(String s, String t) {
        //长度不等，返回false
        if (s.length()!=t.length()) return false;
//        char[] ss = s.toCharArray();
//        char[] ts = t.toCharArray();
//        Arrays.sort(ss);
//        Arrays.sort(ts);
//        return Arrays.equals(ss, ts);
        //
        int[] table = new int[26];
        for (int i = 0; i < s.length(); i++) {
            table[s.charAt(i)-'a']++;
            table[t.charAt(i)-'a']--;
        }
        return Arrays.stream(table).noneMatch(num -> num != 0);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
