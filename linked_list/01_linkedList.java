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

  public NodeList(Node head) {
    this.head = head;
  }

  public void appendList(int val) {
    if (this.head == null) {
      tail = head = new Node(val);
      return;
    }
    Node newNode = new Node(val);
    tail.next = newNode;
    tail = newNode;
  }

  public void appendList(Node newNode) {
    this.tail.next = newNode;
    while (this.tail.next != null) {
      tail = tail.next;
    }
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
  public static void main(String[] args) {
    NodeList l1 = new NodeList();
    l1.appendList(10);
    l1.appendList(20);
    l1.appendList(30);
    l1.appendList(40);
    l1.appendList(50);
    l1.display();
  }
}