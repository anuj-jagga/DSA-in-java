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
    // concepts
    // merge sort on LL(find middle of LL by slow and fast pointers)
    // merge two sorted LLs

    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }

        // merge sort
        ListNode mid = findMid(head);
        ListNode leftHead = head, rightHead = mid.next;
        mid.next = null;
        ListNode list1 = sortList(leftHead);
        ListNode list2 = sortList(rightHead);
        return mergeTwoLists(list1, list2);
    }


    public ListNode findMid(ListNode head){
        ListNode slow = head, fast = head.next; // note : here we are finding 1st mid not second thats why fast starts from head.next

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0);
        ListNode a = list1;
        ListNode b = list2;
        ListNode current = dummy;
        while(a != null && b != null){
            if(a.val > b.val){
                current.next = b;
                b = b.next;
            }else{
                current.next = a;
                a = a.next;
            }

            current = current.next;
        }

        if(a!=null){
            current.next = a;
        }

        if(b!=null){
            current.next = b;
        }
        
        return dummy.next;
    }
}