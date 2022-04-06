import java.util.Stack;

class Program {

  public static int largestHistogramArea(int[] A) {

    // find NSL
    Stack<Integer> stk = new Stack<>();
    int[] nsl = new int[A.length];

    for (int i = 0; i < A.length; i++) {

      while (stk.empty() == false && A[i] <= A[stk.peek()]) {
        stk.pop();
      }

      if (stk.empty() == true) {
        nsl[i] = -1;
      } else {
        nsl[i] = stk.peek();
      }

      stk.push(i);
    }

    // find NSR
    int[] nsr = new int[A.length];
    stk.clear();

    for (int i = A.length - 1; i >= 0; i--) {

      while (stk.empty() == false && A[i] <= A[stk.peek()]) {
        stk.pop();
      }

      if (stk.empty() == true) {
        nsr[i] = A.length;
      } else {
        nsr[i] = stk.peek();
      }
      stk.push(i);
    }

    int max = Integer.MIN_VALUE;

    for (int i = 0; i < A.length; i++) {
      int currArea = (nsr[i] - nsl[i] - 1) * A[i];
      max = Math.max(max, currArea);
    }

    return max;
  }

  public static void main(String[] args) {
    int[] A = { 6, 2, 5, 4, 5, 1, 6 };
    largestHistogramArea(A);
  }
}
