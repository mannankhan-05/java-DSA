import java.util.*;

public class DS_graph_BFS_DFS {
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

        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 3));

        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 4));

        graph[3].add(new Edge(3, 1));
        graph[3].add(new Edge(3, 4));
        graph[3].add(new Edge(3, 5));

        graph[4].add(new Edge(4, 2));
        graph[4].add(new Edge(4, 3));
        graph[4].add(new Edge(4, 5));

        graph[5].add(new Edge(5, 3));
        graph[5].add(new Edge(5, 4));
        graph[5].add(new Edge(5, 6));

        graph[6].add(new Edge(6, 5));
    }

    public static void bfs(ArrayList<Edge> graph[], int V, boolean[] visArr, int start){
        Queue<Integer> q = new LinkedList<>();
        q.add(start); // starting point of graph

         while(!q.isEmpty()){
             int curr = q.remove();
             if(visArr[curr] == false){
                 System.out.print(curr + " ");
                 visArr[curr] = true;

                 for(int i = 0; i < graph[curr].size(); i++){
                     Edge e = graph[curr].get(i);
                     q.add(e.dest);
                 }
             }
         }
    }

    public static void dfs(ArrayList<Edge> graph[], int curr, boolean visArr[]){
        // time complexity of dfs = O(V + E)
        System.out.print(curr + " ");
        visArr[curr] = true;

        for(int i = 0; i < graph[curr].size(); i++){
            Edge e = graph[curr].get(i);
            if(visArr[e.dest] == false) {
                dfs(graph, e.dest, visArr);
            }
        }
    }

    public static void printAllPath(ArrayList<Edge> graph[], boolean visArr[], int curr, String path, int tar){
        // time complexity of dfs = O(V ^ V)
        if(curr == tar){
            System.out.println(path);
            return;
        }

        for(int i = 0; i < graph[curr].size(); i++){
            Edge e  = graph[curr].get(i);
            if(!visArr[e.dest]){
                visArr[curr] = true;
                printAllPath(graph, visArr, e.dest, path + e.dest, tar);
                visArr[curr] = false;
            }
        }
    }

    public static void main(String[] args){
        int V = 7;  // no of vertices
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);

        int src = 0; int tar = 5;

        boolean visArr[] = new boolean[V];
        for(int i = 0; i < V; i++){
            if(visArr[i] == false){
                bfs(graph, V, visArr, i);
            }
        }

//        dfs(graph, 0, visArr);

//        printAllPath(graph, new boolean[V], src, "0", tar);

    }
}
