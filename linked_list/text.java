class Program {
  public static void changeX(int x) {
    x = 1000;
  }

  public static void main(String[] args) {
    int y = 10;
    Integer x = Integer.valueOf(5);
    changeX(x);
    System.out.println(x);
  }
}