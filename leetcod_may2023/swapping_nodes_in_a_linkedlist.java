class Solution {
    public ListNode swapNodes(ListNode head, int k) {
        ListNode first = head, second = head;

        for (int i = 0; i < k - 1; ++i)
            first = first.next;

        ListNode tail = first;
        while (tail.next != null) {
            second = second.next;
            tail = tail.next;
        }

        int temp = first.val;
        first.val = second.val;
        second.val = temp;

        return head;
    }
}