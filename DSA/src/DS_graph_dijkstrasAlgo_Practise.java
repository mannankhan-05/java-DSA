// Algorithm to find shortest path in graph :

import java.util.*;
public class DS_graph_dijkstrasAlgo_Practise {
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
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1, 2));
        graph[0].add(new Edge(0, 2, 4));

        graph[1].add(new Edge(1, 2, 1));
        graph[1].add(new Edge(1, 3, 7));

        graph[2].add(new Edge(2, 4, 3));

        graph[3].add(new Edge(3, 5, 1));

        graph[4].add(new Edge(4, 3, 2));
        graph[4].add(new Edge(4, 5, 5));
    }

    public static class Pair implements Comparable<Pair>{
        int node;
        int dist;

        Pair(int n, int d){
            this.node = n;
            this.dist = d;
        }

        @Override
        public int compareTo(Pair p2){
            return this.dist - p2.dist; // ascending order
        }
    }

    public static void dijkstrasAlgorithm(ArrayList<Edge> graph[], int src, int V){
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        int distance[] = new int[V];
        boolean visited[] = new boolean[V];

        for(int i = 0; i < V; i++){
            if(i != src){
                distance[i] = Integer.MAX_VALUE;
            }
        }

        pq.add(new Pair(0, 0));

        // bfs
        while(!pq.isEmpty()){
            Pair curr = pq.remove();
            if(!visited[curr.node]){
                visited[curr.node] = true;

                // update neighbours
                for(int i = 0; i < graph[curr.node].size(); i++){
                    Edge e = graph[curr.node].get(i);
                    int u = e.src;
                    int v = e.dest;

                    // relaxation
                    if(distance[u] + e.weight < distance[v]){
                        distance[v] = distance[u] + e.weight;
                        pq.add(new Pair(v, distance[v]));
                    }
                }
            }
        }

        for(int i = 0; i < V; i++){
            System.out.print(distance[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args){
        int V = 6;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);

        dijkstrasAlgorithm(graph, 0, V);
    }
}
