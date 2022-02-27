class Program {

  public static int max(int a, int b) {
    return a > b ? a : b;
  }

  public static int getTrappedWater(int[] A) {
    // for each index we need to find how much water it can contain
    int water = 0;
    int n = A.length;
    for (int i = 0; i < n; i++) {
      int left_max = 0;
      int right_max = 0;

      for (int j = i - 1; j >= 0; j--) {
        if (A[j] > A[i] && A[j] > left_max) {
          left_max = A[i] == 0 ? A[j] : A[j] - A[i];
        }
      }

      for (int j = i + 1; j < n; j++) {
        if (A[j] > A[i] && A[j] > right_max) {
          right_max = A[i] == 0 ? A[j] : A[j] - A[i];
        }
      }

      water += left_max > right_max ? right_max : left_max;
    }

    return water;
  }

  public static void main(String[] args) {
    int[] A = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
    int ans = getTrappedWater(A);

    System.out.println(ans);
  }

}