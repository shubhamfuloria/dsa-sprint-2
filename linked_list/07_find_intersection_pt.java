import java.util.*;

class Program {

  public static Node getIntersectionPoint(Node head1, Node head2) {

    HashSet<Node> set = new HashSet<Node>();

    // traversing first linked list and storing references in set
    while (head1 != null) {
      set.add(head1);
      head1 = head1.next;
    }
    // traverse second linked list and check if the node already exists in the set

    while (head2 != null) {
      if (set.contains(head2)) {
        return head2;
      } else {
        head2 = head2.next;
      }
    }
    return null;
  }

  public static void main(String[] args) {
    Node head2 = new Node(3);
    Node head1 = new Node(1);
    head1.next = new Node(3);
    head1.next.next = new Node(1);
    // head2.next = head1.next.next.next = new Node(2);
    // head1.next.next.next.next = new Node(4);

    NodeList list1 = new NodeList(head1);
    NodeList list2 = new NodeList(head2);

    System.out.println(getIntersectionPoint(head1, head2));
  }
}
