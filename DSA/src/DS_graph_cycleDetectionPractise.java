import java.util.ArrayList;


public class DS_graph_cycleDetectionPractise {
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
            graph[i] = new ArrayList<Edge>();
        }

        graph[0].add(new Edge(0, 2));
        graph[1].add(new Edge(1, 0));
        graph[2].add(new Edge(2, 3));
        graph[3].add(new Edge(3, 0));
    }

    // function to check if cycle exists or not
    public static boolean isCycleDirected(ArrayList<Edge> graph[], boolean[] visArr, int curr, boolean[] recArr){
        visArr[curr] = true;
        recArr[curr] = true;

        // all the neighbours of the current vertex
        for(int i = 0; i < graph[curr].size(); i++){
            Edge e = graph[curr].get(i);
            if(recArr[e.dest] == true){
                return true;
            }
            else if(!visArr[e.dest]){
                if(isCycleDirected(graph, visArr, e.dest, recArr)){
                    return true;
                }
            }
        }

        recArr[curr] = false;
        return false;
    }

    public static void main(String[] args){
        int V = 4;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);

        System.out.println(isCycleDirected(graph, new boolean[V], 0, new boolean[V]));
    }
}
