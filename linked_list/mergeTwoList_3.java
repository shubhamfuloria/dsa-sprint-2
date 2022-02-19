public class mergeTwoList_3 {

  public static Node mergeLists(Node h1, Node h2) {

    Node head = null;
    Node tail = null;

    if (h1.val < h2.val) {
      head = tail = h1;
      h1 = h1.next;
    } else {
      head = tail = h2;
      h2 = h2.next;
    }
    while (h1 != null && h2 != null) {

      if (h1.val < h2.val) {
        tail.next = h1;
        tail = h1;
        h1 = h1.next;
      } else {
        tail.next = h2;
        tail = h2;
        h2 = h2.next;
      }
    }
    if (h1 != null) {
      tail.next = h1;
    } else {
      tail.next = h2;
    }

    return head;
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

    Node head = mergeLists(l1.head, l2.head);
    NodeList list = new NodeList(head);

    list.display();
  }
}
