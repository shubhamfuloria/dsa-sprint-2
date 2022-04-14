import java.util.*;

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

  public static void zigzagtraversal(Node root) {

    Stack<Node> ms = new Stack<>();
    Stack<Node> cs = new Stack<>();
    int level = 1;

    // odd levels are printing in non reverse form
    // even levels are printing in reversed order

    ms.push(root);

    while (ms.empty() == false) {

      Node rem = ms.pop();
      System.out.print(rem.val + " ");

      if (level % 2 == 0) {
        // we need to make decision for odd levels here, because next level is going to
        // be odd
        for (int i = rem.children.size() - 1; i >= 0; i--) {
          cs.push(rem.children.get(i));
        }
      } else {
        // we need to make decision for even levels here, because next level is going to
        // be even

        for (int i = 0; i < rem.children.size(); i++) {
          cs.push(rem.children.get(i));
        }
      }

      if (ms.empty()) {
        ms = cs;
        cs = new Stack<>();
        System.out.println();
        level++;
      }
    }
  }

  public static void main(String[] args) {

    int[] Eular = { 10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1, 40, 100, -1, -1, -1 };
    // this array represents Eular path of N-ary tree
    // -1 represents Eular is going upward from right side of node

    Node root = generateTree(Eular);

    zigzagtraversal(root);
  }
}