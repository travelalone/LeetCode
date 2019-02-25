import java.util.*;

class Graph{
    int V;
    LinkedList<Integer> adj[];
    Graph(int v)
    {
        V = v;
        adj = new LinkedList[v];
        for(int i =0; i<v; i++)
            adj[i] = new LinkedList<Integer>();
    }
    void addEdge(int v, int w)
        {adj[v].add(w);}

}

public class topologicalSort{
    Graph graph;

    topologicalSort(Graph graph){
        this.graph = graph;
        Stack<Integer> stack = new Stack<>();
        int size = graph.V;
        Boolean [] visited = new Boolean[size]; // default false;

        for(int i = 0 ; i<size; i++)
            visited[i] = false;

        for(int i = 0 ; i<size; i++)
        {
            if (visited[i]) continue;
            sortHelper(i,visited, stack);
        }
        while(!stack.isEmpty())
            System.out.print(stack.pop());
    }

    private void sortHelper(int i, Boolean[] visited, Stack<Integer> stack)
    {
        visited[i] = true;
        for(int t: graph.adj[i])
        {
            if(visited[t]) continue;
            sortHelper(t, visited, stack);
        }
        stack.add(i);
    }

    public void kahnSort(Graph graph)
    {
        int size = graph.V;
        int indegree[] = new int[size];
        int cnt=0;
        List<Integer> list = new ArrayList<>();
        // compute indegree first;
        for(int i = 0; i<size; i++)
            for(int t: graph.adj[i])
                indegree[t]++;
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i<size; i++)
            if(indegree[i] == 0) queue.offer(i);
        while(!queue.isEmpty())
        {
            int t = queue.poll();
            list.add(t);
            for(int node: graph.adj[t])
                if(--indegree[node] == 0) queue.add(node);
            cnt++;
        }
        if (cnt != size) System.out.println("IS a Cycle");
        for(int i: list)
            System.out.print(i);
    }

    public static void main(String[] args)
    {
        Graph g = new Graph(6);
        g.addEdge(5, 2);
        g.addEdge(5, 0);
        g.addEdge(4, 0);
        g.addEdge(4, 1);
        g.addEdge(2, 3);
        g.addEdge(3, 1);
        topologicalSort tsobj = new topologicalSort(g);
        tsobj.kahnSort(g);
    }
}
