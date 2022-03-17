import java.util.ArrayList;
import java.util.PriorityQueue;

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

  public static class Pair implements Comparable<Pair> {
    int v;
    String psf;
    int wsf;

    public Pair(int v, String psf, int wsf) {
      this.v = v;
      this.psf = psf;
      this.wsf = wsf;
    }

    public int compareTo(Pair o) {
      return this.wsf - o.wsf;
    }
  }

  public static void dijkstra(ArrayList<Edge>[] graph, int V, int src) {
    PriorityQueue<Pair> pq = new PriorityQueue<>();

    pq.add(new Pair(src, src + "", 0));
    boolean[] visited = new boolean[V];

    while (pq.isEmpty() == false) {

      Pair rem = pq.remove();

      if (visited[rem.v] == true) {
        continue;
      }

      visited[rem.v] = true;
      System.out.println(rem.v + ", " + rem.psf + ", " + rem.wsf);

      for (Edge edge : graph[rem.v]) {
        if (visited[edge.nbr] == false) {
          pq.add(new Pair(edge.nbr, rem.psf + edge.nbr, rem.wsf + edge.wt));
        }
      }
    }
  }

  public static void main(String[] args) {
    ArrayList<Edge>[] graph = new ArrayList[7];

    for (int i = 0; i < 7; i++) {
      graph[i] = new ArrayList<>();
    }

    graph[0].add(new Edge(0, 1, 10));
    graph[0].add(new Edge(0, 3, 40));

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

    graph[6].add(new Edge(6, 4, 8));
    graph[6].add(new Edge(6, 5, 3));

    dijkstra(graph, 7, 0);
  }
}