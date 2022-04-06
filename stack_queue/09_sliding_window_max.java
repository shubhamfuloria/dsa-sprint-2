import java.util.*;

class Program {
  /*
   * Problem : Given an array on size n and a window size k. We need to find
   * maximum of each window, which is sliding from left to right
   * 
   * IN: [1, 3, -1, -3, 5, 3, 6, 7], k = 3
   * OUT:[3, 3, 5, 5, 6, 7]
   * 
   * expl:
   * max of first window [1, 3, -1] => 3
   * max of second window [3, -1, -3] => 3
   * max of third window [-1, -3, 5] => 5
   * max of forth window [-3, 5, 3] => 5
   * max of fifth window [5, 3, 6] => 6
   * max of sixth window [3, 6, 7] => 7
   * 
   * no further possible window of size k
   * 
   * Approach: This problem can be easily solved by brute force, with no nested
   * loops, but that will take O(n^2), which is not good. We can solve this
   * problem in O(n) with stacks. Let's see how...
   * 
   * We already know how to find next greater element .. right ?
   * ok let's find next greater element for the given array
   * IN: [1, 3, -1, -3, 5, 3, 6, 7]
   * NG: [3, 5, 5, 5, 6, 6, 7, N]
   * 
   * Think about it.. Can you find max of sliding window with this information
   * Let's see...
   * 
   * first window is [1, 3, -1]
   * and nge is [3, 5, 5] => we know that 5 lies outside of window, so can we say
   * 3 is the max of this window?
   * 
   * second window is [3, -1, -3]
   * NGE is [5, 5, 5], again 5 lies outside of window, here we can conclude, in
   * this window 3 is maximum.
   * 
   * and so on....
   * 
   */

  public static int[] slidingWindowMax(int[] A, int k) {

    // calculate next elements
    int n = A.length;
    Stack<Integer> stk = new Stack<>();
    int[] nge = new int[n];
    nge[n - 1] = n;
    stk.push(n - 1);

    for (int i = n - 2; i >= 0; i--) {

      while (stk.empty() == false && A[stk.peek()] <= A[i]) {
        stk.pop();
      }

      if (stk.empty()) {
        // no possible candidate for the current one
        nge[i] = n;
      } else {
        nge[i] = stk.peek();
      }
      stk.push(i);
    }

    int[] res = new int[n - k + 1];
    for (int el : nge) {
      System.out.print(el + " ");
    }
    System.out.println();

    int j = 0;
    for (int i = 0; i <= n - k; i++) {

      if (j < i) {
        j = i;
      }
      while (nge[j] < i + k) {
        j = nge[j];
      }
      res[i] = A[j];
      System.out.print(A[j] + " ");
    }
    System.out.println();

    return res;
  }

  public static void main(String[] args) {
    int[] A = { 1, 3, -1, -3, 5, 3, 6, 7 };
    int[] ans = slidingWindowMax(A, 3);

    for (int el : ans) {
      System.out.print(el + " ");
    }
    System.out.println();
  }
}