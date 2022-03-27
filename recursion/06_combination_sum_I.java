import java.util.*;

class Solution {

  private HashSet<ArrayList<Integer>> set;

  private void helper(int[] A, int target, int i, ArrayList<Integer> list) {
    if (i == A.length || target < 0 || target == 0) {
      if (target == 0) {
        set.add(new ArrayList<>(list));
      }
      return;
    }

    // excluding current element
    helper(A, target, i + 1, list);

    // including current element
    if (A[i] <= target) {
      list.add(A[i]);
      helper(A, target - A[i], i, list);
      list.remove(list.size() - 1);
    }

  }

  public List<List<Integer>> combinationSum(int[] candidates, int target) {
    set = new HashSet<ArrayList<Integer>>();
    ArrayList<Integer> list = new ArrayList<>();
    helper(candidates, 8, 0, list);

    List<List<Integer>> ans = new ArrayList<>();

    for (List<Integer> l : set) {
      ans.add(l);
    }

    return ans;
  }
}

class Program {
  public static void main(String[] args) {
    Solution s = new Solution();
    int[] candidates = { 2, 3, 5 };
    int target = 8;
    List<List<Integer>> ans = s.combinationSum(candidates, target);

    for (List<Integer> list : ans) {
      System.out.println(list);
    }
  }
}