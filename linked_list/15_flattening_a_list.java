import java.util.ArrayList;
import java.util.Collection;
import java.util.*;

class Program {

  static class Node {
    int val;
    Node next;
    Node bottom;

    public Node(int val) {
      this.val = val;
      this.next = null;
      this.bottom = null;
    }
  }

  public static Node mergeLists(Node head1, Node head2) {

    Node dummy = new Node(0);
    Node tail = dummy;

    while (head1 != null && head2 != null) {
      if (head1.val < head2.val) {
        tail.bottom = head1;
        tail = head1;
        head1 = head1.bottom;
      } else {
        tail.bottom = head2;
        tail = head2;
        head2 = head2.bottom;
      }
    }
    if (head1 != null) {
      tail.bottom = head1;
    } else if (head2 != null) {
      tail.bottom = head2;
    }

    return dummy.bottom;
  }

  public static Node flatten(Node head) {
    if (head == null || head.next == null) {
      return head;
    }

    Node flattenedList = flatten(head.next);
    Node p = mergeLists(flattenedList, head);
    return p;
  }

  public static void main(String[] args) {

    Node head = new Node(5);
    head.next = new Node(10);
    head.next.next = new Node(19);
    head.next.next.next = new Node(28);

    Node b1 = new Node(7);
    b1.bottom = new Node(8);
    b1.bottom.bottom = new Node(30);
    head.bottom = b1;

    Node b2 = new Node(20);
    head.next.bottom = b2;

    Node b3 = new Node(22);
    b3.bottom = new Node(50);
    head.next.next.bottom = b3;

    Node b4 = new Node(35);
    b4.bottom = new Node(40);
    b4.bottom = new Node(45);
    head.next.next.next.bottom = b4;

    Node p = flatten(head);

    while (p != null) {
      System.out.print(p.val + " ");
      p = p.bottom;
    }
    System.out.println();
  }
}