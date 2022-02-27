class Program {
  static class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
      this.val = val;
    }
  }

  public static Node deepCopy(Node head) {

    Node p = head;
    Node dummy = new Node(0);
    while(p != null) {
      
    }
  }

  public static void main(String[] args) {
    Node head = new Node(7);
    head.next = new Node(13);
    Node eleven_ref = head.next.next = new Node(11);
    Node ten_ref = head.next.next.next = new Node(10);
    head.random = head.next.next.next.next = new Node(1);
    head.next.random = head;
    head.next.next.random = null;
    ten_ref.random = eleven_ref;
    head.next.next.next.next.random = head;
  }
}