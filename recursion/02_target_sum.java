class Program {

  public static boolean subsetSum(int[] A, int target, int n) {
    if (target == 0) {
      return true;
    }
    if (n == 0 || target < 0) {
      return false;
    }

    // including current element
    boolean ans1 = subsetSum(A, target - A[n - 1], n - 1);
    // excluding current element
    boolean ans2 = subsetSum(A, target, n - 1);

    return ans1 || ans2;
  }

  public static void main(String[] args) {

    int[] A = { 3, 34, 4, 12, 5 };
    boolean ans = subsetSum(A, 100, 5);
    System.out.println(ans);
  }
}