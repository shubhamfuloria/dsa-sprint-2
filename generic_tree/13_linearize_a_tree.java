import java.util.*;

class Program {

  static class Node {
    int val;
    List<Node> children;

    public Node(int val) {
      this.val = val;
      this.children = new ArrayList<>();
    }
  }

  public static Node generateTree(int[] Eular) {

    Node root = null;

    Stack<Node> stk = new Stack<>();

    for (int el : Eular) {
      if (el == -1) {
        stk.pop();
      } else {
        Node newNode = new Node(el);
        if (stk.empty() == true) {
          root = newNode;
        } else {
          stk.peek().children.add(newNode);
        }
        stk.push(newNode);
      }
    }
    return root;
  }

  public static void print(Node root) {

    System.out.print(root.val + ": ");

    for (Node child : root.children) {
      System.out.print(child.val + ", ");
    }
    System.out.println();
  }

  public static void display(Node node) {
    // Print(10)
    print(node);

    // recursive call for all children

    for (Node child : node.children) {
      display(child);
    }
  }

  public static Node getTail(Node node) {

    while (node.children.size() == 1) {
      node = node.children.get(0);
    }
    return node;
  }

  public static void linearizeTree(Node root) {

    for (Node child : root.children) {
      linearizeTree(child);
    }

    while (root.children.size() > 1) {
      int totalChild = root.children.size();
      Node lastChild = root.children.remove(totalChild - 1);
      Node secondLastChild = root.children.get(totalChild - 2);

      Node slcTail = getTail(secondLastChild);
      slcTail.children.add(lastChild);
    }
  }

  public static Node linearizeTree2(Node root) {

    if (root.children.size() == 0) {
      return root;
    }

    Node lastTail = linearizeTree2(root.children.get(root.children.size() - 1));

    while (root.children.size() > 1) {
      Node lastRoot = root.children.remove(root.children.size() - 1);
      Node sLastTail = linearizeTree2(root.children.get(root.children.size() - 1));
      sLastTail.children.add(lastRoot);
    }
    return lastTail;
  }

  public static void main(String[] args) {

    int[] Eular = { 10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1, 40, 100, -1, -1, -1 };
    // this array represents Eular path of N-ary tree
    // -1 represents Eular is going upward from right side of node

    Node root = generateTree(Eular);

    display(root);
    linearizeTree2(root);
    display(root);

  }
}