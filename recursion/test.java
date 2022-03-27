import java.util.*;

class Solution {
  private static List<List<Integer>> f_list;

  private void helper(int[] nums, int i, ArrayList<Integer> list) {
    if (i == nums.length) {
      f_list.add(new ArrayList<>(list));
      return;
    }

    // excluding ith element
    helper(nums, i + 1, list);

    // including ith element
    while (i + 1 < nums.length && nums[i] != nums[i + 1]) {
      i++;
    }
    list.add(nums[i]);
    helper(nums, i + 1, list);
    // backtrack
    list.remove(list.size() - 1);
  }

  public List<List<Integer>> subsetsWithDup(int[] nums) {
    f_list = new ArrayList<>();
    ArrayList<Integer> ans = new ArrayList<>();
    Arrays.sort(nums);
    helper(nums, 0, ans);
    return f_list;
  }
}

class Program {
  public static void main(String[] args) {
    int[] A = { 1, 2, 2 };

    Solution s = new Solution();

    List<List<Integer>> ans = s.subsetsWithDup(A);

    for (List<Integer> list : ans) {
      System.out.println(list);
    }
  }

}