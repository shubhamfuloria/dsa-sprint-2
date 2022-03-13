import java.util.ArrayList;

class Program {

  /*
   * APPROACH:
   * Whenever there is a problem of returning anything from a recursive function
   * -> use faith and expectation technique
   * 
   * In this problem we want all subsequences of a string .
   * "abc" -> "", "c", "b", "bc", "a", "ac", "ab", "abc"
   * 
   * High lvl thinking:
   * We want an arrayList with all subsequences.
   * 
   * So we will use faith & expectation technique
   * 
   * We'll keep faith in our recursive function that it already knows how to run
   * for smaller input "bc"
   * getSubsequence("bc") should return an array list will all possible
   * subsequences
   * -> ["", "c", "b", "bc"]
   * 
   * Reaching to expectation
   * 
   * As we can see the returned array is our half answer.
   * if we add 'a' in front of all elements we will get other half .
   * And here our problem is solved.
   */

  public static ArrayList<String> getSubsequence(String S) {

    if (S.length() == 0) {
      ArrayList<String> t = new ArrayList<>();
      t.add("");
      return t;
    }

    char ch = S.charAt(0);
    String ros = S.substring(1);

    ArrayList<String> s_ans = getSubsequence(ros);
    ArrayList<String> f_ans = new ArrayList<>();

    for (String s : s_ans) {
      f_ans.add(s);
    }
    for (String s : s_ans) {
      f_ans.add(ch + s);
    }
    return f_ans;

  }

  public static void main(String[] args) {
    String s = "abc";
    ArrayList<String> list = getSubsequence(s);

    for (String str : list) {
      System.out.println(str);
    }
  }
}