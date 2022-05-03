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

  public static boolean areMirror(Node root1, Node root2) {

    if (root1.children.size() != root2.children.size()) {
      return false;
    }

    for (int i = 0; i < root1.children.size(); i++) {
      int j = root1.children.size() - 1 - i;
      Node child1 = root1.children.get(i);
      Node child2 = root2.children.get(j);

      if (areMirror(child1, child2) == false) {
        return false;
      }
    }

    return true;
  }

  public static int max_sum = 0;
  public static Node max_node = null;

  public static int calculatesMaxReturnsSum(Node root) {
    int sum = 0;
    for (Node child : root.children) {
      int curr_sum = calculatesMaxReturnsSum(child);
      sum += curr_sum;
    }

    sum += root.val;

    if (sum > max_sum) {
      max_sum = sum;
      max_node = root;
    }

    return sum;
  }

  public static void main(String[] args) {

    int[] Eular1 = { 10, 20, -50, -1, -60, -1, -1, 30, -70, -1, 80, -110, -1, 120, -1, -1, 90, -1, -1, 40, -100, -1, -1,
        -1 };

    Node root = generateTree(Eular1);

    calculatesMaxReturnsSum(root);
    System.out.println(max_sum + " " + max_node.val);
  }
}