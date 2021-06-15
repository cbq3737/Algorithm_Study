
import java.util.ArrayList;

import step14.undirectedGraph;

public class BfsSearch {
	int count;
	boolean[] visited;
	int[][] matrix;
	ArrayList<Integer> queue; // 큐로 사용

	public BfsSearch(int count) {
		this.count = count;
		visited = new boolean[count];
		queue = new ArrayList<Integer>();
	}

	public void bfsVisit() {
		queue.add(0);
		visited[0] = true;
		while (queue.size() != 0) {
			int node = queue.remove(0);
			System.out.println(node + " ");
			for (int i = 0; i < count; i++) {
				if (matrix[node][i] != 0 && visited[i] == false) {
					queue.add(i);
					visited[i] = true;
				}
			}
		}
	}

	public static void main(String[] args) {
		int count = 8;
		undirectedGraph graph = new undirectedGraph(count);
		graph.addEdge(0, 1, 1);
		graph.addEdge(0, 2, 1);
		graph.addEdge(1, 3, 1);
		graph.addEdge(1, 4, 1);
		graph.addEdge(2, 5, 1);
		graph.addEdge(2, 6, 1);
		graph.addEdge(4, 5, 1);
		graph.addEdge(3, 7, 1);

		BfsSearch bfs = new BfsSearch(count);
		bfs.matrix = graph.getMatrix();
		bfs.bfsVisit();
	}
}
