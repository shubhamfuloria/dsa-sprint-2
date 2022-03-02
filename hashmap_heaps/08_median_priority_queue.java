import java.util.Collections;
import java.util.PriorityQueue;

/*
Design a Queue Priotiry, such that..
 -> add() : adds(x) adds new element x in our queue
 -> peek(): returns median of queue
 -> remove(): removes element present at median of the queue

NOTE: if size is even then there will be two medians, consider smaller median in that case

eg.
[] (queue is empty)

add(10): [10], peek() : 10
add(20): [10, 20], peek() : 10
add(5): [5, 10, 20], peek(): 10
add(4): [4, 5, 10, 20], peek(): 5
add(15): [4, 5, 10, 15, 20], peek(): 10

remove(): [4, 5, 15, 20] (10 got removed)


Design:
-> We'll take two priority queues.
-> The first one will be max-priority-queue (peek will be largest element)
-> The second one will be min-priority-queue (peeek will be smallest element)
-> We'll keep balancing no of elements in both pqueues in add operation

left(min-priotiry-queue) [], right(max-priority-queue) []

add(10): [10] []
add(20): [10, 20] [] ---balancing no of elements---> [10] [20], peek(): 10 (peek of left pqueue)
add(30): [10] [20, 30] we added 30 in right priority queue cuz, peek() of right was smaller than 30, peek(): 20 (peek of right pqueue)
add(40): [10] [20, 30, 40] ---balancing no of elements---> [10, 20] [30, 40] , peek(): 20 (peek of left pqueue)
*/

class MedianPriorityQueue {
  private PriorityQueue<Integer> left;
  private PriorityQueue<Integer> right;

  public MedianPriorityQueue() {
    this.left = new PriorityQueue<>(Collections.reverseOrder());
    this.right = new PriorityQueue<>();
  }

  public void add(int element) {
    if (right.size() > 0 && element > right.peek()) {
      right.add(element);
    } else {
      left.add(element);
    }

    // balance
    if (left.size() - right.size() == 2) {
      right.add(left.remove());
    } else if (right.size() - left.size() == 2) {
      left.add(right.remove());
    }
  }

  public int remove() {
    if (this.size() == 0) {
      System.out.println("Underflow");
      return -1;
    }
    if (left.size() >= right.size()) {
      return left.remove();
    } else {
      return right.remove();
    }
  }

  public int peek() {
    if (this.size() == 0) {
      System.out.println("Underflow");
      return -1;
    } else if (left.size() >= right.size()) {
      return left.peek();
    } else {
      return right.peek();
    }
  }

  public void display() {
    System.out.print(this.left);
    System.out.println(this.right);
  }

  public int size() {
    return left.size() + right.size();
  }
}

class Program {
  public static void main(String[] args) {
    MedianPriorityQueue q = new MedianPriorityQueue();
    q.add(5);
    q.add(10);
    q.add(20);
    q.add(2);
    q.add(1);

    System.out.println(q.remove());
    System.out.println(q.peek());
  }
}