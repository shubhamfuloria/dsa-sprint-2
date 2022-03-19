import java.util.ArrayList;

class Program {

  static ArrayList<ArrayList<Integer>> f_list = new ArrayList<>();

  public static void getSubsets(int[] A, int index, ArrayList<Integer> ans) {

    if (index == A.length) {
      ArrayList<Integer> copy = new ArrayList<>();
      // performing deep copy
      for (int el : ans) {
        copy.add(el);
      }
      f_list.add(copy);
      return;
    }

    // excluding current element
    getSubsets(A, index + 1, ans);
    // including current element
    ans.add(A[index]);
    getSubsets(A, index + 1, ans);
    ans.remove(ans.size() - 1);
  }

  public static void main(String[] args) {
    int[] A = { 10, 20, 30 };
    ArrayList<Integer> list = new ArrayList<>();
    getSubsets(A, 0, list);
    for (ArrayList<Integer> el : f_list) {
      System.out.println(el);
    }
  }
}