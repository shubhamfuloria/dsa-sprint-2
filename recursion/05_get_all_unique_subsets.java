import java.util.*;

class Solution {

  private static HashSet<ArrayList<Integer>> f_list;

  private void helper(int[] nums, int i, ArrayList<Integer> list) {
    if (i == nums.length) {

      // deep copy
      f_list.add(new ArrayList<>(list));
      return;
    }

    // excluding ith element
    helper(nums, i + 1, list);

    // including ith element
    list.add(nums[i]);
    helper(nums, i + 1, list);
    // backtrack
    list.remove(list.size() - 1);
  }

  public List<List<Integer>> subsetsWithDup(int[] nums) {
    f_list = new HashSet<>();
    ArrayList<Integer> ans = new ArrayList<>();
    helper(nums, 0, ans);
    List<List<Integer>> r = new ArrayList<>();

    for (ArrayList<Integer> list : f_list) {
      r.add(list);
    }

    return r;
  }
}

class Program {
  public static void main(String[] args) {
    Solution s = new Solution();
    int[] A = { 4, 4, 4, 1, 4 };
    Arrays.sort(A);
    List<List<Integer>> ans = s.subsetsWithDup(A);

    for (List<Integer> list : ans) {
      System.out.println(list);
    }
  }
}