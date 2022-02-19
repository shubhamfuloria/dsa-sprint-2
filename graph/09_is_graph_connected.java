import java.util.ArrayList;

class Edge {
  int src, nbr, wt;

  public Edge(int src, int nbr, int wt) {
    this.src = src;
    this.nbr = nbr;
    this.wt = wt;
  }

}
/*
 * A connected graph has only one component.
 */

class Program {

  public static void dfs(ArrayList<Edge>[] graph, int src, boolean[] visited, ArrayList<Integer> comp) {

    visited[src] = true;
    comp.add(src);

    for (Edge edge : graph[src]) {
      if (visited[edge.nbr] == false) {
        dfs(graph, edge.nbr, visited, comp);
      }
    }
  }

  public static boolean isGraphConnected(ArrayList<Edge>[] graph) {

    ArrayList<ArrayList<Integer>> components = new ArrayList<>();
    int V = graph.length;
    boolean[] visited = new boolean[V];
    for (int vtc = 0; vtc < V; vtc++) {
      if (visited[vtc] == false) {
        ArrayList<Integer> comp = new ArrayList<>();
        dfs(graph, vtc, visited, comp);
        components.add(comp);
      }
    }

    return components.size() == 1;

  }

  public static void main(String[] args) {
    int V = 7;

    ArrayList<Edge>[] graph = new ArrayList[V];

    for (int i = 0; i < V; i++) {
      graph[i] = new ArrayList<>();
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

    boolean res = isGraphConnected(graph);
    if (res) {
      System.out.println("Yes, graph is connected :)");
    } else {
      System.out.println("Nope, graph is not connected :(");
    }
  }
}