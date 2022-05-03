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

  public static void levelorder(Node root) {

    Queue<Node> queue = new ArrayDeque<>();

    queue.add(root);

    while (queue.isEmpty() == false) {

      int size = queue.size();

      for (int i = 0; i < size; i++) {
         Node rem = queue.remove();
        System.out.print(rem.val + " ");

        // add children of rem

        for (Node child : rem.children) {
          queue.add(child);
        }
      }
      System.out.println();

    }
  }

  public static void main(String[] args) {

    int[] Eular = { 10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1, 40, 100, -1, -1, -1 };
    // this array represents Eular path of N-ary tree
    // -1 represents Eular is going upward from right side of node

    Node root = generateTree(Eular);

    levelorder(root);

    // for (List<Integer> list : res) {
    // for (int el : list) {
    // System.out.print(el + " ");
    // }
    // System.out.println();
    // }
  }
}