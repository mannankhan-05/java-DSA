import java.util.*;

public class DS_graph_cycleDetection {
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

   public static boolean isCycleDirected(ArrayList<Edge> graph[], boolean visArr[], int curr, boolean rec[]) {
       visArr[curr] = true;
       rec[curr] = true;

       // loop for the neighbours of the curr
       for (int i = 0; i < graph[curr].size(); i++) {
           Edge e = graph[curr].get(i);
           if (rec[e.dest] == true) {
               return true; // cycle exists
           } else if (!visArr[e.dest]) {
               if(isCycleDirected(graph, visArr, e.dest, rec)){
                   return true; // cycle exists
               }
           }
       }

       rec[curr] = false;
       return false; // cycle doesn't exist
   }

    public static void main(String[] args){
        int V = 4;

        ArrayList<Edge> graph[] = new ArrayList[V];
        boolean[] visArr = new boolean[V];
        createGraph(graph);

        System.out.println(isCycleDirected(graph, new boolean[V], 0, new boolean[V]));
    }
}
