import java.util.PriorityQueue;

class Program {
  /*
   * Q. the array was sorted but then each element may be shifted upto k steps to
   * the left or right
   * 
   * Approach: Although we can solve this problem by adding all array element in
   * the priority
   * queue, then by removing all the element we will get the element in sorted
   * form.
   * But it will cost Time: O(nlogn)
   * And space complexity: O(n)
   * 
   * But as our array is nearly sorted by k steps, so we can use this fact and
   * reduce
   * our space complexity, we can make a priority queue of size k, then keep
   * adding elements
   * in it:
   * if(size exceeds k)
   * remove() -> It will remove the smallest element in those k elements
   * add() ->
   * By this Our queue will not exceed k size, and we will get our sorted array
   */
  public static void main(String[] args) {
    int[] A = { 2, 3, 1, 4, 6, 7, 5, 8, 9 };
    int k = 2;
    PriorityQueue<Integer> pqueue = new PriorityQueue<>();

    // insert first k elements in the priority queue

    for (int i = 0; i <= k; i++) {
      pqueue.add(A[i]);
    }

    // now our priority queue's size is k
    // so for adding further elements we need to remove one element at a time

    for (int i = k + 1; i < A.length; i++) {
      System.out.print(pqueue.remove() + " ");
      pqueue.add(A[i]);
    }

    // remove rest k elements from the queue

    while (!pqueue.isEmpty()) {
      System.out.print(pqueue.remove() + " ");
    }
    System.out.println();
  }
}