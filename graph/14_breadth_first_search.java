
import java.util.ArrayList;
import java.util.ArrayDeque;

class Program {
  static class Edge {
    int src, nbr, wt;

    public Edge(int src, int nbr, int wt) {
      this.src = src;
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

  public static void bfs(ArrayList<Edge>[] graph, int src) {
    ArrayDeque<Pair> queue = new ArrayDeque<>();

    queue.add(new Pair(src, src + ""));
    boolean[] visited = new boolean[graph.length];
    while (!queue.isEmpty()) {
      // r m* w a*

      Pair rem = queue.removeFirst();

      if(visited[rem.v] == true) {
        continue;
      }

      visited[rem.v] = true;
      System.out.println(rem.v + "@" + rem.psf);
      for(Edge edge : graph[rem.v]) {
        if(visited[edge.nbr] == false) {
          queue.add(new Pair(edge.nbr, rem.psf + edge.nbr));
        }
      } 
    }
  }

  public static void main(String[] args) {

    int V = 7;
    ArrayList<Edge>[] graph = new ArrayList[V];

    for (int i = 0; i < V; i++) {
      graph[i] = new ArrayList<Edge>();
    }

    graph[0].add(new Edge(0, 1, 10));
    graph[0].add(new Edge(0, 3, 10));

    graph[1].add(new Edge(1, 0, 10));
    graph[1].add(new Edge(1, 2, 10));

    graph[2].add(new Edge(2, 1, 10));
    graph[2].add(new Edge(2, 3, 10));

    graph[3].add(new Edge(3, 0, 10));
    graph[3].add(new Edge(3, 2, 10));
    graph[3].add(new Edge(3, 4, 10));

    graph[4].add(new Edge(4, 3, 10));
    graph[4].add(new Edge(4, 5, 10));
    graph[4].add(new Edge(4, 6, 10));

    graph[5].add(new Edge(5, 4, 10));
    graph[5].add(new Edge(5, 6, 10));

    bfs(graph, 0);
  }
}