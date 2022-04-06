import java.util.*;

class Program {
  /*
   * [1, 2, 3] , array is containing unique elements.
   * we need to generate all possible subsets
   * 
   * { [], [1], [1, 2], [1, 3], [2], [2, 3], [3], [1, 2, 3] }
   * so there are total 8 subsets, from this we can conclude there exists total
   * 2^n subsets for a given array of size n
   * 
   * 
   * Think about, how we can generate these subset iteratively ?
   * Let's see ...
   * 
   * -> Assume the given array is [1]
   * + how many possible subsets are there for this array ?
   * + Simple...{ [], [1] } (2 subset)
   * + first one is excluding 1 and second one is including 1
   * 
   * -> Now let's change the array to [1, 2]
   * + how many possible subsets will be there for this array?
   * + Simple... 2^2 = 4 subsets which are { [], [1], [2], [1, 2]] }
   * + Now if we look closely, we've already calculated 2 subsets in previous
   * array i.e. [1] { [], [1] }
   * + We just need to be conscious here that we are already having subsets which
   * do not include 2, so we just need to add those subsets which does include 2
   * + we can simply pull out all those element which we've calculated then add 2
   * to them
   * + By doing so .. we should have 3 subsets
   * 
   * -> Now let's change the array to [1, 2, 3]
   * 
   * + possible subsets = 2^3
   * + we already have 4 subsets for [1, 2] array which are
   * + { [], [1], [2], [1, 2] }
   * + so we can simply say, we already have subset which do not include 3
   * + Now we can just add 3 to these subsets and we should have 8 subset
   * + { [], [1], [2], [1, 2], [3], [1, 3], [2, 3], [1, 2, 3]}
   */

  public static List<List<Integer>> generateSubset(int[] nums) {

    List<List<Integer>> res = new ArrayList<>();
    // cause every array has one empty subset
    res.add(new ArrayList<>());// adding empty subset to the list
    // res [[]]
    for (int num : nums) {
      int n = res.size();
      // pick all elements from res and add num to them then again add them to res
      for (int i = 0; i < n; i++) {
        // create a new array list copying ith list from res
        List<Integer> temp = new ArrayList<>(res.get(i));// []
        temp.add(num);
        res.add(temp);
      }
    }
    return res;
  }

  public static void main(String[] args) {
    int[] A = { 1, 2, 3 };
    List<List<Integer>> res = generateSubset(A);

    for (List<Integer> list : res) {
      System.out.print(list + " ");
    }
    System.out.println();
  }
}