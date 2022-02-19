import java.util.ArrayList;

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

  }
}