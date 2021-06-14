

public class undirectedGraph {
	private int count ; //노드 갯수
	private int[][] vertaxMatrix; //2차원 배열
	
	public undirectedGraph(int count) {
		this.count = count;
		vertaxMatrix = new int[count][count];
	}
	public void addEdge(int from, int to, int weight) { //간선에 정보,undirected이기 때문에  weight를 동일한 값으로 준다.
		vertaxMatrix[from][to] = weight; //대각선을 기준으로 from,to가 모두 동일하기 떄문에 
		vertaxMatrix[to][from] = weight; //현재는 방향성이 없기 때문에
		
	}
	public int[][] getMatrix(){ //2차원 배열을 return
		return vertaxMatrix;
	}
}	
