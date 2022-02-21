class Program {
  public static void main(String[] args) {
    NodeList list = new NodeList();
    list.appendList(1);
    list.appendList(2);
    list.appendList(3);
    list.appendList(4);
    list.appendList(5);
    list.appendList(6);
    list.appendList(7);
    list.appendList(8);

    list.display();

    Node head = reverseInKGroup(list.head, 3);

    NodeList newList = new NodeList(head);
    newList.display();
  }

  public static Node addFirst(Node head, Node toAdd) {
    // adds a node in starting of a list
    if (head == null) {
      head = toAdd;
      head.next = null;
      return head;
    } else {
      toAdd.next = head;
      head = toAdd;
      return head;
    }
  }

  public static int getLength(Node head) {
    // returns the length of list
    int length = 0;
    while (head != null) {
      length++;
      head = head.next;
    }
    return length;
  }

  public static Node reverseInKGroup(Node head, int k) {
    if (head == null || head.next == null || k == 0) {
      return head;
    }
    Node curr = head;
    head = null; // head will be the pointer to final list's head
    Node tail = null;
    Node f_head = null;
    Node f_tail = null;

    int n = getLength(curr);

    while (n >= k) {

      for (int i = 0; i < k; i++) {
        Node next = curr.next;
        // add curr node in start of list head
        if (head == null) {
          tail = curr;
        }
        head = addFirst(head, curr);
        curr = next;
      }
      if (f_head == null) {
        f_head = head;
        f_tail = tail;
      } else {
        f_tail.next = head;
        f_tail = tail;
      }
      head = null;
      tail = null;
      n -= k;
    }
    f_tail.next = curr;

    return f_head;
  }
}