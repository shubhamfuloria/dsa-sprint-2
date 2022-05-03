import java.util.*;

class Program {
  /*
   * This tenchnique of level order traversal uses a delimiter (marker) to mark
   * on each level, that this is the end of level
   * 
   * APPROACH: Whevever we see it is end of level we add a null to the queue
   * 
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

    Queue<Node> queue = new LinkedList<>();

    queue.add(root);
    queue.add(null);

    List<List<Integer>> res = new ArrayList<>();
    List<Integer> curr = new ArrayList<>();

    while (queue.isEmpty() == false) {

      // r p a

      Node rem = queue.remove();

      if (rem != null) {

        curr.add(rem.val);

        // add children of rem node
        for (Node child : rem.children) {
          queue.add(child);
        }
      } else {
        // the removed item is null
        // we are done with the current level
        res.add(curr);
        curr = new ArrayList<>();
        if (queue.isEmpty() == false) {
          // marker for next level
          queue.add(null);
        }
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