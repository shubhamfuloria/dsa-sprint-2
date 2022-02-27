class Program {
  // in the previous solution the time complexity was n*n , we were traversing
  // whole array for each index
  // we can optimise this using dynamic programming, we can maintain an array for
  // left_max and right_max;

  public static int getTrappedWater(int[] A) {
    // for each index we need to find how much water it can contain
    int water = 0;
    int n = A.length;

    int[] prefix = new int[n];
    int[] suffix = new int[n];

    prefix[0] = A[0];
    for (int i = 1; i < n; i++) {
      prefix[i] = Math.max(A[i], prefix[i - 1]);
    }

    suffix[n - 1] = A[n - 1];
    for (int i = n - 2; i >= 0; i--) {
      suffix[i] = Math.max(A[i], suffix[i + 1]);
    }

    for (int i = 0; i < n; i++) {
      int left_max = 0;
      int right_max = 0;

      left_max = prefix[i] - A[i] < 0 ? 0 : prefix[i] - A[i];
      right_max = suffix[i] - A[i];
      water += Math.min(left_max, right_max);
    }

    return water;
  }

  public static void main(String[] args) {
    int[] A = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
    int ans = getTrappedWater(A);

    System.out.println(ans);
  }
}