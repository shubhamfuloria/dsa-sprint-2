
import java.util.*;

class Program {
  /*
   * We need to find if an element does exist in generic tree or not
   * 
   * Approach: Have faith in all children of root, that they will return true if
   * element does exists in their respective subtrees. THAT'S FUCKING IT :D
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

  public static List<Integer> rootToNodePath(Node root, int dest) {
    if (root.val == dest) {
      List<Integer> res = new ArrayList<>();
      res.add(root.val);
      return res;
    }

    for (Node child : root.children) {
      List<Integer> res = rootToNodePath(child, dest);
      if (res != null) {
        res.add(root.val);
        return res;
      }
    }

    return null;
  }

  public static int distanceBwTwoNodes(Node root, int val1, int val2) {

    List<Integer> path1 = rootToNodePath(root, val1);
    List<Integer> path2 = rootToNodePath(root, val2);

    int i = path1.size() - 1;
    int j = path2.size() - 1;

    while (i >= 0 && j >= 0 && path1.get(i) == path2.get(j)) {
      i--;
      j--;
    }

    i++;
    j++;

    return i + j;
  }

  public static void main(String[] args) {

    int[] Eular = { 10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1, 40, 100, -1, -1, -1 };
    // this array represents Eular path of N-ary tree
    // -1 represents Eular is going upward from right side of node

    Node root = generateTree(Eular);

    int res = distanceBwTwoNodes(root, 110, 90);

    System.out.println(res);
  }
}