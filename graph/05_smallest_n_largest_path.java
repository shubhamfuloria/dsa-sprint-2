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

  static String sPath;
  static Integer sPathWt = Integer.MAX_VALUE;
  static String lPath;
  static Integer lPathWt = Integer.MIN_VALUE;

  static void getExtremePaths(ArrayList<Edge>[] graph, int src, int dest, boolean[] visited, String psf, int wsf) {

    if (src == dest) {
      if (wsf < sPathWt) {
        sPathWt = wsf;
        sPath = psf;
      }
      if (wsf > lPathWt) {
        lPathWt = wsf;
        lPath = psf;
      }
      return;
    }

    visited[src] = true;

    for (Edge edge : graph[src]) {
      if (visited[edge.nbr] == false) {
        getExtremePaths(graph, edge.nbr, dest, visited, psf + edge.nbr, wsf + edge.wt);
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

    getExtremePaths(graph, 0, 6, visited, "0", 0);
    System.out.println("Smallest Path: " + sPath + ", Weight: " + sPathWt);
    System.out.println("Largest Path: " + lPath + ", Weight: " + lPathWt);

  }

}
