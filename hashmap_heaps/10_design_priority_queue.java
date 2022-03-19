import java.util.ArrayList;

/*
We need to design a priority queue, 
  peek() should always return minimum value
  remove() should always remove and return minimum value
  add() should add a new value to the queue
  size() should return the size of queue

Although we can implement this simple functionality using an array, but
  peek() -> search the whole array and return the minimum value O(n) time 
  remove() -> search the whole array and remove get the minimum value , remove it then shift each element O(n) time
  add() -> add element to the last of array O(1) time
  size() -> return the size of array
  
  
But the actual priority queue performs these operations in O(logn) time
We can achieve this using heap data structure.


Now what is heap?
Heap is nothing but a spcial implementation of tree data structure, which is always complete binary tree.
complete binary tree: A binary tree which has all levels filled except the last level, which will be filled from 
                      left to right.
Two types of heap are there :
-> min heap 
-> max heap

min heap : root node's value should be lesser than it's both children, and it is recursively true for each node.
max heap : root node's value should be greater than it's both children, and it is recursively true for each node.

Here we are implementing min-priority queue, so we will use min heap.

Before proceeding further we need to get to know about heap's add, remove operations

Add Operation: 

add(10):
      10   

add(20): 
      10
    20

add(30):
      10
    20  30

add(5):
      10
    20  30 (here our heap rule get's voilated)
  5

To make it again a heap we perform an operation called heapify (up-heapify to be speicific)
-> compare 5 with it's parent, if it's smaller swap
-> perform it recursively

      10
    20  30
  5

  if 5 smaller than it's parent ? Yes it's smaller (swap)

      10
     5  30
   20

   Again it is not a min-heap, perform heapify again

      5
    10 30
  20

  Not it's again min-heap: So it took O(logn) time to add a new node


    */

class PriorityQueue {

  ArrayList<Integer> data;

  public PriorityQueue() {
    data = new ArrayList<>();
  }

  private void swap(int i, int j) {
    int ith = data.get(i);
    int jth = data.get(j);

    data.set(i, jth);
    data.set(j, ith);
  }

  private void upHeapify(int i) {
    if (i == 0) {
      return;
    }
    int pi = (i - 1) / 2;
    if (data.get(i) < data.get(pi)) {
      swap(i, pi);
      upHeapify(pi);
    }
  }

  public void add(int val) {
    data.add(val);
    upHeapify(data.size() - 1);
  }

  public int remove() {
    swap(data.size() - 1, 0);
    int val = data.remove(data.size() - 1);
    downHeapify(0);
    return val;
  }

  private void downHeapify(int i) {
    int mini = i;
    int li = 2 * i + 1;

    if (li < size() && data.get(li) < data.get(mini)) {
      mini = li;
    }
    int ri = 2 * i + 2;

    if (ri < size() && data.get(ri) < data.get(mini)) {
      mini = ri;
    }

    if (mini != i) {
      swap(i, mini);
      downHeapify(mini);
    }

  }

  public int peek() {
    if (data.size() == 0) {
      System.out.println("Underflow");
      return -1;
    }
    return data.get(0);
  }

  public int size() {
    return data.size();
  }
}

class Program {
  public static void main(String[] args) {
    PriorityQueue pq = new PriorityQueue();

    pq.add(10);
    pq.add(20);
    pq.add(5);

    System.out.println(pq.peek());
  }
}