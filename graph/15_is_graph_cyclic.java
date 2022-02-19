import java.util.ArrayList;
import java.lang.reflect.Array;
import java.util.ArrayDeque;

class Program {
  static class Edge {
    int src;
    int nbr;
    int wt;

    public Edge(int src, int nbr, int wt) {
      this.src = src;
      this.nbr = nbr;
      this.wt = wt;
    }
  }

  public static boolean bfs(ArrayList<Edge>[] graph, boolean[] visited, int src) {

    ArrayDeque<Integer> queue = new ArrayDeque<>();

    queue.add(src);

    while (!queue.isEmpty()) {
      // r m* w a*

      int rem = queue.removeFirst();

      if (visited[rem] == true) {
        return true;
      }
      visited[rem] = true;

      for (Edge edge : graph[rem]) {
        if (visited[edge.nbr] == false) {
          queue.add(edge.nbr);
        }
      }
    }
    return false;
  }

  public static boolean isCyclic(ArrayList<Edge>[] graph) {

    boolean[] visited = new boolean[graph.length];
    for (int v = 0; v < graph.length; v++) {
      if (visited[v] == false) {
        if (bfs(graph, visited, v) == true) {
          return true;
        }
      }
    }

    return false;
  }

  public static void main(String[] args) {
    int V = 7;

    ArrayList<Edge>[] graph = new ArrayList[V];

    for (int i = 0; i < V; i++) {
      graph[i] = new ArrayList<>();
    }

    graph[0].add(new Edge(0, 1, 10));
    graph[1].add(new Edge(1, 0, 10));

    graph[2].add(new Edge(2, 3, 10));
    graph[3].add(new Edge(3, 2, 10));

    graph[4].add(new Edge(4, 5, 10));
    graph[4].add(new Edge(4, 6, 10));

    graph[5].add(new Edge(5, 4, 10));
    // graph[5].add(new Edge(5, 6, 10));

    graph[6].add(new Edge(6, 4, 10));
    // graph[6].add(new Edge(6, 5, 10));

    boolean ans = isCyclic(graph);
    System.out.println(ans);
  }
}