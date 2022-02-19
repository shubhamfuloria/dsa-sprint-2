class Program {

  public static int getLength(Node head) {

    int len = 0;
    while (head != null) {
      len++;
      head = head.next;
    }
    return len;
  }

  public static Node getIntersectionPoint(Node head1, Node head2) {

    Node p = head1;
    Node q = head2;
    // while (true) {
    // if (p == q) {
    // return p.val;
    // }
    // p = p.next;
    // q = q.next;

    // if (p == null)
    // p = head2;
    // if (q == null)
    // q = head1;
    // }

    while (p != q) {
      p = p == null ? head2 : p.next;
      q = q == null ? head1 : q.next;
    }
    return p;
  }

  public static void main(String[] args) {
    Node head2 = new Node(3);
    Node head1 = new Node(1);
    head1.next = new Node(3);
    head1.next.next = new Node(1);
    head2.next = head1.next.next.next = new Node(2);
    head1.next.next.next.next = new Node(4);

    NodeList list1 = new NodeList(head1);
    NodeList list2 = new NodeList(head2);

    list1.display();
    list2.display();

    System.out.println(getLength(head1));
    System.out.println(getLength(head2));

    System.out.println("Intersection point is : " + getIntersectionPoint(head1, head2));
  }
}
