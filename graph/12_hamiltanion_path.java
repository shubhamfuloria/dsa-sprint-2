import java.util.ArrayList;
import java.util.HashSet;

class Program {
  static class Edge {
    int v;
    int n;

    public Edge(int v, int n) {
      this.v = v;
      this.n = n;
    }
  }

  static boolean isHamiltanionPath(boolean[] visited) {
    // checks if all edges are visited

    for (boolean el : visited) {
      if (el == false) {
        return false;
      }
    }
    return true;

  }

  static void printHamiltanionPathAndCycle(ArrayList<Edge>[] graph, int src, HashSet<Integer> visited, String psf,
      int oSrc) {

    if (visited.size() == graph.length - 1) {
      // checking for cycles
      boolean isCyclic = false;
      for (Edge edge : graph[src]) {
        if (edge.n == oSrc) {
          isCyclic = true;
          break;
        }
      }

      if (isCyclic) {
        System.out.println("Hamitanion Cyclic Path: " + psf);
      } else {
        System.out.println("Hamiltanion non Cyclic Path: " + psf);
      }
      return;
    }

    visited.add(src);

    for (Edge edge : graph[src]) {
      if (visited.contains(edge.n) == false) {
        printHamiltanionPathAndCycle(graph, edge.n, visited, psf + edge.n, oSrc);
      }
    }

    visited.remove(src);
  }

  public static void main(String[] args) {
    int V = 7;
    ArrayList<Edge>[] graph = new ArrayList[V];

    for (int v = 0; v < V; v++) {
      graph[v] = new ArrayList<>();
    }

    graph[0].add(new Edge(0, 1));
    graph[0].add(new Edge(0, 3));

    graph[1].add(new Edge(1, 0));
    graph[1].add(new Edge(1, 2));

    graph[2].add(new Edge(2, 1));
    graph[2].add(new Edge(2, 3));
    graph[2].add(new Edge(2, 5));

    graph[3].add(new Edge(3, 0));
    graph[3].add(new Edge(3, 2));
    graph[3].add(new Edge(3, 4));

    graph[4].add(new Edge(4, 3));
    graph[4].add(new Edge(4, 5));
    graph[4].add(new Edge(4, 6));

    graph[5].add(new Edge(5, 2));
    graph[5].add(new Edge(5, 4));
    graph[5].add(new Edge(5, 6));

    graph[6].add(new Edge(6, 4));
    graph[6].add(new Edge(6, 5));

    HashSet<Integer> visited = new HashSet<>();

    int src = 0;
    printHamiltanionPathAndCycle(graph, src, visited, src + "", src);
  }
}