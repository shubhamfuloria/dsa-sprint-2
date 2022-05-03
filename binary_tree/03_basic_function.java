import java.util.*;

class Program {
  // we need to find size, sum, max, min, height of a binary tree
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

  public static int size(Node root) {

    if (root == null) {
      return 0;
    }

    int left_size = size(root.left);
    int right_size = size(root.right);

    return left_size + right_size + 1;
  }

  public static int sum(Node root) {

    if (root == null) {
      return 0;
    }

    int left_sum = sum(root.left);
    int right_sum = sum(root.right);

    return left_sum + right_sum + root.val;
  }

  public static int height(Node root) {
    if (root == null) {
      return 0;
    }

    int left_height = height(root.left);
    int right_height = height(root.right);

    return 1 + Math.max(left_height, right_height);
  }

  public static int max(Node root) {

    if (root == null) {
      return Integer.MIN_VALUE;
    }

    int left_max = max(root.left);
    int right_max = max(root.right);

    return Math.max(root.val, Math.max(left_max, right_max));
  }

  public static void main(String[] args) {
    Integer[] eular = { 50, 25, 12, null, null, 37, 30, null, null, null, 75, 62, null, 70, null, null, 87, null,
        null };
    Node root = construct(eular);

    System.out.println("Max: " + max(root));
    System.out.println("Sum: " + sum(root));
    System.out.println("Height: " + height(root));
    System.out.println("size: " + size(root));

  }
}