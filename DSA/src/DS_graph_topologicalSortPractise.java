import java.util.ArrayList;
import java.util.Stack;

public class DS_graph_topologicalSortPractise {
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

        graph[2].add(new Edge(2, 3));

        graph[3].add(new Edge(3, 1));

        graph[4].add(new Edge(4, 0));
        graph[4].add(new Edge(4, 1));

        graph[5].add(new Edge(5, 0));
        graph[5].add(new Edge(5, 2));
    }

    public static void topSortUtil(ArrayList<Edge> graph[], int curr, boolean[] visArr, Stack<Integer> s){
        visArr[curr] = true;

        for(int i = 0; i < graph[curr].size(); i++){
            Edge e = graph[curr].get(i);

            if(!visArr[e.dest]){
                topSortUtil(graph, e.dest, visArr, s);
            }
        }

        s.push(curr);
    }

    public static void topSort(ArrayList<Edge> graph[], int V){
        boolean[] visArr = new boolean[V];
        Stack<Integer> s = new Stack<>();

        for(int i = 0; i < V; i++){
            if(!visArr[i]){
                topSortUtil(graph, i, visArr, s);
            }
        }

        while(!s.isEmpty()){
            System.out.print(s.pop() + " ");
        }
    }

    public static void main(String[] args){
        int V = 6;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);

        topSort(graph, V);
    }
}
