import java.util.ArrayList;

class Edge {
  int v;
  int n;

  public Edge(int v, int n) {
    this.v = v;
    this.n = n;
  }
}

class Program {

  public static void dfs(ArrayList<Edge>[] graph, int src, boolean[] visited, ArrayList<Integer> comp) {

    if (visited[src] == true) {
      return;
    }

    visited[src] = true;
    comp.add(src);
    for (Edge edge : graph[src]) {
      if (visited[edge.n] == false) {
        dfs(graph, edge.n, visited, comp);
      }
    }
  }

  public static ArrayList<ArrayList<Integer>> getComponents(ArrayList<Edge>[] graph) {

    int n = graph.length;
    boolean[] visited = new boolean[n];
    ArrayList<ArrayList<Integer>> components = new ArrayList<>();
    for (int v = 0; v < n; v++) {
      if (visited[v] == false) {
        ArrayList<Integer> comp = new ArrayList<>();
        dfs(graph, v, visited, comp);
        components.add(comp);
      }
    }
    return components;
  }

  public static void main(String[] args) {

    int n = 7;
    ArrayList<Edge>[] graph = new ArrayList[n];

    for (int v = 0; v < n; v++) {
      graph[v] = new ArrayList<>();
    }

    graph[0].add(new Edge(0, 1));
    graph[1].add(new Edge(1, 0));
    graph[2].add(new Edge(2, 3));
    graph[3].add(new Edge(3, 2));
    graph[4].add(new Edge(4, 5));
    graph[4].add(new Edge(4, 6));
    graph[5].add(new Edge(5, 4));
    graph[5].add(new Edge(5, 6));
    graph[6].add(new Edge(6, 4));
    graph[6].add(new Edge(6, 5));

    ArrayList<ArrayList<Integer>> components = getComponents(graph);

    for (ArrayList<Integer> list : components) {
      for (Integer v : list) {
        System.out.print(v + " ");
      }
      System.out.println();
    }
    int pairs = 0;
    for (int i = 0; i < components.size(); i++) {
      for (int j = i + 1; j < components.size(); j++) {
        int count = components.get(i).size() * components.get(j).size();
        pairs += count;
      }
    }
    System.out.println(pairs);
  }
}