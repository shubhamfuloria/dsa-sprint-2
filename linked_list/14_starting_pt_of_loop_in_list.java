class Program {

  public static Node getFirstNodeOfCycle(Node head) {
    Node hare = head;
    Node tortoise = head;

    while (hare != null && hare.next != null) {
      hare = hare.next.next;
      tortoise = tortoise.next;
      if (hare == tortoise) {
        Node ptr = head;
        while (ptr != tortoise) {
          ptr = ptr.next;
          tortoise = tortoise.next;
        }
        return tortoise;
      }
    }
    return null;

  }

  public static void main(String[] args) {
    // floyd's cycle detection algorithm

    Node head = new Node(3);
    Node ref = head.next = new Node(2);
    head.next.next = new Node(0);
    head.next.next.next = new Node(4);
    head.next.next.next.next = ref;

    Node ans = getFirstNodeOfCycle(head);
    System.out.println(ans.val);
  }
}