import java.util.HashSet;

class Program {
  public static boolean isCyclic(Node head) {

    HashSet<Node> set = new HashSet<>();

    // traverse and store values in set
    while (head != null) {

      if (set.contains(head)) {
        return true;
      } else {
        set.add(head);
        head = head.next;
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