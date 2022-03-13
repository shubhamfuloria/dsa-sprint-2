import java.util.ArrayList;

class Program {

  public static ArrayList<ArrayList<Integer>> getAllSubsets(int[] A, int n, ArrayList<Integer> list) {

    //including n - 1 th element
    getAllSubsets(A, n, list)
  }

  public static void main(String[] args) {
    int[] A = { 3, 1, 4 };
    ArrayList<Integer> curr = new ArrayList<>();
    getAllSubsets(A, A.length, curr, list)

  }
}