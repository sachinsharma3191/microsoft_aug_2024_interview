package org.example.single_linked_list;


public class SegregateOddEvenElement328 {

    public ListNode oddEvenList(ListNode head) {
        if(head == null) {
            return null;
        }
        ListNode sentinel = new ListNode(0);
        ListNode cur = head, evenHead = null, evenTail = null, oddTail = null, oddHead = null;
        int count = 1;
        sentinel.next = oddHead;

        while (cur != null) {
            boolean isEven = count % 2 == 0;
            ListNode node = new ListNode(cur.val);
            if(isEven) {
                if(evenHead == null) {
                    evenHead = evenTail = node;
                } else {
                    evenTail.next = node;
                    evenTail = node;
                }
            } else {
                if(oddHead == null) {
                    oddHead = oddTail = node;
                } else {
                    oddTail.next = node;
                    oddTail = node;
                }
            }
            cur = cur.next;
            count++;
        }
        oddTail.next = evenHead;
        return oddHead;

    }

    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        // Example usage:
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);

        ListNode result = new SegregateOddEvenElement328().oddEvenList(head);
        printList(result); // Expected output: 5 -> 3 -> 1 -> 2 -> 4 -> 6
    }
}