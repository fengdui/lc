//给你两个整数 left 和 right ，表示区间 [left, right] ，返回此区间内所有数字 按位与 的结果（包含 left 、right 端点）
//。 
//
// 
//
// 示例 1： 
//
// 
//输入：left = 5, right = 7
//输出：4
// 
//
// 示例 2： 
//
// 
//输入：left = 0, right = 0
//输出：0
// 
//
// 示例 3： 
//
// 
//输入：left = 1, right = 2147483647
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 0 <= left <= right <= 231 - 1 
// 
// Related Topics 位运算 
// 👍 361 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

class Solution {
    public int rangeBitwiseAnd(int left, int right) {

       int l1 = 0;
       int l2 = left;
       while (l2 > 0) {
           l1 ++;
           l2 >>= 1;
       }
        int r1 = 0;
        int r2 = right;
        while (r2 > 0) {
            r1 ++;
            r2 >>= 1;
        }
        int res = 0;
        if (l1 == r1) {
            while (r1 > 0) {
                int temp = 1 << (r1-1);
                if (left >=temp  && right>= temp) {
                    res += temp;
                    left -= temp;
                    right-=temp;
                } else if (left <temp  && right< temp){

                } else {
                    break;
                }
                r1--;

            }
        } else {
//            res = 1<< (r1-1);
        }
        return res;
    }
    //5 101
    //6 110
    //7 111
}
//leetcode submit region end(Prohibit modification and deletion)

