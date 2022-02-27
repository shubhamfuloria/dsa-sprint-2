import java.util.HashMap;
import java.util.HashSet;
import java.util.Arrays;
import java.util.Collection;
import java.util.ArrayList;
import java.util.Collections;

class Program {
  public static void main(String[] args) {

    int[] A = { -1, 0, 1, 2, -1, -4 };
    HashMap<Integer, Integer> map = new HashMap<>();
    HashSet<ArrayList> set = new HashSet<>();
    // calulating frequency of each element
    for (int el : A) {
      if (map.containsKey(el)) {
        map.put(el, map.get(el) + 1);
      } else {
        map.put(el, 1);
      }
    }

    for (int i = 0; i < A.length; i++) {
      map.put(A[i], map.get(A[i]) - 1);
      for (int j = i + 1; j < A.length; j++) {
        map.put(A[j], map.get(A[j]) - 1);

        // we have chosen first two elements for our triplet which are A[i] , A[j]
        // now if -(A[i] + A[j]) does exists in our array (ie freq of that is not 0)
        // then we got our triplet :)

        int target = -(A[i] + A[j]);
        if (map.containsKey(target) != false && map.get(target) > 0) {
          // we have our triplet
          ArrayList<Integer> temp = new ArrayList<>();
          temp.add(A[i]);
          temp.add(A[j]);
          temp.add(target);
          Collections.sort(temp);
          set.add(temp);
        }
        map.put(A[j], map.get(A[j]) + 1);
      }
      map.put(A[i], map.get(A[i]) + 1);
    }

    System.out.println(set);
  }
}