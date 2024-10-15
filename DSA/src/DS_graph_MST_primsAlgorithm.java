import java.util.*;

public class DS_graph_MST_primsAlgorithm {
    static class Edge{
        int src;
        int dest;
        int weight;

        Edge(int s, int d, int w){
            this.src = s;
            this.dest = d;
            this.weight = w;
        }
    }

    public static void createGraph(ArrayList<Edge> graph[]){
        for(int i = 0; i < graph.length; i++){
            graph[i] = new ArrayList<Edge>();
        }

        graph[0].add(new Edge(0, 1, 10));
        graph[0].add(new Edge(0, 2, 15));
        graph[0].add(new Edge(0, 3, 30));

        graph[1].add(new Edge(1, 0, 10));
        graph[1].add(new Edge(1, 3, 40));

        graph[2].add(new Edge(2, 0, 15));
        graph[2].add(new Edge(2, 3, 50));

        graph[3].add(new Edge(3, 1, 40));
        graph[3].add(new Edge(3, 2, 50));
    }

    public static class Pair implements Comparable<Pair>{
        int node;
        int cost;

        Pair(int n, int c){
            this.node = n;
            this.cost = c;
        }

        @Override
        public int compareTo(Pair p2){
            return this.cost - p2.cost;
        }
    }

    public static void primsAlgorithm(ArrayList<Edge> graph[], int V){
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>();  // (node - int, cost - int)
        boolean visArr[] = new boolean[V];
        pq.add(new Pair(0, 0)); // src

        int mstCost = 0;

        while(!pq.isEmpty()){
            Pair curr = pq.remove();
            if(!visArr[curr.node]){
                visArr[curr.node] = true;
                mstCost += curr.cost;

                for(int i = 0; i < graph[curr.node].size(); i++){
                    Edge e = graph[curr.node].get(i);
                    if(!visArr[e.dest]){
                        pq.add(new Pair(e.dest, e.weight));
                    }
                }
            }
        }

        System.out.println("minimum cost of mst : " + mstCost);
    }

    public static void main(String[] args){
        int V = 4;

        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);

        primsAlgorithm(graph, V);
    }
}
