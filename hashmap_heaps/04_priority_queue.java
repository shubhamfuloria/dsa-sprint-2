import java.util.Collections;
import java.util.PriorityQueue;

class Program {
  public static void main(String[] args) {

    PriorityQueue<Integer> pqueue = new PriorityQueue<>(Collections.reverseOrder());
    int[] ranks = { 20, 12, 1, 4, 2, 6, 7, 10, 5 };

    for (int rank : ranks) {
      pqueue.add(rank);
    }

    while (!pqueue.isEmpty()) {
      System.out.print(pqueue.peek() + " ");
      pqueue.remove();
    }

  }
}