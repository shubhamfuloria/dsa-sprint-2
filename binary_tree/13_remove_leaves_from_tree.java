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

  public static Node toLeftClonedTree(Node root) {

    if (root == null) {
      return root;
    }

    Node leftClone = toLeftClonedTree(root.left);
    Node rightClone = toLeftClonedTree(root.right);

    Node newNode = new Node(root.val);
    newNode.left = leftClone;

    root.right = rightClone;
    root.left = newNode;

    return root;
  }

  public static void levelorder(Node root) {

    Queue<Node> queue = new ArrayDeque<>();
    queue.add(root);

    while (queue.isEmpty() == false) {
      // r w a
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        Node rem = queue.remove();
        System.out.print(rem.val + " ");

        if (rem.left != null) {
          queue.add(rem.left);
        }

        if (rem.right != null) {
          queue.add(rem.right);
        }
      }
      System.out.println();

    }

  }

  public static void removeLeaves(Node root) {

    if (root == null) {
      return;
    }

    if (root.left.left == null && root.left.right == null) {
      root.left = null;
    }

    if (root.right.left == null && root.right.right == null) {
      root.right = null;
    }

    removeLeaves(root.left);
    removeLeaves(root.right);
  }

  public static Node removeLeaves2(Node root) {

    if (root == null) {
      return null;
    }

    if (root.left == null && root.right == null) {
      return null;
    }

    root.left = removeLeaves2(root.left);
    root.right = removeLeaves2(root.right);

    return root;
  }

  public static void main(String[] args) {
    Integer[] eular = { 50, 25, 12, null, null, 37, null, null, 75, 62, null, null, 18, null, null };
    Node root = construct(eular);

    levelorder(root);
    removeLeaves2(root);
    levelorder(root);
  }
}
