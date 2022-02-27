import java.util.HashSet;

class Program {
  public static void main(String[] args) {
    int[] A = { 1, 2, 2, 1, 2, 3, 4, 5 };
    int[] B = { 2, 4, 2, 2, 3, 8, 9, 9 };

    HashSet<Integer> set = new HashSet<>();

    for (int el : A) {
      set.add(el);
    }

    for (int el : B) {
      if (set.contains(el)) {
        System.out.println(el);
        set.remove(el);
      }
    }

  }

}