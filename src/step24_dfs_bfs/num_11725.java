package step24_dfs_bfs;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class num_11725 {// 트리의 부모 찾기
	public static int nNum;
	public static boolean flag;
	public static int[] parent;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		nNum = Integer.parseInt(br.readLine());
		parent = new int[nNum + 1];// 부모값
		// 인접리스트
		ArrayList<ArrayList<Integer>> list = new ArrayList();
		for (int i = 0; i <= nNum; i++) {
			list.add(new ArrayList());
		}

		StringTokenizer tk = null;

		// 무향 그래프
		for (int i = 0; i < nNum - 1; i++) {
			tk = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(tk.nextToken());
			int to = Integer.parseInt(tk.nextToken());
			list.get(from).add(to);// 인접행렬에 추가
			list.get(to).add(from);
		}

		// 깊이 우선 탐색
		boolean[] check = new boolean[nNum + 1];// 노드 방문 체크
		search(list, 1, check);// 부모노드인 1부터 시작

		for (int i = 2; i < parent.length; i++) {
			sb.append(parent[i] + "\n");

		}
		System.out.println(sb);
	}
	//원래 방식: 자식에서부터 찾아가서 이어진 노드 중 1이 있다면 true
	//부모노드부터 이어져있는 자식노드를 탐색
	public static void search(ArrayList<ArrayList<Integer>> list, int root, boolean[] visited) {

		visited[root] = true;
		for (int i = 0; i < list.get(root).size(); i++) {
			int child_node = list.get(root).get(i);
			if (!visited[child_node]) {
				parent[child_node] = root;
				search(list, child_node, visited);
			}
		}
	}
}
