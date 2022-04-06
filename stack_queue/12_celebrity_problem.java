import java.util.Stack;

class Program {

  /*
   * x will be celibrity if x is known by everyone, and x does not know anyone.
   *
   * M[i][j] == 0 ? i does not know j : i do know j
   * 
   * This problem can be easily solved in O(n^2)
   * But using elimination technique we can solve it in O(n)
   * 
   * The approach is very simple:
   * things to keep in mind
   * 
   * 1. There can only be 1 celebrity in the party, why ? think about it..
   * 2. By picking two member we can easily tell if he is not a celibrity or can
   * be one. How ? let's see....
   * i. Let's say we pick two person 2 and 3
   * ii.We'lll check if 2 knows 3 (value of M[2][3])
   * -> if he does, then we can say 2 is not a celibrity
   * -> if he does not, then we can say 3 is not a celibrity :D
   * VERY VERY INTERESTING APPROACH
   * And by this way in O(2n), we can eliminate n - 1 people
   * Then we can check for the remaining member easily
   */

  public static boolean isCelibrity(int[][] M, int n, int p) {

    for (int i = 0; i < n; i++) {
      if (M[p][i] == 1) {
        // p (candidate celibrity) does know i, so he can not be celibrity)
        return false;
      } else if (M[i][p] == 0 && i != p) {
        // i does not know p(candidate celibrity), that means , he can not be celibrity
        return false;
      }
    }
    return true;
  }

  public static int solve(int[][] M, int n) {
    Stack<Integer> stk = new Stack<>();

    // push each element into the stack
    for (int i = 0; i < n; i++) {
      stk.push(i);
    }

    // in each iteration pick two members and eliminate one
    while (stk.size() > 1) {
      int p1 = stk.pop();
      int p2 = stk.pop();

      if (M[p1][p2] == 0) {
        // p1 does not know p2, p2 can not be celebrity
        stk.push(p1);
      } else if (M[p1][p2] == 1) {
        // p1 does know p2, so p1 can not be celebrity
        stk.push(p2);
      }
    }

    // now there is only one person left
    // we just need to check if he's celebrity or not
    int p = stk.pop();
    if (isCelibrity(M, n, p) == true) {
      return p;
    } else {
      return -1;
    }
  }

  public static void main(String[] args) {
    int[][] M = { { 0, 1, 1, 1, 1 },
        { 1, 0, 0, 1, 0 },
        { 1, 0, 0, 1, 0 },
        { 0, 0, 0, 0, 0 },
        { 0, 1, 0, 1, 0 } };

    int ans = solve(M, M.length);
    System.out.println(ans);
  }
}