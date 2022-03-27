import java.util.*;

class Solution {
  public boolean isValid(String s) {
    Stack<Character> stk = new Stack<>();

    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') {
        stk.push(s.charAt(i));
      } else {
        if (stk.isEmpty()) {
          return false;
        }
        char popped = stk.pop();
        if (popped == '(' && s.charAt(i) != ')') {
          return false;
        }
        if (popped == '[' && s.charAt(i) != ']') {
          return false;
        }
        if (popped == '{' && s.charAt(i) != '}') {
          return false;
        }
      }
    }

    if (stk.isEmpty()) {
      return true;
    } else {
      return false;
    }
  }
}

class Program {

  public static void main(String[] args) {
    String s = "{[()]}}";
    Solution sol = new Solution();

    System.out.println(sol.isValid(s));
  }
}