class Program {

  public static int fibonacci(int n) {
    if (n == 0 || n == 1) {
      return n;
    }
    System.out.println("Calculating for " + n);

    return fibonacci(n - 1) + fibonacci(n - 2);
  }

  // memoization / top down approach
  public static int fibonacciMemoized(int n, int[] memory) {
    if (n == 0 || n == 1) {
      return n;
    }

    if (memory[n] != 0) { 
      return memory[n];
    }

    return memory[n] = fibonacciMemoized(n - 1, memory) + fibonacciMemoized(n - 2, memory);
  }

  // tabulation / bottom up approach
  public static int fibonacciDP(int n) {
    int[] dp = new int[n + 1];

    dp[1] = 1;
    dp[2] = 2;

    for (int i = 3; i < n + 1; i++) {
      dp[i] = dp[i - 1] + dp[i - 2];
    }

    return dp[n];
  }

  public static void main(String[] args) {
    int x = 100;
    System.out.println(fibonacci(x));
    // System.out.println(fibonacciMemoized(x, new int[x + 1]));

  }
}