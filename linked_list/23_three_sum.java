import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Program {

  public static ArrayList<ArrayList<Integer>> getAllUniqueTriplet(int[] A, int low, int high, int target) {

    ArrayList<ArrayList<Integer>> f_list = new ArrayList<>();

    while (low < high) {
      if (A[low] + A[high] == target) {

        ArrayList<Integer> temp = new ArrayList<>(Arrays.asList(A[low], A[high], target));
        f_list.add(temp);

        while (low < high && A[low] == A[low + 1]) {
          low++;
        }
        while (low < high && A[high] == A[high - 1]) {
          high--;
        }

        low++;
        high--;

      } else if (A[low] + A[high] < target) {
        low++;
      } else {
        high--;
      }
    }
    return f_list;
  }

  public static void main(String[] args) {
    int[] A = { -1, 0, 1, 2, -1, -4 };
    Arrays.sort(A);
    ArrayList<ArrayList<Integer>> f_list = new ArrayList<>();
    for (int i = 0; i < A.length - 2; i++) {

      if (i == 0 || (A[i] != A[i - 1])) {
        int target = -A[i];
        ArrayList<ArrayList<Integer>> currAns = getAllUniqueTriplet(A, i + 1, A.length - 1, target);
        f_list.addAll(currAns);
      }
    }
    System.out.println(f_list);
  }
}
