import java.util.ArrayList;

public class DS_graph_AdjacencyList {
    static class Edge{
        int src;
        int dest;
        int weight;

        public Edge(int s, int d, int w){
            this.src = s;
            this.dest = d;
            this.weight = w;
        }
    }

    public static void createGraph(ArrayList<Edge> graph[]){
        for(int i = 0; i < graph.length; i++){
            graph[i] = new ArrayList<Edge>();
        }

        graph[0].add(new Edge(0, 2, 2));

        graph[1].add(new Edge(1, 2, 10));
        graph[1].add(new Edge(1, 3, 0));

        graph[2].add(new Edge(2, 0, 2));
        graph[2].add(new Edge(2, 1, 10));
        graph[2].add(new Edge(2, 3, -1));

        graph[3].add(new Edge(3, 1, 0));
        graph[3].add(new Edge(3, 2, -1));
    }

    public static void main(String args[]){
        int V = 4;  // size of graph
        ArrayList<Edge> graph[] = new ArrayList[V];

        createGraph(graph);

        // print 2's neighbours
        for(int i = 0; i < graph[2].size(); i++){
            Edge e = graph[2].get(i);
            System.out.println(e.dest + " , " + e.weight);
        }
        System.out.println();
    }
}
