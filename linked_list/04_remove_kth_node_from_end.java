class Program {

  public static Node removeKthNodeFromEnd(Node head, int k) {

    Node dummy = new Node(0);
    dummy.next = head;
    Node slow = dummy;
    Node fast = dummy;

    // moving forward fast by k nodes
    for (int i = 0; i < k; i++) {
      fast = fast.next;
    }

    // we need to stop one prior of target node to remove the target
    while (fast.next != null) {
      fast = fast.next;
      slow = slow.next;
    }

    slow.next = slow.next.next;

    return dummy.next;
  }

  public static void main(String[] args) {
    NodeList l1 = new NodeList();
    l1.appendList(10);
    l1.appendList(20);
    l1.appendList(30);
    l1.appendList(40);
    l1.appendList(50);

    l1.display();

    Node head = removeKthNodeFromEnd(l1.head, 5);
    NodeList l2 = new NodeList(head);
    l2.display();

  }
}
