class Program {
  static class Node {
    int val;
    Node next;

    public Node(int val) {
      this.val = val;
      this.next = null;
    }
  }

  public static int getLength(Node head) {
    int len = 0;
    while (head != null) {
      len++;
      head = head.next;
    }

    return len;
  }

  public static Node rotateList(Node head, int k) {

    Node p = head;
    int n = getLength(head);

    for (int i = 0; i < n - k; i++) {
      p = p.next;
    }

    Node f_head = p.next;
    p.next = null;

    p = f_head;

    while (p.next != null) {
      p = p.next;
    }
    p.next = head;

    return f_head;
  }

  public static void main(String[] args) {

    Node head = new Node(1);
    head.next = new Node(2);
    head.next.next = new Node(3);
    head.next.next.next = new Node(4);
    head.next.next.next.next = new Node(5);

    Node p = rotateList(head, 2);

    while (p != null) {
      System.out.print(p.val + " ");
      p = p.next;
    }

    System.out.println();
  }
}