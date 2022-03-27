import java.util.HashMap;
import java.util.Stack;

/*
 * Link to the problem: https://leetcode.com/problems/next-greater-element-i/
 */
class Solution {
  public int[] nextGreaterElement(int[] nums1, int[] nums2) {
    HashMap<Integer, Integer> map = new HashMap<>();
    Stack<Integer> stk = new Stack<>();

    for (int i = nums2.length - 1; i >= 0; i--) {
      if (stk.empty() == false) {
        while (stk.empty() == false && stk.peek() < nums2[i]) {
          stk.pop();
        }
        if (stk.empty()) {
          map.put(nums2[i], -1);
        } else {
          map.put(nums2[i], stk.peek());
        }
      } else {
        map.put(nums2[i], -1);
      }
      stk.push(nums2[i]);
    }
    int[] ans = new int[nums1.length];

    for (int i = 0; i < nums1.length; i++) {
      int curr = map.get(nums1[i]);
      ans[i] = curr;
    }
    return ans;
  }
}

class Program {
  public static void main(String[] args) {
    int[] A = { 4, 1, 2 };
    int[] B = { 1, 3, 4, 2 };
    Solution sol = new Solution();

    int[] C = sol.nextGreaterElement(A, B);
    for (int el : C) {
      System.out.print(el + " ");
    }
    System.out.println();
  }
}