import java.util.ArrayList;

class Program {

  public static boolean hasPath(ArrayList<Edge>[] graph, int src, int dest, boolean[] visited) {

    if (src == dest) {
      return true;
    }

    visited[src] = true;

    for (Edge edge : graph[src]) {
      if (!visited[edge.nbr] && hasPath(graph, edge.nbr, dest, visited)) {
        return true;
      }
    }

    return false;
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

    boolean[] visited = new boolean[V];
    for (int i = 0; i < V; i++) {
      visited[i] = false;
    }

    if (hasPath(graph, 0, 6, visited)) {
      System.out.println("Yes there is a path.");
    } else {
      System.out.println("No, there is no path between source and destination.");
    }

  }
}
