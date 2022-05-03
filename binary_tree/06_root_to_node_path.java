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

  public static void traversals(Node root) {
    Stack<Pair> stk = new Stack<>();
    stk.push(new Pair(root, 1));
    String pre = "Pre: ";
    String in = "In: ";
    String post = "Post: ";
    while (stk.empty() == false) {

      Pair top = stk.peek();

      if (top.state == 1) { // visiting first time
        pre += top.node.val + " ";
        top.state++;
        if (top.node.left != null) {
          stk.push(new Pair(top.node.left, 1));
        }
      } else if (top.state == 2) {
        in += top.node.val + " ";
        top.state++;
        if (top.node.right != null) {
          stk.push(new Pair(top.node.right, 1));
        }
      } else {
        // visiting third time this node
        post += top.node.val + " ";
        stk.pop();
      }
    }

    System.out.println(pre);
    System.out.println(in);
    System.out.println(post);

  }

  public static List<Integer> nodeToRootPath(Node root, int dest) {
    if (root == null) {
      return null;
    }

    if (root.val == dest) {
      List<Integer> list = new ArrayList<>();
      list.add(root.val);
      return list;
    }

    List<Integer> leftPath = nodeToRootPath(root.left, dest);
    if (leftPath != null) {
      leftPath.add(0, root.val);
      return leftPath;
    }

    List<Integer> rightPath = nodeToRootPath(root.right, dest);
    if (rightPath != null) {
      rightPath.add(0, root.val);
      return rightPath;
    }
    return null;
  }

  public static void main(String[] args) {
    Integer[] eular = { 50, 25, 12, null, null, 37, null, null, 75, 62, null, null, 18, null, null };
    Node root = construct(eular);

    List<Integer> res = nodeToRootPath(root, 62);

    for (int el : res) {
      System.out.print(el + " ");
    }
    System.out.println();
  }
}