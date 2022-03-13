class Program {
  // program to print all subset sum of an array

  public static void subsetSum(int[] A, int n, int sum) {

    if (n == 0) {
      System.out.println(sum);
      return;
    }

    // including n - 1th element
    subsetSum(A, n - 1, sum + A[n - 1]);

    // excluding n - 1th element
    subsetSum(A, n - 1, sum);
  }

  public static void main(String[] args) {
    int[] A = { 3, 1, 4 };
    subsetSum(A, A.length, 0);
  }
}