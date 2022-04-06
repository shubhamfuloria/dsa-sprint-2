import java.util.Stack;

class Program {

  public static int precedence(char c) {
    if (c == '+' || c == '-') {
      return 1;
    } else {
      return 2;
    }
  }

  public static int evaluate(int v1, int v2, char operator) {
    if (operator == '+') {
      return v1 + v2;
    } else if (operator == '-') {
      return v1 - v2;
    } else if (operator == '/') {
      return v1 / v2;
    } else {
      return v1 * v2;
    }
  }

  public static int solve(String expression) {
    Stack<Integer> oprands = new Stack<>();
    Stack<Character> operators = new Stack<>();

    for (int i = 0; i < expression.length(); i++) {

      char ch = expression.charAt(i);

      if (ch == '(') {
        operators.push(ch);

      } else if (Character.isDigit(ch)) {
        oprands.push(ch - '0');
      } else if (ch == ')') {

        while (operators.peek() != '(') {
          int v2 = oprands.pop();
          int v1 = oprands.pop();
          char op = operators.pop();

          int ans = evaluate(v1, v2, op);
          oprands.push(ans);
        }
        operators.pop();
      } else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
        // higher priority operators to solve first
        while (operators.empty() == false && operators.peek() != '('
            && precedence(ch) <= precedence(operators.peek())) {
          int v2 = oprands.pop();
          int v1 = oprands.pop();
          char op = operators.pop();

          int ans = evaluate(v1, v2, op);
          oprands.push(ans);
        }
        operators.push(ch);
      }
    }

    while (operators.empty() == false) {
      int v2 = oprands.pop();
      int v1 = oprands.pop();
      char op = operators.pop();

      int ans = evaluate(v1, v2, op);
      oprands.push(ans);
    }

    return oprands.peek();
  }

  public static void main(String[] args) {
    String expression = "2+(5-3*6/2)";
    int ans = solve(expression);
    System.out.println(ans);
  }
}