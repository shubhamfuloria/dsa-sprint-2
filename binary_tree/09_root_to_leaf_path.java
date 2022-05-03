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

  static List<String> rootToLeafPaths(Node root) {

    if (root == null) {
      return new ArrayList<>();
    }

    if (root.left == null && root.right == null) {
      return new ArrayList<>(Arrays.asList(root.val + ""));
    }

    List<String> leftLeafPaths = rootToLeafPaths(root.left);
    List<String> rightLeafPaths = rootToLeafPaths(root.right);

    List<String> res = new ArrayList<>();

    for (String el : leftLeafPaths) {
      String str = root.val + "->" + el;
      res.add(str);
    }

    for (String el : rightLeafPaths) {
      String str = root.val + "->" + el;
      res.add(str);
    }

    return res;
  }

  public static void main(String[] args) {
    Integer[] eular = { 50, 25, 12, null, null, 37, null, null, 75, 62, null, null, 18, null, null };
    Node root = construct(eular);

    List<String> res = rootToLeafPaths(root);

    for (String s : res) {
      System.out.println(s);
    }
  }
}