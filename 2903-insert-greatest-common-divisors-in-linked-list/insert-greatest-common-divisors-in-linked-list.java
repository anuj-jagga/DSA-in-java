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
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        if(head == null) return null;
        if(head.next == null){
            return head;
        }

        ListNode n1 = head, n2 = head.next;

        while(n2!=null){
            int num = gcd(n1.val,n2.val);
            ListNode temp = new ListNode(num);
            temp.next = n2;
            n1.next = temp;
            n1 = n2;
            n2 = n2.next;
        }

        return head;
    }

    int gcd(int a,int b){
        if(b==0) return a;

        return gcd(b,a%b);
    }
}