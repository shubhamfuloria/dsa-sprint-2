public class mergeTwoList_2 {

  public static Node mergeLists(Node h1, Node h2) {

    Node p = new Node(0);
    Node head = p;

    while (h1 != null && h2 != null) {
      if (h1.val < h2.val) {
        Node newNode = new Node(h1.val);
        p.next = newNode;
        p = newNode;
        h1 = h1.next;
      } else {
        Node newNode = new Node(h2.val);
        p.next = newNode;
        p = newNode;
        h2 = h2.next;
      }
    }

    if (h1 != null) {
      p.next = h1;
    } else if (h2 != null) {
      p.next = h2;
    }

    return head.next;
  }

  public static void main(String[] args) {
    NodeList l1 = new NodeList();
    l1.appendList(10);
    l1.appendList(20);
    l1.appendList(30);
    l1.appendList(40);

    NodeList l2 = new NodeList();
    l2.appendList(5);
    l2.appendList(15);
    l2.appendList(25);
    l2.appendList(35);
    l2.appendList(70);

    l2.appendList(315);

    Node newHead = mergeLists(l1.head, l2.head);
    NodeList list = new NodeList(newHead);

    list.display();
  }
}
