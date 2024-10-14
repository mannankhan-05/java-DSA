import java.util.*;

public class DS_graph_bellmanFordAlgorithm {
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

        graph[0].add(new Edge(0, 1, 2));
        graph[0].add(new Edge(0, 2, 4));

        graph[1].add(new Edge(1, 2, -4));

        graph[2].add(new Edge(2, 3, 2));

        graph[3].add(new Edge(3, 4, 4));

        graph[4].add(new Edge(4, 1, -1));
    }

    public static void bellmanFord(ArrayList<Edge> graph[], int src, int V){
        int dist[] = new int[V];

        for(int i = 0; i < V; i++){
            if(i != src){
                dist[i] = Integer.MAX_VALUE;  // assigning infinity value
            }
        }

        for(int k = 0; k < V - 1; k++){  //O(V)
            // O(E)
            for(int i = 0; i < V; i++){
                for(int j = 0; j < graph[i].size(); j++){  // loop for finding the neighbours
                    Edge e = graph[i].get(j);
                    int u = e.src;
                    int v = e.dest;

                    // relaxation
                    if(dist[u] != Integer.MAX_VALUE && dist[u] + e.weight < dist[v]){
                        dist[v] = dist[u] + e.weight;
                    }
                }
            }
        }

        // to detect negative(-ve) cycle
            for(int i = 0; i < V; i++){
                for(int j = 0; j < graph[i].size(); j++){  // loop for finding the neighbours
                    Edge e = graph[i].get(j);
                    int u = e.src;
                    int v = e.dest;

                    // relaxation
                    if(dist[u] != Integer.MAX_VALUE && dist[u] + e.weight < dist[v]){
                        System.out.println("Negative cycle exists !!.");
                    }
                }
            }

        for(int i = 0; i < dist.length; i++){
            System.out.print(dist[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args){
        int V = 5;

        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);

        bellmanFord(graph, 0, V);
    }
}
