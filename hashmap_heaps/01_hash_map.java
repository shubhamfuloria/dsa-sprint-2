import java.util.HashMap;

class Program {
  public static void main(String[] args) {
    HashMap<String, Integer> map = new HashMap<>();

    map.put("India", 132);
    map.put("Pakistan", 100);
    map.put("America", 56);
    map.put("Rajsthan", 10);

    System.out.println(map);

    map.put("India", 123);
    map.put("US", 45);

    System.out.println(map);

    System.out.println(map.get("India"));
    System.out.println(map.get("Rajsthana"));

  }
}