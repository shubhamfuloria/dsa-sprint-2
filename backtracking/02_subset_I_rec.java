import java.util.*;

class Program {
  /*
   * The problem is same as 01, but now we need to solve it recursively
   * Although there exist a simple technique of pick and non-pick, which I've
   * solved in recursion directory
   * But here we are using a different technique , we will basically
   * develop a recurive template code which will help us solve similar problems
   * very easily.
   * 
   * 
   * this approach is aka dfs
   * 
   * 
   * 
   * 
   * 
   */

  public static void generateSubset(int[] nums, int index, List<Integer> curr, List<List<Integer>> res) {

    // initially curr is an empty arrayList
    res.add(new ArrayList<>(curr));

    for (int i = index; i < nums.length; i++) {
      curr.add(nums[i]); // [1]
      // generate all subset that starts from [1] recursively
      generateSubset(nums, i + 1, curr, res);
      // backtrack
      // so in the next iteration, we can generate all subset which starts from [2]
      // and in the third iteration, we can generate all subset which starts from [3]
      curr.remove(curr.size() - 1);
    }
  }

  public static void main(String[] args) {

    int[] A = { 1, 2, 3 };
    List<List<Integer>> res = new ArrayList<>();
    generateSubset(A, 0, new ArrayList<>(), res);

    for (List<Integer> list : res) {
      System.out.print(list + " ");
    }
    System.out.println();
  }
}