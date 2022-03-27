import java.util.*;

class Program {

  static boolean ifDuplicate(String S) {

    Stack<Character> st = new Stack<>();

    for (int i = 0; i < S.length(); i++) {
      if (S.charAt(i) != ')') {
        st.push(S.charAt(i));
      } else {
        if (st.peek() == '(') {
          return true;
        } else {
          while (st.peek() != '(') {
            st.pop();
          }
          st.pop();
        }
      }
    }
    return false;
  }

  public static void main(String[] args) {
    String s1 = "((a + b) + (c + d))";
    String s2 = "(a + b) + ((c + d))";

    System.out.println(ifDuplicate(s1));
    System.out.println(ifDuplicate(s2));

  }

}
