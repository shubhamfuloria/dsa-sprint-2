import java.util.*;

class Solution {
  private static HashSet<ArrayList<Integer>> set;

  private void helper(int[] A, int i, int target, ArrayList<Integer> list) {
    if (i == A.length || target == 0) {
      if (target == 0) {
        set.add(new ArrayList<Integer>(list));
      }
      return;
    }

    // excludig ith element
    helper(A, i + 1, target, list);

    // including ith element
    if (A[i] <= target) {
      list.add(A[i]);
      helper(A, i + 1, target - A[i], list);
      list.remove(list.size() - 1);
    }
  }

  public List<List<Integer>> combinationSum2(int[] candidates, int target) {

    ArrayList<Integer> list = new ArrayList<>();
    set = new HashSet<>();
    Arrays.sort(candidates);
    helper(candidates, 0, target, list);
    List<List<Integer>> ans = new ArrayList<>();

    for (ArrayList<Integer> l : set) {
      ans.add(l);
    }

    return ans;
  }
}

class Program {
  public static void main(String[] args) {
    Solution s = new Solution();
    int[] candidates = { 2, 5, 2, 1, 2 };
    int target = 5;
    List<List<Integer>> ans = s.combinationSum2(candidates, target);

    for (List<Integer> list : ans) {
      System.out.println(list);
    }
  }
}