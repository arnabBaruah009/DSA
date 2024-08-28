package Linked_List;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        int len = lengthList(head);
        ListNode resultHead = reverseLL(head, k, len);
        return resultHead;
    }

    private ListNode reverseLL(ListNode head, int k, int len){
        if(len<k) return head;

        ListNode nextHead = null;
        ListNode prev = null;
        ListNode curr = head;
        for(int i=1; i<=k; i++){
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
            if(i==k) nextHead = temp;
        }
        ListNode returnedHead = reverseLL(nextHead, k, len-k);
        head.next = returnedHead;
        return prev;
    }

    private int lengthList(ListNode head){
        int len = 0;
        while(head != null){
            head = head.next;
            len++;
        }
        return len;
    }
}
