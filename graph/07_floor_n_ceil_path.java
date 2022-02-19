import java.util.ArrayList;

class Edge {
  int src, nbr, wt;

  public Edge(int src, int nbr, int wt) {
    this.src = src;
    this.nbr = nbr;
    this.wt = wt;
  }
}

class Program {

  static String cPath;
  static Integer cPathWt = Integer.MAX_VALUE;
  static String fPath;
  static Integer fPathWt = Integer.MIN_VALUE;

  static void get_floor_n_ceil(ArrayList<Edge>[] graph, int src, int dest, boolean[] visited, String psf, int wsf,
      int criteria) {
    if (src == dest) {
      if (wsf > criteria && wsf < cPathWt) {
        cPathWt = wsf;
        cPath = psf;
      }
      if (wsf < criteria && wsf > fPathWt) {
        fPathWt = wsf;
        fPath = psf;
      }
    }

    visited[src] = true;

    for (Edge edge : graph[src]) {
      if (visited[edge.nbr] == false) {
        get_floor_n_ceil(graph, edge.nbr, dest, visited, psf + edge.nbr, wsf + edge.wt, criteria);
      }
    }
    visited[src] = false;
  }

  public static void main(String[] args) {

    int V = 7;
    ArrayList<Edge>[] graph = new ArrayList[V];

    for (int i = 0; i < V; i++) {
      graph[i] = new ArrayList<Edge>();
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

    graph[6].add(new Edge(6, 5, 3));
    graph[6].add(new Edge(6, 4, 8));

    boolean[] visited = new boolean[V];

    get_floor_n_ceil(graph, 0, 6, visited, "0", 0, 40);

    System.out.println("Ceil Path of 40: " + cPath + ", Weight: " + cPathWt);
    System.out.println("Floor Path of 40: " + fPath + ", Weight: " + fPathWt);

  }

}
