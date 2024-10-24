import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class DS_graph_Practise {
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

    // function to create graph
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

    // function to traverse graph using bfs(breath first search)
    public static void bfs(ArrayList<Edge> graph[], boolean[] visArr, int start){
        Queue<Integer> q = new LinkedList<>();
        q.add(start);

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

    // function to traverse graph using dfs(depth first search)
    public static void dfs(ArrayList<Edge> graph[], boolean[] visArr, int curr){
        System.out.print(curr + " ");
        visArr[curr] = true;

        for(int i = 0; i < graph[curr].size(); i++){
            Edge e  = graph[curr].get(i);
            if(visArr[e.dest] == false){
                dfs(graph, visArr, e.dest);
            }
        }
    }

    public static void main(String[] args){
        int V = 4;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);

        bfs(graph, new boolean[V], 0);
        System.out.println();
        dfs(graph, new boolean[V], 0);
    }
}
