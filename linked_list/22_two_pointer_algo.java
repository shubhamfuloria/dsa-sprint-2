import java.util.Arrays;

class Program {

  public static int[] search(int[] A, int low, int high, int target) {

    while (low < high) {
      if (A[low] + A[high] == target) {
        int[] ans = { A[low], A[high] };
        return ans;
      } else if (A[low] + A[high] < target) {
        low++;
      } else {
        high--;
      }
    }
    int[] ans = {};
    return ans;
  }

  public static void main(String[] args) {
    int[] A = { -1, 0, 1, 2, -1, -4 };
    Arrays.sort(A);
    int[] ans = search(A, 0, A.length - 1, 0);

    for (int el : ans) {
      System.out.print(el + " ");
    }
    System.out.println();
  }
}