import java.util.Stack;

class Program {
  /*
   * PROBLEM: Given an array of size n, return a new array of same size with next
   * greater element, if exists else -1
   * 
   * [2, 5, 9, 3, 1, 12, 6, 8, 7]
   * [5, 9, 12, 12, 12, -1, 8, -1, -1]
   * 
   * APPROACH: Although this problem can be easily solved in O(n^2), with simple
   * searching. But we can reduce the time complixity to O(n) using stack data
   * structure. Let's see how
   * 
   * 1. traverse array from end
   * ---> last element of final array will always be -1 because there will be
   * not next greater element
   * 
   * 2. if(A[i] < stk.peek()) {
   * the element at the top is the next greater element for A[i]
   * } else {
   * while(stk.peek() < A[i]) stk.pop();
   * 
   * }
   */
  public static void main(String[] args) {
    int[] A = { 2, 5, 9, 3, 1, 12, 6, 8, 7 };

    int[] ans = new int[A.length];
    ans[A.length - 1] = -1;
    Stack<Integer> stk = new Stack<>();
    stk.push(A[A.length - 1]);

    for (int i = A.length - 2; i >= 0; i--) {

      if (A[i] < stk.peek()) {
        ans[i] = stk.peek();
      } else {
        while (stk.isEmpty() == false && stk.peek() < A[i]) {
          stk.pop();
        }
        if (stk.isEmpty()) {
          ans[i] = -1; 
        } else {
          ans[i] = stk.peek();
        }
      }
      stk.push(A[i]);
    }

    for (int el : ans) {
      System.out.print(el + " ");
    }
    System.out.println();

  }
}
