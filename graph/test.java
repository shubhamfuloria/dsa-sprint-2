import java.util.ArrayList;
import java.util.ArrayDeque;

class Program {
  static class Edge {
    int v;
    int nbr;
    int wt;

    public Edge(int v, int nbr, int wt) {
      this.v = v;
      this.nbr = nbr;
      this.wt = wt;
    }
  }

  static class Pair {
    int v;
    String psf;

    public Pair(int v, String psf) {
      this.v = v;
      this.psf = psf;
    }
  }

  public static void dfs(ArrayList<Edge>[] graph, int src, int dest, String psf, boolean[] visited) {

    if (src == dest) {
      System.out.println(psf + dest);
      return;
    }

    visited[src] = true;

    for (Edge edge : graph[src]) {
      if (visited[edge.nbr] == false) {
        dfs(graph, edge.nbr, dest, psf + edge.v, visited);
      }
    }

    visited[src] = false;
  }

  public static void bfs(ArrayList<Edge>[] graph, int src) {

    boolean[] visited = new boolean[7];
    ArrayDeque<Pair> q = new ArrayDeque<>();

    q.add(new Pair(src, src + ""));

    while (q.isEmpty() == false) {
      // r m* w a*

      Pair rem = q.removeFirst();

      if (visited[rem.v] == true) {
        continue;
      }

      visited[rem.v] = true;

      System.out.println(rem.v + " " + rem.psf);

      for (Edge edge : graph[rem.v]) {
        if (visited[edge.nbr] == false) {
          q.add(new Pair(edge.nbr, rem.psf + edge.nbr));
        }
      }
    }

  }

  public static void main(String[] args) {

    ArrayList<Edge>[] graph = new ArrayList[7];

    // initializing all indices of array with an arraylist
    for (int i = 0; i < 7; i++) {
      graph[i] = new ArrayList<>();
    }

    graph[0].add(new Edge(0, 1, 40));
    graph[0].add(new Edge(0, 3, 10));

    graph[1].add(new Edge(1, 0, 10));
    graph[1].add(new Edge(1, 2, 10));

    graph[2].add(new Edge(2, 1, 10));
    graph[2].add(new Edge(2, 3, 10));

    graph[3].add(new Edge(3, 0, 40));
    graph[3].add(new Edge(3, 2, 10));
    graph[3].add(new Edge(3, 4, 2));

    graph[4].add(new Edge(4, 3, 2));
    graph[4].add(new Edge(4, 5, 3));
    graph[4].add(new Edge(4, 6, 8));

    graph[5].add(new Edge(5, 4, 3));
    graph[5].add(new Edge(5, 6, 3));

    graph[6].add(new Edge(6, 5, 3));
    graph[6].add(new Edge(6, 4, 8));

    boolean[] visited = new boolean[7];
    // dfs(graph, 0, 6, "", visited);
    bfs(graph, 0);
  }
}