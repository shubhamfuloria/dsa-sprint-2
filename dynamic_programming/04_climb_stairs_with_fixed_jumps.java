class Program {

  public static int climbStairs(int n, int[] A) {

    if (n == 0) {
      return 1;
    } else if (n < 0) {
      return 0;
    }

    int total_paths = 0;

    // [1, 3, 5]

    for (int i = 0; i < A.length; i++) {
      total_paths += climbStairs(n - A[i], A);
    }

    return total_paths;
  }

  public static int climbStairs2(int n, int pos, int[] A) {
    if (pos == n) {
      return 1;
    } else if (pos > n) {
      return 0;
    }

    int total_paths = 0;

    for (int i = 0; i < A.length; i++) {
      total_paths += climbStairs2(n, pos + A[i], A);
    }

    return total_paths;
  }

  public static void main(String[] args) {
    int[] A = { 1, 2, 3 };

    System.out.println(climbStairs(10, A));
    System.out.println(climbStairs2(10, 0, A));

  }
}