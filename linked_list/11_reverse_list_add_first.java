class Program {

  public static void addFirst(Node t_head, Node t_tail, Node curr) {

    if (t_head.next == null) {
      t_head.next = curr;
      t_tail.next = curr;
    } else {
      curr.next = t_head.next;
      t_head.next = curr;
    }

  }

  public static Node reverse(Node head) {
    Node t_head = new Node(0);
    Node t_tail = new Node(0);

    Node curr = head;

    while (curr != null) {
      Node next = curr.next;
      curr.next = null;
      addFirst(t_head, t_tail, curr);
      curr = next;
    }

    return t_head.next;
  }

  public static void main(String[] args) {
    NodeList list = new NodeList();
    list.appendList(1);
    list.appendList(2);
    list.appendList(3);
    list.appendList(4);
    list.appendList(5);
    list.appendList(6);
    list.appendList(7);
    list.display();

    Node ans = reverse(list.head);
    NodeList newList = new NodeList(ans);
    newList.display();
  }
}