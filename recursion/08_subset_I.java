import java.util.*;

class Program {

  public static void getSubset(int[] A, int index, List<Integer> curr, List<List<Integer>> res) {

    res.add(new ArrayList<>(curr)); // adding empty list to the res

    for (int i = index; i < A.length; i++) {
      curr.add(A[i]); // [1]
      getSubset(A, i + 1, curr, res); // explore all subset which starts from 1
      curr.remove(curr.size() - 1); // backtrack
    }
  }

  public static void main(String[] args) {

    int[] A = { 1, 2, 3 };
    List<List<Integer>> res = new ArrayList<>();

    getSubset(A, 0, new ArrayList<Integer>(), res);

    for (List<Integer> list : res) {
      System.out.print(list + " ");
    }
    System.out.println();
  }
}