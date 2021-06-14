
import java.util.Stack;

import step14.undirectedGraph;

public class DfsSearch {
	int count;
	boolean[] visited;  //방문 여부
	Stack<Integer> stack; //DFS를 위한 Stack
	int[][] matrix; //2차원 배열
	
	public DfsSearch(int count) {
		this.count = count;
		visited = new boolean[count];
		stack = new Stack<Integer>();
	}
	public void dfsVisit() {
		stack.push(0);
		//인접 노드인지 체크하는 정보
		visited[0] = true; //우선 들어갔기 때문에 방문했다는 의미에서 true
		while(stack.isEmpty() != true) { //stack이 다 비워질때까지
			int node = stack.pop(); //하나를 꺼내고 얘의 인접 노드를 확인
			System.out.println(node + " ");
			for(int i=0;i<count;i++) {
				if(matrix[node][i] != 0 && visited[i] == false) {//1.가져온 node와 i가 연결이 되어있는지,weight이 1로 주었기 때문에 
					stack.push(i);                               //2.visited[i]가 false라면 stack에 들어간적이 없다는 의
					visited[i] = true;
				}
			}
		}
	}
	public static void main(String[] args) {
		int count = 8;
		undirectedGraph graph = new undirectedGraph(count);
		graph.addEdge(0, 1, 1);//0에서 1로 가는 간선
		graph.addEdge(0, 2, 1);
		graph.addEdge(1, 3, 1);
		graph.addEdge(1, 4, 1);
		graph.addEdge(2, 5, 1);
		graph.addEdge(2, 6, 1);
		graph.addEdge(4, 5, 1);
		graph.addEdge(3, 7, 1);
		
		DfsSearch dfs = new DfsSearch(count);
		dfs.matrix = graph.getMatrix();
		
		dfs.dfsVisit();
	}
}
