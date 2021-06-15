package step14;

public class MyGraph {
	private int count;
	private int[][] matrix;
	private boolean[] visited;
	private int[] distance; // 남아있는 가장 가까운 거리를 가진 애

	public MyGraph(int count) {
		this.count = count;
		matrix = new int[count][count];
		visited = new boolean[count];
		distance = new int[count];
	}

	public void addEdge(int from, int to, int weight) {
		matrix[from][to] = weight;
		matrix[to][from] = weight;
	}

	public void checkShort(int from) {
		for (int i = 0; i < count; i++) {
			distance[i] = Integer.MAX_VALUE;
		}
		visited[from] = true;
		distance[from] = 0;

		for (int i = 0; i < count; i++) {
			if (visited[from] && matrix[from][i] != 0) {
				distance[i] = matrix[from][i]; // 0과 인접한 값들 넣어주기
			}
		}

		for (int k = 0; k < count - 1; k++) {
			int min = Integer.MAX_VALUE;
			int minindex = -1;
			for (int i = 0; i < count; i++) {
				if (visited[i] != true && distance[i] != Integer.MAX_VALUE) { // 처음 시작할 때 최솟값 찾기
					if (distance[i] < min) {
						min = distance[i];
						minindex = i;
					}
				}
			}
			visited[minindex] = true;
			for (int i = 0; i < count; i++) {
				if (visited[i] != true && matrix[minindex][i] != 0) {
					if (distance[i] > distance[minindex] + matrix[minindex][i]) {
						distance[i] = distance[minindex] + matrix[minindex][i];
					}
				}
			}
		}
	}

	public void showShort(int from) {
		for (int i = 0; i < count; i++) {
			System.out.println(from + " 노드로부터 " + i + " 노드까지의 최단 거리는 : " + distance[i]);
		}
	}

	public static void main(String[] args) {
		int count = 6;
		MyGraph graph = new MyGraph(count);
		graph.addEdge(0, 1, 1);
		graph.addEdge(0, 2, 4);
		graph.addEdge(1, 2, 2);
		graph.addEdge(2, 3, 1);
		graph.addEdge(3, 4, 8);
		graph.addEdge(3, 5, 3);
		graph.addEdge(4, 5, 4);

		graph.checkShort(0);
		graph.showShort(0);
	}
}
