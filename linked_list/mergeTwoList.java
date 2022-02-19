public class mergeTwoList {

  static NodeList mergeLists(Node h1, Node h2) {

    NodeList l = new NodeList();

    while (h1 != null && h2 != null) {

      if (h1.val < h2.val) {
        l.appendList(h1.val);
        h1 = h1.next;
      } else {
        l.appendList(h2.val);
        h2 = h2.next;
      }
    }

    if (h1 != null)
      l.appendList(h1);
    if (h2 != null)
      l.appendList(h2);

    return l;
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

    NodeList l = mergeLists(l1.head, l2.head);
    l.display();

    l.appendList(55);

    l.display();
  }
}
