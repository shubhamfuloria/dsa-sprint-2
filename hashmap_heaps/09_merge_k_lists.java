import java.util.PriorityQueue;
/*
Approach: 
-> Add all the lists's head to priority queue (min priority queue)
-> remove node from the pqueue (it is guaranteed that removed node will be smallest)
-> add removed node's next node (if exists) to pqueue
-> append the final list with removed node
-> repeat the process until pqueue gets empty



*/
class Program {
  static class Node implements Comparable<Node> {
    int val;
    Node next;

    public Node(int val) {
      this.val = val;
      this.next = null;
    }

    public int compareTo(Node o) {
      return this.val - o.val;
    }
  }

  public static Node merge(Node[] A, int n) {

    PriorityQueue<Node> pq = new PriorityQueue<>();

    Node head = new Node(0);
    Node tail = head;

    for (Node el : A) {
      pq.add(el);
    }

    while (pq.isEmpty() == false) {
      Node removedNode = pq.remove();
      if (removedNode.next != null) {
        pq.add(removedNode.next);
      }
      tail.next = removedNode;
      tail = tail.next;
    }

    return head.next;
  }

  public static void main(String[] args) {

    Node head1 = new Node(1);
    head1.next = new Node(4);
    head1.next.next = new Node(5);

    Node head2 = new Node(1);
    head2.next = new Node(3);
    head2.next.next = new Node(4);

    Node head3 = new Node(2);
    head3.next = new Node(6);

    Node[] A = { head1, head2, head3 };

    Node head = merge(A, A.length);

    while (head != null) {
      System.out.print(head.val + " ");
      head = head.next;
    }
    System.out.println();
  }
}