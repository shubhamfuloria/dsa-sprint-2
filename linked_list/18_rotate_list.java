class Program {
  static class Node {
    int val;
    Node next;

    public Node(int val) {
      this.val = val;
      this.next = null;
    }
  }

  public static Node rotateByOne(Node head) {

    // traverse till pre null node
    // point pre null node's next to head
    // return pre null node

    Node prev = null;
    Node curr = head;
    while (curr != null && curr.next != null) {
      prev = curr;
      curr = curr.next;
    }
    prev.next = null;
    curr.next = head;
    return curr;
  }

  public static Node rotateByK(Node head, int k) {
    // repeat rotateByOne k times

    for (int i = 0; i < k; i++) {
      head = rotateByOne(head);
    }
    return head;
  }

  public static void main(String[] args) {

    Node head = new Node(1);
    head.next = new Node(2);
    head.next.next = new Node(3);
    head.next.next.next = new Node(4);
    head.next.next.next.next = new Node(5);

    Node ans = rotateByK(head, 2);
    while (ans != null) {
      System.out.print(ans.val + " ");
      ans = ans.next;
    }
    System.out.println();
  }
}
