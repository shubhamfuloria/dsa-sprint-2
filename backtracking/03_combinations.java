import java.util.*;

class Program {
  /*
   * Problem: two integers are given n and k, return all possible combination of k
   * size in range [1, n]
   * 
   * in: 3, 2
   * op: [[1, 2] , [1, 3] , [2, 3]]
   * expl: n = 3, so range will be [1, 2, 3]
   * 
   * Aproach:
   * If we look closely , this problem is very similar to last one,
   * -> if we somehow be able to get all possible subsets of [1, 2, 3]
   * -> can we get our answer then ?
   * { [], [1], [1, 2], [1, 2, 3], [1, 3], [2], [2, 3], [3] }
   * 
   * Can you filter out only those sets which have size k (2)
   * { [1, 2], [1, 3], [2, 3] }
   * OMG, this is our answer :D
   * 
   * 
   * So we are going to follow same approach we used in last question,
   * but the problem here is we are not given an array, so how should we proceed ?
   * We can solve this problem using two ways:
   * 1. by generating an array of size n [1, 2, 3]
   * 2. by continuing without array
   * 
   * let's solve it with second method
   */

  public static void generateCombination(int start, int n, int k, List<Integer> curr, List<List<Integer>> res) {

    // put first element aka start to the result
    // include only those lists which are of size k
    if (curr.size() == k) {
      res.add(new ArrayList<>(curr));
    }
    for (int i = start; i <= n; i++) {
      curr.add(i);
      generateCombination(i + 1, n, k, curr, res);
      curr.remove(curr.size() - 1);
    }
  }

  public static void main(String[] args) {
    int n = 3;
    int k = 2;

    List<List<Integer>> res = new ArrayList<>();
    generateCombination(1, n, k, new ArrayList<>(), res);

    for (List<Integer> list : res) {
      System.out.print(list + " ");
    }
    System.out.println();
  }
}