package leetcode.editor.cn;//给你链表的头节点 head ，每 k 个节点一组进行翻转，请你返回修改后的链表。
//
// k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。 
//
// 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,4,5], k = 2
//输出：[2,1,4,3,5]
// 
//
// 示例 2： 
//
// 
//
// 
//输入：head = [1,2,3,4,5], k = 3
//输出：[3,2,1,4,5]
// 
//
// 
//提示：
//
// 
// 链表中的节点数目为 n 
// 1 <= k <= n <= 5000 
// 0 <= Node.val <= 1000 
// 
//
// 
//
// 进阶：你可以设计一个只用 O(1) 额外内存空间的算法解决此问题吗？ 
//
// 
// 
// Related Topics 递归 链表 👍 1671 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (k == 1)
            return head;
        ListNode res = null;
        ListNode pre = null;
        while (head != null) {
            int count = 0;
            ListNode current = head;
            while (current != null) {
                count++;
                current = current.next;
                if (count >= k) {
                    break;
                }
            }
            if (count < k) {
                return res == null ? head : res;
            }

            int tmp = k;

            ListNode head2 = head;
            ListNode head3 = head;
            ListNode currentPre = current;
            while (tmp-- > 0) {
                ListNode next = head2.next;
                head2.next = currentPre;
                currentPre = head2;
                head2 = next;
            }
            if (pre != null) {
                pre.next = currentPre;
            }
            pre = head3;
            head = head2;
            if (res == null)
                res = currentPre;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
