import java.lang.ProcessBuilder.Redirect.Type;

class Program {
  public static void fun(Integer x) {
    x = 1000;
  }

  public static void main(String[] args) {
    Integer x = 5;
    fun(x);
    System.out.println(x);
  }
}