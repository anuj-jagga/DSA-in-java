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

    void reverseLinkedList(ListNode head){
        ListNode prev = null;
        ListNode curr = head;
        while(curr!=null){
            ListNode nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }
        return;
    }

    ListNode findKthNode(ListNode head,int k){
        ListNode curr = head;
        for(int i = 1; i < k; i++) {
            if(curr == null) return null; // k > length
            curr = curr.next;
        }
    
        return curr; // k-th node
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp = head;
        ListNode prevLast = null;

        while(temp!=null){
            ListNode kthNode = findKthNode(temp,k);
            if(kthNode == null){
                if(prevLast != null) prevLast.next = temp;
                break;
            }

            ListNode nextNode = kthNode.next;
            kthNode.next = null;
            reverseLinkedList(temp);

            if(temp == head){
                head = kthNode;
            }else{
                prevLast.next = kthNode;
            }

            prevLast = temp;
            temp = nextNode;
        }

        return head;
    }
}