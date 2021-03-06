import java.util.Stack;
/*
 * Given a list of rates of a certain stock for some number of days, the stock
 * span​ is the number of consecutive days (before a specific day) when the
 * price of the stock was less than or equal to the price on this specific day.
 * 
 * [100, 80, 60, 70, 60, 75, 85]
 * 
 * 1st day stock span would be 1
 * 2nd day stock span would be 1
 * 3rd day stock span would be 1
 * 4th day stock span would be 2 : because 3rd day, stock was of less value then
 * today's rate
 * 5th day stock span would be 1
 * 6th day stock span would be 4 : because 5th, 4th, 3rd day, continuously stock
 * was of less value than today's rate
 * 7th day stock span would be 6 : because 6th, 5th, 4th, 3rd, 2nd day,
 * continuously stock was of less value than today's rate
 * 
 * Approach: Think about nearest greater element to the left or previous greater element
 * 
 * Evenetually we are just finding NGL / PGE,
 * => for a particular day, if we can find nearest day for which stock price was
 * greater than current day, then we can simply get the difference b/w current
 * day and that day to get number of days.
 * Isn't it ?
 * It's that simple
 */

class Program {
  static int[] stockSpan(int[] stocks) {

    int n = stocks.length;
    int[] spans = new int[n];
    Stack<Integer> stk = new Stack<>();
    spans[0] = 1;
    stk.push(0);
    for (int i = 1; i < n; i++) {
      while (stk.empty() == false && stocks[stk.peek()] < stocks[i]) {
        stk.pop();
      }
      if (stk.empty()) {
        spans[i] = i + 1;
      } else {
        spans[i] = i - stk.peek();
      }
      stk.push(i);
    }

    return spans;
  }

  public static void main(String[] args) {

    int[] stocks = { 100, 80, 60, 70, 60, 75, 85 };
    int[] spans = stockSpan(stocks);

    for (int el : spans) {
      System.out.print(el + " ");
    }
    System.out.println();
  }
}