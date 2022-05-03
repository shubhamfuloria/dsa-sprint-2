import java.util.*;

class Program {
  public static class Node {
    int val;
    Node left;
    Node right;

    public Node(int val) {
      this.val = val;
      this.left = null;
      this.right = null;
    }
  }

  public static class Pair {
    public Node node;
    public int state;

    public Pair(Node node, int state) {
      this.node = node;
      this.state = state;
    }
  }

  public static Node construct(Integer[] eular) {

    Stack<Pair> stk = new Stack<>();

    Node rootNode = new Node(eular[0]);
    Pair rootPair = new Pair(rootNode, 1);

    stk.push(rootPair);
    int index = 1;
    for (int i = 1; i < eular.length; i++) {
      Pair top = stk.peek();
      Integer curr = eular[i];

      if (top.state == 1) {
        // add curr element to left of top
        if (curr != null) {
          Node newNode = new Node(curr);
          top.node.left = newNode;

          Pair newPair = new Pair(newNode, 1);
          stk.push(newPair);
        }
        top.state++;
      } else if (top.state == 2) {
        // add curr element to right of top
        if (curr != null) {
          Node newNode = new Node(curr);
          top.node.right = newNode;
          stk.pop();

          Pair newPair = new Pair(newNode, 1);
          stk.push(newPair);
        } else {
          stk.pop();
        }
      }
    }
    return rootNode;
  }

  static boolean hasPathSum(Node root, int S) {

    if (root == null) {
      return false;
    }

    if (root.left == null && root.right == null) {
      return S == root.val;
    }

    boolean leftAns = hasPathSum(root.left, S - root.val);
    boolean rightAns = hasPathSum(root.right, S - root.val);

    return leftAns || rightAns;
  }

  public static void main(String[] args) {
    Integer[] eular = {1, 2, 4, null, null, 5, null, null, 3, 6, null, null, null };
    Node root = construct(eular);

    boolean res = hasPathSum(root, 8);
    System.out.println(res);
  }
}