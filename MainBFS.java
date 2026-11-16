
import java.util.*;

abstract class AbstractClassBFS {
    abstract void bfs(int start);
}

class SubclassBFS extends AbstractClassBFS {
    int[][] graph;
    int vertices;

    SubclassBFS(int[][] graph, int vertices) {
        this.graph = graph;
        this.vertices = vertices;
    }

    void bfs(int start) {
        boolean[] visited = new boolean[vertices];
        Queue<Integer> queue = new LinkedList<>();

        visited[start] = true;
        queue.add(start);

        System.out.print("BFS Traversal: ");

        while (!queue.isEmpty()) {
            int current = queue.poll();
            System.out.print(current + " ");

            for (int i = 0; i < vertices; i++) {
                if (graph[current][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
    }
}

public class MainBFS {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of vertices: ");
        int vertices = sc.nextInt();

        int[][] graph = new int[vertices][vertices];

        System.out.print("Enter number of edges: ");
        int edges = sc.nextInt();

        for (int i = 0; i < edges; i++) {
            System.out.print("Enter source and destination: ");
            int source = sc.nextInt();
            int destination = sc.nextInt();

            graph[source][destination] = 1;
            graph[destination][source] = 1;
        }

        System.out.println("Adjacency Matrix:");

        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {
                System.out.print(graph[i][j] + " ");
            }
            System.out.println();
        }

        System.out.print("Enter starting vertex: ");
        int start = sc.nextInt();

        SubclassBFS bfs = new SubclassBFS(graph, vertices);
        bfs.bfs(start);

        sc.close();
    }
}
