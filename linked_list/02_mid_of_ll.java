class Node {
  public int val;
  public Node next;

  public Node(int val) {
    this.val = val;
    this.next = null;
  }
}

class NodeList {
  public Node head;
  public Node tail;

  public NodeList() {
    this.head = null;
  }

  public NodeList(Node node) {
    this.head = node;
  }

  public void appendList(int val) {
    if (this.head == null) {
      head = new Node(val);
      return;
    }
    Node p = this.head;
    while (p.next != null) {
      p = p.next;
    }
    p.next = new Node(val);
  }

  public void display() {
    Node curr = this.head;
    if (curr == null) {
      System.out.println("List is empty.");
    } else {
      while (curr != null) {
        System.out.print(curr.val + "  ");
        curr = curr.next;
      }
      System.out.println();
    }
  }
}

class Program {

  static int getLengthOfList(Node head) {
    Node curr = head;
    int count = 0;
    while (curr != null) {
      count++;
      curr = curr.next;
    }
    return count;
  }

  static NodeList getMidList(Node head) {
    Node curr = head;
    int n = getLengthOfList(head);
    int target = n / 2;
    int count = 0;

    while (curr != null) {
      if (count == target) {
        return new NodeList(curr);
      } else {
        curr = curr.next;
        count++;
      }
    }
    return null;
  }

  public static void main(String[] args) {
    NodeList l1 = new NodeList();

    l1.appendList(10);
    l1.appendList(20);
    l1.appendList(30);
    l1.appendList(40);
    l1.appendList(50);

    NodeList midNode = getMidList(l1.head);
    midNode.display();
  }
}