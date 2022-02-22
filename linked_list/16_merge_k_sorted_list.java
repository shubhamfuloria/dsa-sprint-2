class Program {
  static class Node {
    int val;
    Node next;

    public Node(int val) {
      this.val = val;
      this.next = null;
    }
  }

  public static Node mergeLists(Node head1, Node head2) {

    Node dummy = new Node(0);
    Node tail = dummy;

    while (head1 != null && head2 != null) {
      if (head1.val < head2.val) {
        tail.next = head1;
        tail = head1;
        head1 = head1.next;
      } else {
        tail.next = head2;
        tail = head2;
        head2 = head2.next;
      }
    }
    if (head1 != null) {
      tail.next = head1;
    } else if (head2 != null) {
      tail.next = head2;
    }

    return dummy.next;
  }

  public static Node merge(Node[] A, int n) {

    if (n == 0) {
      return null;
    }

    Node p = merge(A, n - 1);
    return mergeLists(p, A[n - 1]);
  }

  public static void main(String[] args) {

    Node head1 = new Node(1);
    head1.next = new Node(4);
    head1.next.next = new Node(5);

    Node head2 = new Node(1);
    head2.next = new Node(3);
    head2.next.next = new Node(4);

    Node head3 = new Node(2);
    head3.next = new Node(6);

    Node[] A = { head1, head2, head3 };

    Node head = merge(A, A.length);

    while (head != null) {
      System.out.print(head.val + " ");
      head = head.next;
    }
    System.out.println();
  }
}