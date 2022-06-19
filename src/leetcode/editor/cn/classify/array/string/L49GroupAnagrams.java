package leetcode.editor.cn.classify.array.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class L49GroupAnagrams{
//给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
//
// 字母异位词 是由重新排列源单词的字母得到的一个新单词，所有源单词中的字母通常恰好只用一次。
//
//
//
// 示例 1:
//
//
//输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
//输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
//
// 示例 2:
//
//
//输入: strs = [""]
//输出: [[""]]
//
//
// 示例 3:
//
//
//输入: strs = ["a"]
//输出: [["a"]]
//
//
//
// 提示：
//
//
// 1 <= strs.length <= 10⁴
// 0 <= strs[i].length <= 100
// strs[i] 仅包含小写字母
//
// 👍 1165 👎 0

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
//        HashMap<String, List<String>> map = new HashMap<>();
//        for (String str : strs) {
//            char[] chars = str.toCharArray();
//            Arrays.sort(chars);
//            String key=new String(chars);
//            List<String> list = map.getOrDefault(key, new ArrayList<>());
//            list.add(str);
//            map.put(key, list);
//        }
//        return new ArrayList<>(map.values());
        //这个解法熟练了API，逻辑性也很到位


        return new ArrayList<>(Arrays.stream(strs).collect(Collectors.groupingBy(str->{
            char[] chars =  str.toCharArray();
            Arrays.sort(chars);
            return new String(chars);
        })).values());
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
