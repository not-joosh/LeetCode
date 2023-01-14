/*
        206. Reverse Linked List
        Easy
        16.3K
        274
        Companies
        Given the head of a singly linked list, reverse the list, and return the reversed list.

        

        Example 1:


        Input: head = [1,2,3,4,5]
        Output: [5,4,3,2,1]
        Example 2:


        Input: head = [1,2]
        Output: [2,1]
        Example 3:

        Input: head = []
        Output: []
        

        Constraints:

        The number of nodes in the list is the range [0, 5000].
        -5000 <= Node.val <= 5000
        

        Follow up: A linked list can be reversed either iteratively or recursively. Could you implement both?
*/
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
    public ListNode reverseList(ListNode head) {
        // Initialize previous and current pointers
        ListNode prev = null;
        ListNode current = head;
        
        // Iterate through the list, reversing the pointers
        while (current != null) {
            ListNode nextTemp = current.next;
            current.next = prev;
            prev = current;
            current = nextTemp;
        }
        
        // Return the new head of the reversed list
        return prev;
    }
}
