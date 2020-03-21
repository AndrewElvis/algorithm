package linkedList;

/**
 * @author AndrewElvis
 * @date 2020-03-15-17:47
 */
public class QuickSortList {

    public static ListNode getTail(ListNode head) {
        while (head.next != null) {
            head = head.next;
        }
        return head;
    }

    public static ListNode process(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode left = new ListNode(0), mid = new ListNode(0), right = new ListNode(0);
        ListNode ltail = left, mtail = mid, rtail = right;
        int value = head.val;
        for (ListNode cur = head; cur != null; cur = cur.next) {
            if (cur.val < value) {
                ltail = ltail.next = cur;
            } else if (cur.val == value) {
                mtail = mtail.next = cur;
            } else {
                rtail = rtail.next = cur;
            }
        }
        ltail.next = mtail.next = rtail.next = null;
        left.next = process(left.next);
        right.next = process(right.next);
        //拼接三个链表
        getTail(left).next = mid.next;
        getTail(left).next = right.next;
        return left;

    }
}
