import java.util.*;

public class DS_graph_cycleDetection {
    static class Edge{
        int src;
        int dest;

        Edge(int s, int d){
            this.src = s;
            this.dest =d;
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

    public static void bfs(ArrayList<Edge> graph[], boolean visArr[], int start){
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

    public static void main(String[] args){
        int V = 4;

        ArrayList<Edge> graph[] = new ArrayList[V];
        boolean[] visArr = new boolean[V];
        createGraph(graph);
        bfs(graph, visArr, 1);
    }
}
