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

  public static int height(Node root) {
    if (root == null) {
      return -1;
    }
    return Math.max(height(root.left), height(root.right)) + 1;
  }

  static class PairBST {
    boolean isBST;
    long min;
    long max;
    Node root;
    int size;
  }

  private static PairBST helper(Node root) {

    if (root == null) {
      PairBST mp = new PairBST();
      mp.isBST = true;
      mp.min = Long.MAX_VALUE;
      mp.max = Long.MIN_VALUE;
      mp.root = null;
      mp.size = 0;
      return mp;
    }

    PairBST lp = helper(root.left);
    PairBST rp = helper(root.right);

    PairBST mp = new PairBST();
    mp.min = Math.min(root.val, Math.min(lp.min, rp.min));
    mp.max = Math.max(root.val, Math.max(lp.max, rp.max));
    mp.isBST = lp.isBST && rp.isBST && (lp.max < root.val) && (root.val < rp.min);

    if (mp.isBST) {
      mp.root = root;
      mp.size = lp.size + rp.size + 1;
    } else if (lp.size > rp.size) {
      mp.root = lp.root;
      mp.size = lp.size;
    } else {
      mp.root = rp.root;
      mp.size = rp.size;
    }

    return mp;
  }

  private static boolean isBST(Node root) {
    return helper(root).isBST;
  }

  public static void main(String[] args) {
    Integer[] eular = { 10, 5, 2, null, null, 8, null, null, 20, 15, null, null, 25, null, null };

    Node root = construct(eular);
    boolean res = isBST(root);
    System.out.println(res);
  }
}
