import java.util.ArrayList;
import java.util.ArrayDeque;

class Program {
  static class Edge {
    int src;
    int nbr;

    public Edge(int src, int nbr) {
      this.src = src;
      this.nbr = nbr;
    }
  }

  static class Pair {
    int v;
    int time;

    public Pair(int v, int time) {
      this.v = v;
      this.time = time;
    }
  }

  public static int noOfInfectedPeople(ArrayList<Edge>[] graph, int t, int infectedPerson) {

    int count = 0;

    ArrayDeque<Pair> queue = new ArrayDeque<>();
    boolean[] visited = new boolean[7];
    queue.add(new Pair(infectedPerson, 0));

    while (!queue.isEmpty()) {

      Pair rem = queue.removeFirst();

      if (visited[rem.v] == true) {
        continue;
      }
      visited[rem.v] = true;
      if (rem.time > t) {
        break;
      }
      count++;

      for (Edge edge : graph[rem.v]) {
        if (visited[edge.nbr] == false) {
          queue.add(new Pair(edge.nbr, rem.time + 1));
        }
      }

    }

    return count;
  }

  public static void main(String[] args) {

    ArrayList<Edge>[] graph = new ArrayList[7];

    for (int i = 0; i < 7; i++) {
      graph[i] = new ArrayList<>();
    }

    graph[0].add(new Edge(0, 1));
    graph[0].add(new Edge(0, 3));

    graph[1].add(new Edge(1, 0));
    graph[1].add(new Edge(1, 2));

    graph[2].add(new Edge(2, 1));
    graph[2].add(new Edge(2, 3));

    graph[3].add(new Edge(3, 0));
    graph[3].add(new Edge(3, 2));
    graph[3].add(new Edge(3, 4));

    graph[4].add(new Edge(4, 3));
    graph[4].add(new Edge(4, 5));
    graph[4].add(new Edge(4, 6));

    graph[5].add(new Edge(5, 4));
    graph[5].add(new Edge(5, 6));

    graph[6].add(new Edge(6, 4));
    graph[6].add(new Edge(6, 5));

    int n = noOfInfectedPeople(graph, 2, 6);
    System.out.println(n);
  }
}