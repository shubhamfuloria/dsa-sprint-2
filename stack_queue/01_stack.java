import java.util.*;

class Program {
  public static void main(String[] args) {
    Stack<Integer> stk = new Stack<>();

    stk.push(10);
    stk.push(20);
    stk.push(30);

    System.out.println(stk);

    int peek = stk.peek();

    System.out.println(peek);

    stk.pop();

    System.out.println(stk);
    
  }
}