import java.util.*;

class Program {

  /*
   * In order to become two trees same in shape, every node in tree1 should have
   * exactly same no of children with respect to tree2
   * 
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

  public static void print(Node root) {

    System.out.print(root.val + ": ");

    for (Node child : root.children) {
      System.out.print(child.val + ", ");
    }
    System.out.println();
  }

  public static void display(Node node) {
    // Print(10)
    print(node);

    // recursive call for all children

    for (Node child : node.children) {
      display(child);
    }
  }

  public static boolean isSameShape(Node root1, Node root2) {
    if (root1.children.size() != root2.children.size()) {
      return false;
    }

    for (int i = 0; i < root1.children.size(); i++) {
      Node child1 = root1.children.get(i);
      Node child2 = root2.children.get(i);

      boolean isChildrenIsOfSameShape = isSameShape(child1, child2);

      if (isChildrenIsOfSameShape == false) {
        return false;
      }
    }
    return true;
  }

  public static void main(String[] args) {

    int[] Eular1 = { 10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1, 40, 100, -1, -1,
        -1 };
    int[] Eular2 = { 20, 40, 90, -1, 60, -1, -1, 70, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1, 40, 100, -1, -1,
        -1 };

    // this array represents Eular path of N-ary tree
    // -1 represents Eular is going upward from right side of node
    Node root1 = generateTree(Eular1);
    Node root2 = generateTree(Eular2);

    boolean res = isSameShape(root1, root2);
    System.out.println(res);
  }
}