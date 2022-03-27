import java.util.Stack;

class Program {

  public static int maxHistogramArea(int[] graph, int n) {

    Stack<Integer> stk = new Stack<>();

    // calculate number of greater or equal element to the left for each element
    int[] pse = new int[n];
    pse[0] = 0;
    stk.push(0);

    for (int i = 1; i < n; i++) {
      while (stk.empty() == false && graph[i] < graph[stk.peek()]) {
        stk.pop();
      }
      if (stk.empty()) {
        // there exist no element which is smalller than current one
        pse[i] = i;
      } else {
        pse[i] = i - stk.peek() - 1;
      }
      stk.push(i);
    }

    // calculate number of greater or equal elements to the right for each element
    stk.clear();
    int[] nge = new int[n];
    nge[n - 1] = 0;
    stk.push(n - 1);

    for (int i = n - 2; i >= 0; i--) {
      while (stk.empty() == false && graph[i] < graph[stk.peek()]) {
        stk.pop();
      }

      if (stk.empty()) {
        // there exists no element which is smaller than current one
        // in other words all elements are greater
        nge[i] = n - i - 1;
      } else {
        nge[i] = stk.peek() - i - 1;
      }

      stk.push(i);
    }
    int maxArea = 0;
    for (int i = 0; i < n; i++) {
      int total = pse[i] + nge[i] + 1;
      total *= graph[i];
      maxArea = Math.max(total, maxArea);
    }

    return maxArea;
  }

  public static void main(String[] args) {
    int[] graph = { 2, 1, 5, 6, 2, 3 };

    System.out.println(maxHistogramArea(graph, graph.length));
  }
}