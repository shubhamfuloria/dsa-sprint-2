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

  public static void printKLevelsDown(Node root, int k, Node blocker, List<Integer> res) {

    if (root == null || root == blocker) {
      return;
    }
    if (k == 0) {
      res.add(root.val);
    }

    printKLevelsDown(root.left, k - 1, blocker, res);
    printKLevelsDown(root.right, k - 1, blocker, res);
  }

  public static List<Node> nodeToRootPath(Node root, Node target) {

    if (root == null) {
      return null;
    }

    if (root == target) {
      return new ArrayList<>(Arrays.asList(root));
    }

    List<Node> leftPath = nodeToRootPath(root.left, target);
    if (leftPath != null) {
      leftPath.add(root);
      return leftPath;
    }

    List<Node> rightPath = nodeToRootPath(root.right, target);
    if (rightPath != null) {
      rightPath.add(root);
      return rightPath;
    }

    return null;
  }

  public static Node find(Node root, int target) {
    if (root == null) {
      return null;
    }
    if (root.val == target) {
      return root;
    }

    Node leftAns = find(root.left, target);
    if (leftAns != null) {
      return leftAns;
    }

    Node rightAns = find(root.right, target);
    if (rightAns != null) {
      return rightAns;
    }

    return null;
  }

  public static List<Integer> distanceK(Node root, Node target, int k) {

    List<Node> path = nodeToRootPath(root, target);
    List<Integer> res = new ArrayList<>();
    for (int i = 0; i < path.size(); i++) {
      Node blocker = i == 0 ? null : path.get(i - 1);
      printKLevelsDown(path.get(i), k - i, blocker, res);
    }

    return res;
  }

  public static void main(String[] args) {
    Integer[] eular = { 50, 25, 12, null, null, 37, null, null, 75, 62, null, null, 18, null, null };
    Node root = construct(eular);

    Node node = find(root, 75);

    distanceK(root, node, 3);
    System.out.println();

    // printKLevelsDown(root, 2);
    // System.out.println();

  }
}