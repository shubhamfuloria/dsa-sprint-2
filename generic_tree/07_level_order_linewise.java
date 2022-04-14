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

  public static List<List<Integer>> levelorder(Node root) {
    Queue<Node> mq = new ArrayDeque<>();
    Queue<Node> cq = new ArrayDeque<>();

    List<List<Integer>> res = new ArrayList<>();
    List<Integer> curr = new ArrayList<>();
    mq.add(root);

    while (mq.isEmpty() == false) {
      Node rem = mq.remove();

      curr.add(rem.val);

      for (Node child : rem.children) {
        cq.add(child);
      }

      if (mq.isEmpty()) {
        res.add(new ArrayList<>(curr));
        curr.clear();
        mq = cq;
        cq = new ArrayDeque<>();
      }
    }
    return res;
  }

  public static void main(String[] args) {

    int[] Eular = { 10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1, 40, 100, -1, -1, -1 };
    // this array represents Eular path of N-ary tree
    // -1 represents Eular is going upward from right side of node

    Node root = generateTree(Eular);

    List<List<Integer>> res = levelorder(root);

    for (List<Integer> list : res) {
      for (int el : list) {
        System.out.print(el + " ");
      }
      System.out.println();
    }
  }
}