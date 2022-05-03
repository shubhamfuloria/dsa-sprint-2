class Program {

  public static int minCostPath(int[][] cost, int n, int i, int j) {

    if (i == n - 1 && j == n - 1) {
      return cost[i][j];
    } else if (i == n || j == n) {
      return Integer.MAX_VALUE;
    }

    int op1 = minCostPath(cost, n, i, j + 1);
    int op2 = minCostPath(cost, n, i + 1, j);

    return Math.min(op1, op2) + cost[i][j];
  }

  public static void main(String[] args) {
    int[][] cost = {
        { 1, 2, 3 },
        { 4, 8, 2 },
        { 1, 5, 3 }
    };
    int res = minCostPath(cost, 3, 0, 0);
    System.out.println(res);
  }
}