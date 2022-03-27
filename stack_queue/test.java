import java.util.*;

class Program {
  public static void main(String[] args) {
    ArrayList<Integer> A = new ArrayList<>();
    Stack<Integer> S = new Stack<>();
    for (int i = 0; i < 10000000; i++) {
      A.add(i);
    }
    for (int i = 0; i < 10000000; i++) {
      S.push(i);
    }
    System.out.println(d.get);

    long before = System.currentTimeMillis();
    // A.remove(0);
    S.pop();
    long after = System.currentTimeMillis();

    System.out.println(after - before);
  }
}