import java.util.Stack;

class Program {

  static String printMinNumberForPattern(String S) {

    Stack<Integer> stk = new Stack<>();
    int count = 1;
    String ans = "";
    for (int i = 0; i < S.length(); i++) {
      char ch = S.charAt(i);

      if (ch == 'D') {
        stk.push(count++);
      } else {
        stk.push(count++);

        while (stk.empty() == false) {
          ans += stk.pop();
        }
      }
    }
    stk.push(count++);
    while (stk.empty() == false) {
      ans += stk.pop();
    }
    System.out.println(ans);

    return null;
  }

  public static void main(String[] args) {
    String S = "D";
    printMinNumberForPattern(S);
  }
}