package org.example.single_linked_list;


public class SeparateOddEven {
    public static void main(String[] args) {
        // Example linked list: 1 -> 2 -> 3 -> 4 -> 5 -> 6
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);

        ListNode result = separateOddEven(head);
        printList(result); // Expected output: 5 -> 3 -> 1 -> 2 -> 4 -> 6
    }

    public static ListNode separateOddEven(ListNode head) {
        if (head == null) return null;

        ListNode oddHead = null, evenHead = null;
        ListNode oddTail = null, evenTail = null;

        // Traverse the list and separate odd and even nodes
        ListNode current = head;
        while (current != null) {
            if (current.val % 2 != 0) {
                // Node is odd
                ListNode nextNode = current.next;
                current.next = oddHead;
                oddHead = current;
                current = nextNode;
            } else {
                // Node is even
                if (evenHead == null) {
                    evenHead = current;
                    evenTail = current;
                } else {
                    evenTail.next = current;
                    evenTail = current;
                }
                current = current.next;
            }
        }

        // Connect the last node of the even list to null
        if (evenTail != null) {
            evenTail.next = null;
        }

        // If there are no odd elements, return the even list
        if (oddHead == null) {
            return evenHead;
        }

        // Connect the end of the odd list to the head of the even list
        ListNode reversedOdd = oddHead;
        while (reversedOdd.next != null) {
            reversedOdd = reversedOdd.next;
        }
        reversedOdd.next = evenHead;

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
}