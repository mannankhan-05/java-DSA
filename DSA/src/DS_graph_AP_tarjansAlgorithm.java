import java.util.*;

public class DS_graph_AP_tarjansAlgorithm {
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
        graph[0].add(new Edge(0, 2));
        graph[0].add(new Edge(0, 3));

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 2));

        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 1));

        graph[3].add(new Edge(3, 0));
        graph[3].add(new Edge(3, 4));

        graph[4].add(new Edge(4, 3));
    }

    // O(V + E)
    public static void dfs(ArrayList<Edge> graph[], int curr, int parent, int dt[], int low[], boolean visited[], int time, boolean ap[]){
        visited[curr] = true;
        dt[curr] = low[curr] = ++time;
        int children = 0;

        for(int i = 0; i < graph[curr].size(); i++){
            Edge e = graph[curr].get(i);
            int neighbour = e.dest;

            if(parent == neighbour){
                continue;
            }
            else if(visited[neighbour]){
                low[curr]  = Math.min(low[curr], dt[neighbour]);
            }
            else{
                dfs(graph, neighbour, curr, dt, low, visited, time, ap);
                low[curr] = Math.min(low[curr], low[neighbour]);
                if(dt[curr] <= low[neighbour] && parent != -1){
                    ap[curr] = true;
                }
                children++;
            }
        }

        if(parent == -1 && children > 1){
            ap[curr] = true;
        }
    }

    public static void getArticulationPoint(ArrayList<Edge> graph[], int V){
        int dt[] = new int[V];
        int low[] = new int[V];
        boolean visited[] = new boolean[V];
        boolean ap[] = new boolean[V];
        int time = 0;

        for(int i  = 0; i < V; i++){
            if(!visited[i]){
                dfs(graph, i,  -1, dt, low, visited, time, ap);
            }
        }

        for(int i = 0; i < V; i++){
            if(ap[i]){
                System.out.println("AP : " + i);;
            }
        }
    }

    public static void main(String[] args){
        int V = 5;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);

        getArticulationPoint(graph, V);
    }
}
