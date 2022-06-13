package leetcode.editor.cn;//编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
//
// 
// 每行中的整数从左到右按升序排列。 
// 每行的第一个整数大于前一行的最后一个整数。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 100 
// -10⁴ <= matrix[i][j], target <= 10⁴ 
// 
// Related Topics 数组 二分查找 矩阵 👍 667 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int i = matrix.length-1; int j = matrix[0].length-1;
        while (true) {
            if (i < 0 ||j < 0)
                return false;
            if (matrix[i][j] < target) {
                return false;
            }
            if (matrix[i][j] == target)
                return true;
            if (matrix[i][j] > target) {
                j--;
            }
            if (j < 0) {
                j = matrix[0].length - 1;
                i--;
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
