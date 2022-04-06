class Stack {
  private int[] data;
  private int tos;// top of stack

  public Stack(int capacity) {
    this.data = new int[capacity];
    this.tos = -1;// pointing to negative index
  }

  public void push(int value) {
    if (tos == data.length - 1) {
      System.out.println("Stack Overflow");
    } else {
      data[++tos] = value;
    }
  }

  public int pop() {
    if (tos == -1) {
      System.out.println("Stack Underflow");
      return -1;
    } else {
      return data[tos--];
    }
  }

  public int peek() {
    return data[tos];
  }

  public int size() {
    return tos + 1;
  }

  public void display() {
    for (int i = 0; i <= tos; i++) {
      System.out.print(data[i] + " ");
    }
    System.out.println();
  }
}

class Program {
  public static void main(String[] args) {
    Stack stk = new Stack(5);

    stk.push(10);
    stk.push(20);
    stk.push(30);
    stk.push(40);
    stk.push(50);

    stk.display();

    stk.pop();
    stk.display();

    System.out.println(stk.size());

    System.out.println(stk.peek());
  }
}