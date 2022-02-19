class Program {

  static Node addTwoNumbers(Node head1, Node head2) {

    Node p = new Node(0);
    Node head = p;
    int carry = 0;

    while (head1 != null && head2 != null) {

      int curr = head1.val + head2.val + carry;
      int val = curr % 10;
      carry = curr > 9 ? 1 : 0;

      Node newNode = new Node(val);
      p.next = newNode;
      p = newNode;

      head1 = head1.next;
      head2 = head2.next;
    }

    if (head1 != null) {
      int curr = head1.val + carry;
      int val = curr % 10;
      carry = curr > 9 ? 1 : 0;
      Node newNode = new Node(val);
      p.next = newNode;
      p = newNode;
      head1 = head1.next;
    }

    if (head2 != null) {
      int curr = head1.val + carry;
      int val = curr % 10;
      carry = curr > 9 ? 1 : 0;
      Node newNode = new Node(val);
      p.next = newNode;
      p = newNode;
      head2 = head2.next;
    }

    if (carry > 0) {
      Node newNode = new Node(carry);
      p.next = newNode;
      carry = 0;
    }

    return head.next;

  }

  public static void main(String[] args) {

    NodeList l1 = new NodeList();
    l1.appendList(2);
    l1.appendList(4);
    l1.appendList(3);

    NodeList l2 = new NodeList();
    l2.appendList(5);
    l2.appendList(6);
    l2.appendList(9);

    Node head = addTwoNumbers(l1.head, l2.head);
    NodeList list = new NodeList(head);
    list.display();

  }

}
