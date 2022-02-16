//给定一组非负整数 nums，重新排列每个数的顺序（每个数不可拆分）使之组成一个最大的整数。 
//
// 注意：输出结果可能非常大，所以你需要返回一个字符串而不是整数。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [10,2]
//输出："210" 
//
// 示例 2： 
//
// 
//输入：nums = [3,30,34,5,9]
//输出："9534330"
// 
//
// 示例 3： 
//
// 
//输入：nums = [1]
//输出："1"
// 
//
// 示例 4： 
//
// 
//输入：nums = [10]
//输出："10"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 100 
// 0 <= nums[i] <= 109 
// 
// Related Topics 贪心 字符串 排序 
// 👍 871 👎 0


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public static String largestNumber(int[] nums) {
        String[] s = new String[nums.length];

        List[] lists = new ArrayList[10];
        for (int i = 0; i < 10; i++) {
            lists[i] = new ArrayList<>();
        }
        for (int i = 0; i < nums.length; i++) {
            s[i] = String.valueOf(nums[i]);
//            s[i] = new StringBuilder(s[i]).reverse().toString();
            lists[s[i].charAt(0) - '0'].add(s[i]);
//            System.out.println(s[i].charAt(0));
        }
        for (int i = 9; i >= 0; i--) {
            int finalI = i;
            lists[i].sort(new Comparator() {
                @Override
                public int compare(Object o1, Object o2) {
                    String s1 = (String) o1;
                    String s2 = (String) o2;
                    String x = s1 + s2;
                    String y = s2 + s1;
                    for (int j = 0;; j++) {
                        if (j + 1 > x.length()) {
                            return 0;
                        }
                        int aa = x.charAt(j)-'0';
                        int bb = y.charAt(j)-'0';
                        if (aa == bb) {
                            continue;
                        }
                        return aa > bb ? -1 : 1;
                    }
                }
            });
        }
        StringBuilder res = new StringBuilder();
        for (int i = 9; i >= 0; i--) {
            if (lists[i].size() == 0) {
                continue;
            }
            for (Object ss : lists[i]) {
                String sss = (String) ss;
                res.append(sss);
                System.out.println(sss);
            }
        }
        String sss = res.toString();
        StringBuilder stringBuilder = new StringBuilder();
        boolean flag = true;
        for (int i =0; i< sss.length(); i++) {

            if (sss.charAt(i)-'0' ==0) {
                if (flag) {
                    continue;
                } else {
                    stringBuilder.append(sss.charAt(i));
                }
            } else {
                flag =false;
                stringBuilder.append(sss.charAt(i));
            }
        }
        if (stringBuilder.length() ==0) {
            return "0";
        }
        return stringBuilder.toString();
    }

}
//leetcode submit region end(Prohibit modification and deletion)
