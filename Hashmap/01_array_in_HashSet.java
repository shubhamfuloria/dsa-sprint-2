
/*
Can we contain duplicate arrays in our hashSet ? 
let's check..
*/
import java.util.HashSet;
import java.util.ArrayList;

class Program {
  public static void main(String[] args) {
    HashSet<ArrayList> s = new HashSet<>();
    ArrayList<Integer> A = new ArrayList<>();
    A.add(10);
    A.add(20);
    A.add(30);
    A.add(40);

    ArrayList<Integer> B = new ArrayList<>();
    B.add(10);
    B.add(20);
    B.add(30);
    B.add(40);

    s.add(A);
    s.add(B);

    System.out.println(s);
  }
}

/*
 * YES we can do that :)
 */