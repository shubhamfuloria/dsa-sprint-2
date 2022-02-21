/*
THINKING: 
1. initially we assume that our final reversed list is empty (as head : null),
2. We start traversing original list and keep adding in our final list from start (usign    addStart())
3. At the end of traversal we should have our final reversed list stored in head 


Benefits of addFirst reverse approach

-> after reversing list we've reference to head and tail of the linked list. 


*/
class Program {

  public static Node addFirst(Node head, Node toAdd) {

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

  public static Node reverse(Node head) {

    Node curr = head;
    head = null;

    while (curr != null) {
      Node next = curr.next;
      head = addFirst(head, curr);
      curr = next;
    }
    return head;
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