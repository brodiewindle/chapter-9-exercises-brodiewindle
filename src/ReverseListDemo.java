/**
 * This program includes a subroutine that makes a reversed copy of a
 * list of ints.  The main program simply tests that routine on a few lists.
 */
public class ReverseListDemo {
    // Exercise 9.3

    static class ListNode {
        int item;
        ListNode next;
    }

    static ListNode createReversedList(ListNode list) {
        ListNode reversed = null;
        ListNode move = list;
        while (move != null) {
            ListNode newNode = new ListNode();
            newNode.item = move.item;
            newNode.next = reversed;
            reversed = newNode;
            move = move.next;  // Move to next one
        }
        return reversed;
    }


    static void printList(ListNode start) {
        ListNode move;
        move = start;
        System.out.print("(");
        while (move != null) {
            System.out.print(" " + move.item);
            move = move.next;
        }
        System.out.print(" )");
    }


    public static void main(String[] args) {

        System.out.println("Printing random list and its reverse");

        ListNode list = null;
        ListNode reversedList;
        int ct = 0;

        while (true) {
            System.out.print("The list:          ");
            printList(list);
            System.out.println();
            reversedList = createReversedList(list);
            System.out.print("The reversed list: ");
            printList(reversedList);
            System.out.println();
            System.out.println();
            ct++;
            if (ct == 6)
                break;
            ListNode head = new ListNode();
            head.item = (int) (Math.random() * 100);  // A random number
            head.next = list;
            list = head;
        }

    }
}
