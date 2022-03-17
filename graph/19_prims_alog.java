import java.util.*;

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

  static class Pair implements Comparable<Pair> {
    int v;
    int av;
    int wt;

    public Pair(int v, int av, int wt) {
      this.v = v;
      this.av = av;
      this.wt = wt;
    }

    public int compareTo(Pair o) {
      return this.wt - o.wt;
    }
  }

  static void primsAlgo(ArrayList<Edge>[] graph) {

    PriorityQueue<Pair> pq = new PriorityQueue<>();

    pq.add(new Pair(0, -1, 0));
    boolean[] visited = new boolean[7];
    while (pq.isEmpty() == false) {
      // r m* w a*

      Pair rem = pq.remove();

      if (visited[rem.v] == true) {
        continue;
      }
      visited[rem.v] = true;

      if (rem.av != -1) {
        System.out.println(rem.v + " - " + rem.av + " @ " + rem.wt);
      }
      for (Edge edge : graph[rem.v]) {
        if (visited[edge.nbr] == false) {
          pq.add(new Pair(edge.nbr, rem.v, edge.wt));
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

    primsAlgo(graph);
  }
}