class Program {

  static class Node {
    int val;
    Node next;

    public Node(int val) {
      this.val = val;
    }
  }

  public static Node deepCopy(Node head) {
    Node p = head;
    Node dummy = new Node(0);
    Node tail = dummy;
    while (p != null) {
      tail.next = new Node(p.val);
      tail = tail.next;
      p = p.next;
    }
    return dummy.next;
  }

  public static void main(String[] args) {
    Node head = new Node(1);
    head.next = new Node(2);
    head.next.next = new Node(3);
    head.next.next.next = new Node(4);
    head.next.next.next.next = new Node(5);

    head = deepCopy(head);
    while (head != null) {
      System.out.print(head.val + " ");
      head = head.next;
    }
    System.out.println();
  }
}