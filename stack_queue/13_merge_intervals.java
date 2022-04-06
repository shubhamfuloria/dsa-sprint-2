import java.util.Stack;
import java.util.Arrays;

class Program {

  static class Pair implements Comparable<Pair> {
    int start;
    int end;

    public Pair(int start, int end) {
      this.start = start;
      this.end = end;
    }

    public int compareTo(Pair other) {
      return this.start - other.start;
    }

  }

  public static int[][] mergeIntervals(int[][] intervals, int n) {

    Pair[] intervalsInPairs = new Pair[n];

    for (int i = 0; i < n; i++) {
      intervalsInPairs[i] = new Pair(intervals[i][0], intervals[i][1]);
    }

    Arrays.sort(intervalsInPairs);

    Stack<Pair> stk = new Stack<>();

    for (Pair curr : intervalsInPairs) {
      if (stk.empty() == false) {
        Pair prev = stk.peek();
        if (curr.start <= prev.end) {
          // we need to merge curr interval to previous one
          if (prev.end < curr.end) {
            prev.end = curr.end;
          }
        } else {
          stk.push(curr);
        }
      } else {
        stk.push(curr);
      }
    }
    int[][] ans = new int[stk.size()][2];

    Stack<Pair> newStack = new Stack<>();
    while (stk.empty() == false) {
      newStack.push(stk.pop());
    }

    int index = 0;
    while (newStack.empty() == false) {
      Pair rem = newStack.pop();
      int[] curr = { rem.start, rem.end };
      ans[index++] = curr;
    }
    return ans;
  }

  public static void main(String[] args) {
    int[][] intervals = {
        { 1, 3 },
        { 2, 6 },
        { 8, 10 },
        { 15, 18 }
    };

    int[][] ans = mergeIntervals(intervals, intervals.length);
    for (int[] el : ans) {
      System.out.println(el[0] + " " + el[1]);
    }
  }
}