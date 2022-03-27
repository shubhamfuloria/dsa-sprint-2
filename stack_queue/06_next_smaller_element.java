import java.util.Stack;

class Program {

  public static int[] nextSmallerElement(int[] A) {

    Stack<Integer> stk = new Stack<>();
    int[] ans = new int[A.length];

    for (int i = A.length - 1; i >= 0; i--) {
      if (stk.empty()) {
        ans[i] = -1;
      } else {
        while (stk.empty() == false && stk.peek() > A[i]) {
          stk.pop();
        }
        if (stk.empty()) {
          ans[i] = -1;
        } else {
          ans[i] = stk.peek();
        }
      }
      stk.push(A[i]);
    }

    return ans;
  }

  public static void main(String[] args) {
    int[] A = { 3, 8, 5, 2, 25 };
    // find next smaller element for each element in the array

    int[] ans = nextSmallerElement(A);
    for (int el : ans) {
      System.out.print(el + " ");
    }
    System.out.println();
  }
}