import java.util.*;

class Program {

  public static int precedence(char ch) {

    if (ch == '+' || ch == '-') {
      return 1;
    } else {
      return 2;
    }
  }

  public static String solve(String expr) {
    Stack<String> prefix = new Stack<>();
    Stack<Character> operator = new Stack<>();

    for (int i = 0; i < expr.length(); i++) {
      char ch = expr.charAt(i);

      if (ch == '(') {
        operator.push(ch);
      } else if (ch == ')') {

        while (operator.peek() != '(') {

          char op = operator.pop();
          String v2 = prefix.pop();
          String v1 = prefix.pop();

          // prefix of this will be opv1v2
          String pre = op + v1 + v2;
          prefix.push(pre);
        }
        operator.pop();
      } else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {

        while (operator.empty() == false && operator.peek() != '(' && precedence(ch) <= precedence(operator.peek())) {
          char op = operator.pop();
          String v2 = prefix.pop();
          String v1 = prefix.pop();

          // prefix of this will be opv1v2
          String pre = op + v1 + v2;
          prefix.push(pre);
        }
        operator.push(ch);
      } else {
        // ch is a, b, c, d......
        prefix.push(String.valueOf(ch));
      }
    }
    while (operator.empty() == false) {
      char op = operator.pop();
      String v2 = prefix.pop();
      String v1 = prefix.pop();

      // prefix of this will be opv1v2
      String pre = op + v1 + v2;
      prefix.push(pre);
    }
    return prefix.peek();
  }

  public static void main(String[] args) {
    String expr = "a*(b-c)/d+e";
    String ans = solve(expr);

    System.out.println(ans);
  }
}