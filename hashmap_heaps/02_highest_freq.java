import java.util.HashMap;

class Program {

  public static void main(String[] args) {
    String S = "shubhamisagoodboy.";

    HashMap<Character, Integer> freq = new HashMap<>();

    for (int i = 0; i < S.length(); i++) {
      if (freq.containsKey(S.charAt(i))) {
        freq.put(S.charAt(i), freq.get(S.charAt(i)) + 1);
      } else {
        freq.put(S.charAt(i), 1);
      }
    }
    int max_freq = 0;
    char max_char = ' ';
    for (Character c : freq.keySet()) {
      if (freq.get(c) > max_freq) {
        max_freq = freq.get(c);
        max_char = c;
      }
    }
    System.out.println(max_freq + " " + max_char);
  }
}