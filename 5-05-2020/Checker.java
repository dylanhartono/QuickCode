import java.util.*;

public class Checker {
    public static void main(String[] args) {
        // ListNode p = new ListNode(1, new ListNode(2, null));
        // ListNode q = new ListNode(3, null);
        // p.next.next = q;
        // q = null;
        // check(p);
        // System.out.println("checking q");
        // check(q);

        // ListNode p = new ListNode(1, null);
        // ListNode q = new ListNode(2, new ListNode(3, null));
        // ListNode temp = p;
        // p = q;
        // q = p.next;
        // p.next = temp;

        // check(p);
        // check(q);

        // ListNode p = new ListNode(1, new ListNode(2));
        // ListNode q = new ListNode(3, new ListNode(4));
        // ListNode temp = q;
        // q = p;
        // p = q.next;
        // q.next = temp;
        // p.next = temp.next;
        // q.next.next = null;
        // check(p);
        // check(q);

        ListNode p = new ListNode(1);
        ListNode q = new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5))));
        ListNode temp = p;          // temp now 1
        p = q;                      // p is 2345
        q = p.next;                 // q is 345
        p.next = temp;              // p is 21
        temp = q;                   // point to 345
        q = temp.next.next;         // q to 5
        p.next.next = temp.next;    // 214 -> 5
        p.next.next.next = null;    // 214
        q.next = temp;              // 534 loop
        q.next.next = null;         // 53
        check(p);
        check(q);

    }

    public static void check(ListNode node) {
        while(node != null) {
            System.out.print(node.value + " -> ");
            node = node.next;
        }
        System.out.println();
    } 

    public static class ListNode {
        public int value;
        public ListNode next;

        public ListNode(int value) {
            this(value, null);
        }

        public ListNode(int value, ListNode next) {
            this.value = value;
            this.next = next;
        }
    }
}