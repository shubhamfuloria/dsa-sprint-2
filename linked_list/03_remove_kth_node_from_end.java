class Program {

  public static int getLength(Node head) {
    int len = 0;

    while (head != null) {
      head = head.next;
      len++;
    }
    return len;
  }

  public static Node removeKthNode(Node head, int k) {

    // 1 -> 2 -> 3 -> 4 -> 5 -> null
    /*
     * 5 - 2 => 3rd element
     * change the next pointer of length - k th node
     * 
     */
    int length = getLength(head);
    int count = 1;
    Node p = head;

    if (length == k) {
      head = head.next;
      return head;
    }

    while (count < length - k) {
      p = p.next;
      count++;
    }
    p.next = p.next.next;
    return head;
  }

  public static void main(String[] args) {
    NodeList l1 = new NodeList();
    l1.appendList(10);
    l1.appendList(20);
    l1.appendList(30);
    l1.appendList(40);
    l1.appendList(50);

    Node head = removeKthNode(l1.head, 5);
    NodeList l2 = new NodeList(head);

    l2.display();

  }
}
