import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ArrayDeque;
/*
Bipartite Graph: if it is possible to devide vertices of a graph
                 into two mutually exclusive and exhaustive sets
                 such that all edges are across set.

Mutually Exhaustive: all vertices should come in one of two sets.
Mutually Exclusive: No vertex should be common in sets.


IMP: Every non cyclic (acyclic) graph is bipartitie.

*/

class Program {

  static class Edge {
    int src;
    int nbr;

    public Edge(int src, int nbr) {
      this.src = src;
      this.nbr = nbr;
    }
  }

  static class Pair {
    int v;
    String psf;
    int level;

    public Pair(int v, String psf, int level) {
      this.v = v;
      this.psf = psf;
      this.level = level;
    }
  }

  public static boolean isComponentBipartite(ArrayList<Edge>[] graph, int src, int[] visited) {

    ArrayDeque<Pair> queue = new ArrayDeque<>();

    queue.add(new Pair(src, src + "", 0));

    while (!queue.isEmpty()) {

      // r m* w a*

      Pair rem = queue.removeFirst();

      if (visited[rem.v] != -1) {
        if (rem.level != visited[rem.v]) {
          return false;
        }
      } else {
        visited[rem.v] = rem.level;
      }

      for (Edge edge : graph[rem.v]) {
        if (visited[edge.nbr] == -1) {
          queue.add(new Pair(edge.nbr, rem.psf + edge.nbr, rem.level + 1));
        }
      }

    }
    return true;
  }

  public static boolean isBipartite(ArrayList<Edge>[] graph) {

    int[] visited = new int[graph.length];
    Arrays.fill(visited, -1);
    for (int v = 0; v < graph.length; v++) {
      if (visited[v] == -1) {
        if (isComponentBipartite(graph, v, visited) == false) {
          return false;
        }
      }
    }

    return true;
  }

  public static void main(String[] args) {

    ArrayList<Edge>[] graph = new ArrayList[4];

    for (int v = 0; v < graph.length; v++) {
      graph[v] = new ArrayList<>();
    }

    graph[0].add(new Edge(0, 1));
    graph[0].add(new Edge(0, 3));

    graph[1].add(new Edge(1, 0));
    graph[1].add(new Edge(1, 2));

    graph[2].add(new Edge(2, 1));
    graph[2].add(new Edge(2, 3));

    graph[3].add(new Edge(3, 0));
    graph[3].add(new Edge(3, 2));

    boolean ans = isBipartite(graph);
    System.out.println(ans);

  }
}