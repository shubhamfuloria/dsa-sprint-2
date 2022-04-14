import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Program {

  /*
   * Height: Depth of deepest node is called height.
   * can be calculated in terms of nodes of edges.
   */
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

  public static int getHeight(Node root) {

    int max_height = -1;

    for (Node child : root.children) {
      int curr_height = getHeight(child);
      max_height = Math.max(max_height, curr_height);
    }

    return max_height + 1;
  }

  public static void main(String[] args) {

    int[] Eular = { 10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1, 40, 100, -1, -1, -1 };
    // this array represents Eular path of N-ary tree
    // -1 represents Eular is going upward from right side of node

    Node root = generateTree(Eular);
    int height = getHeight(root);

    System.out.println(height);
  }
}