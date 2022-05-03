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

  static Node predecessor;
  static Node successor;

  static int state = 0;

  public static void solve(Node root, int data) {

    if (state == 0) {
      if (root.val == data) {
        state = 1;
      } else {
        predecessor = root;
      }
    } else if (state == 1) {
      successor = root;
      state = 2;
    }

    for (Node child : root.children) {
      solve(child, data);
    }

  }

  public static void main(String[] args) {

    int[] Eular1 = { 10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1, 40, 100, -1, -1,
        -1 };
    int[] Eular2 = { 20, 40, 90, -1, 60, -1, -1, 70, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1, 40, 100, -1, -1,
        -1 };

    // this array represents Eular path of N-ary tree
    // -1 represents Eular is going upward from right side of node
    Node root = generateTree(Eular1);

    solve(root, 110);

    System.out.println(predecessor.val + " " + successor.val);

  }
}