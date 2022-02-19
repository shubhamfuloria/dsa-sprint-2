import java.util.HashSet;

class Node {
  public int val;
  public Node next;

  public Node(int val) {
    this.val = val;
    this.next = null;
  }
}

class ground {

  public static int getLength(Node head) {
    int count = 0;

    while (head != null) {
      count++;
      head = head.next;
    }
    return count;
  }

  public static Node getIntersectionPoint(Node headA, Node headB) {

    int l1 = getLength(headA);
    int l2 = getLength(headB);

    if (l1 > l2) {
      // l1 is larger list so we will forward l1(larger list) by l1 - l2 times
      for (int i = 0; i < l1 - l2; i++) {
        headA = headA.next;
      }
    } else if (l2 > l1) {
      // l2 is larger list so we will forward l2 (larger list) by l2 - l1 times
      headB = headB.next;
    }

    // now we will move headA and headB simultaneously , and they will meet at the
    // intersection point

    while (headA != null && headB != null) {
      if (headA == headB) {
        return headA;
      }
      headA = headA.next;
      headB = headB.next;
    }
    return null;
  }

  public static void main(String[] args) {

    Node headA = new Node(4);
    headA.next = new Node(1);
    Node ref = headA.next.next = new Node(8);
    headA.next.next.next = new Node(4);
    headA.next.next.next.next = new Node(5);

    Node headB = new Node(5);
    headB.next = new Node(6);
    headB.next.next = new Node(1);
    // headB.next.next.next = ref;

    NodeList list1 = new NodeList(headA);
    NodeList list2 = new NodeList(headB);

    list1.display();
    list2.display();

    Node intersectionPoint = getIntersectionPoint(headA, headB);

    System.out.println("Intersection point is " + intersectionPoint);

  }
}
