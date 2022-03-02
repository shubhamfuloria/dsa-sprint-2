import java.util.Collection;
import java.util.Collections;
import java.util.PriorityQueue;

class Program {

  public static int getKthLargestEl(int[] A, int k) {
    PriorityQueue<Integer> pqueue = new PriorityQueue<>(Collections.reverseOrder());
    for (int el : A) {
      pqueue.add(el);
    }

    for (int i = 0; i < k - 1; i++) {
      pqueue.remove();
    }
    return pqueue.peek();
  }

  public static void main(String[] args) {
    int[] A = { 3, 2, 1, 5, 6, 4 };
    int ans = getKthLargestEl(A, 2);
    System.out.println(ans);
  }
}