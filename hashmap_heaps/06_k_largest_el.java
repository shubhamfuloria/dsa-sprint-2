import java.util.PriorityQueue;

class Program {
  public static void main(String[] args) {
    int[] A = { 4, 3, 5, 2, 6, 7, 1, 2, 7 };
    int k = 4;
    PriorityQueue<Integer> pqueue = new PriorityQueue<>();

    for (int el : A) {
      if (pqueue.size() < k) {
        pqueue.add(el);
      } else {
        if (el > pqueue.peek()) {
          pqueue.remove();
          pqueue.add(el);
        }
      }
    }

    while (!pqueue.isEmpty()) {
      System.out.print(pqueue.remove() + " ");
    }

    System.out.println();
  }
}