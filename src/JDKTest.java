import linkedList.ListNode;
import org.w3c.dom.ls.LSException;

import java.util.Arrays;

/**
 * @author AndrewElvis
 * @date 2020-05-16-17:11
 * @description
 */
public class JDKTest {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        ListNode listNode = mergeTwoLists(l1, l2);
        while (listNode != null) {
            System.out.print(listNode.val);
            listNode = listNode.next;
        }


    }

    public static int[] exchange(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        while(l < r) {
            while((nums[l] & 1) == 1 && l < r) l++;
            while((nums[r] & 1) == 0 && l < r) r--;
            int tmp = nums[l];
            nums[l] = nums[r];
            nums[r] = tmp;
        }
        return nums;
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null || l2 == null) return l1 == null ? l2 : l1;
        ListNode res = new ListNode(0);
        ListNode cur = res;

        while(l1 != null && l2 != null) {
            if(l1.val <= l2.val) {
                cur.next = l1;
                cur = cur.next;
                l1 = l1.next;
            } else {
                cur.next = l2;
                cur = cur.next;
                l2 = l2.next;
            }
        }
        if(l1 == null) {
            cur.next = l2;
        }
        if(l2 == null) {
            cur.next = l1;
        }
        return res.next;
    }

}
