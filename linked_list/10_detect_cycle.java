
class Program {
  public static boolean isCyclic(Node head) {

    Node slow = head;
    Node fast = head;

    while (slow != null && fast != null && fast.next != null) {

      slow = slow.next;
      fast = fast.next.next;
      if (slow == fast) {
        return true;
      }
    }
    return false;

  }

  public static void main(String[] args) {

    Node head = new Node(3);
    Node ref = head.next = new Node(2);
    head.next.next = new Node(0);
    head.next.next.next = new Node(4);
    // head.next.next.next.next = ref;

    if (isCyclic(head)) {
      System.out.println("Yes there is a cycle in the list");
    } else {
      System.out.println("There is no cycle in the list");
    }
  }

}