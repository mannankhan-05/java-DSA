import java.util.*;

public class DS_graph_SCC_kosarajuAlgorithm {
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
        graph[0].add(new Edge(0, 3));

        graph[1].add(new Edge(1, 0));

        graph[2].add(new Edge(2, 1));

        graph[3].add(new Edge(3, 4));
    }

    public static void topSort(ArrayList<Edge> graph[], int curr, boolean visited[], Stack<Integer> s){
        visited[curr] = true;

        for(int i = 0; i < graph[curr].size(); i++){
            Edge e = graph[curr].get(i);
            if(!visited[e.dest]){
                topSort(graph, e.dest, visited, s);
            }
        }

        s.push(curr);
    }

    public static void dfs(ArrayList<Edge> graph[], int curr, boolean visited[]){
        visited[curr] = true;
        System.out.print(curr  + " ");

        for(int i = 0; i < graph[curr].size(); i++){
            Edge e = graph[curr].get(i);
            if(!visited[e.dest]){
                dfs(graph, e.dest, visited);
            }
        }
    }

    public static void  kosarajuAlgo(ArrayList<Edge> graph[], int V){
        // Step 1 :  O(V + E)
        Stack<Integer> s = new Stack<>();
        boolean[] visited = new boolean[V];

        for(int i = 0; i < V; i++){
            if(!visited[i]){
                topSort(graph, i, visited, s);
            }
        }

        // Step 2 :  O(V + E)
        ArrayList<Edge> transposeGraph[] = new ArrayList[V];
        for(int i = 0; i < graph.length; i++){
            visited[i] = false;
            transposeGraph[i] = new ArrayList<Edge>();
        }

        // finding all the edges
        for(int i = 0; i < V; i++){
            for(int j = 0; j < graph[i].size(); i++){
                Edge e = graph[i].get(j);   // e.src(i) --> e.dest
                transposeGraph[e.dest].add(new Edge(e.dest, e.src));
            }
        }

        // Step 3 :  O(V + E)
        while(!s.isEmpty()){
            int curr = s.pop();
            if(!visited[curr]){
                dfs(transposeGraph, curr, visited);
                System.out.println();
            }
        }
    }

    public static void main(String[] args){
        int V = 5;

        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);

        kosarajuAlgo(graph, V);
    }
}
