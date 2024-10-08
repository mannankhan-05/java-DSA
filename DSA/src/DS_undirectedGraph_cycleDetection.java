import java.util.*;

public class DS_undirectedGraph_cycleDetection {
    static class Edge{
        int src;
        int dest;

        Edge(int s, int d){
            this.src = s;
            this.dest = d;
        }
    }

    public static void createGraph(ArrayList<Edge> graph[]){
        for(int i = 0; i < graph.length; i++){
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 4));

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 2));
//        graph[1].add(new Edge(1, 4));

        graph[2].add(new Edge(2, 1));
        graph[2].add(new Edge(2, 3));

        graph[3].add(new Edge(3, 2));

        graph[4].add(new Edge(4, 0));
//        graph[4].add(new Edge(4, 1));
        graph[4].add(new Edge(4, 5));

        graph[5].add(new Edge(5, 4));
    }

    public static boolean isCycleUndirected(ArrayList<Edge> graph[], boolean visArr[], int curr, int parent){
        visArr[curr] = true;

        for(int i = 0; i < graph[curr].size(); i++){
            Edge e = graph[curr].get(i);

            if(visArr[e.dest] && e.dest != parent){
                return true;
            }
            else if(!visArr[e.dest]){
                if(isCycleUndirected(graph, visArr, e.dest, curr)){
                    return true; // cycle exists
                }
            }
        }

        return false; // cycle doesn't exist
    }

    public static void main(String[] args){
        int V = 6; // no. of vertices in a graph

        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        System.out.println(isCycleUndirected(graph, new boolean[V], 0, -1));
    }
}
