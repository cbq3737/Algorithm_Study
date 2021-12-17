package step25_최단경로;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//생각해보면 다익스트라는 1번에서부터 모든 곳의 대한 최솟값을 찾는것이기때문에 1차원배열만 만들면됌.
//가중치에 음수가 포함되어있는 최단거리 문제이므로 벨만 포드
public class num_11657 {
	public static ArrayList<ArrayList<int[]>> list;
	public static long[] grid;
	public static boolean flag;
	public static int nNum;
	public static int mNum;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(br.readLine());
		nNum = Integer.parseInt(tk.nextToken());// 도시
		mNum = Integer.parseInt(tk.nextToken());// 버스
		list = new ArrayList(); // 인접 리스트
		grid = new long[nNum + 1];
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i <= nNum; i++) {
			list.add(new ArrayList<int[]>());
		}
		for (int i = 1; i <= nNum; i++) {
			grid[i] = Long.MAX_VALUE;// 변수 저장
		}
		for (int i = 0; i < mNum; i++) {
			tk = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(tk.nextToken());// 출발지점
			int end = Integer.parseInt(tk.nextToken());// 끝지점
			int time = Integer.parseInt(tk.nextToken());// 가중치
			list.get(start).add(new int[] { end, time });
		}
		search_pay(1);
		if (flag) {// 무한대
			sb.append(-1);
		} else {
			for (int i = 2; i <= nNum; i++) {
				if (grid[i] == Long.MAX_VALUE) {
					sb.append(-1 + "\n");
				} else {
					sb.append(grid[i] + "\n");
				}
			}
		}
		System.out.println(sb);
	}

	public static void search_pay(int start) {
		grid[start] = 0;// 맨처음 위치는 당연히 0

		for (int k = 1; k <= nNum; k++) {// 간선의 수 만큼 반복
			
			for (int n = 1; n <= nNum; n++) {
				int start_node = n;// 시작 노드
				for (int i = 0; i < list.get(start_node).size(); i++) {
					int end_point = list.get(start_node).get(i)[0];// 이어져있는 도착지
					int time = list.get(start_node).get(i)[1];// 가중치
					if (grid[start_node] != Long.MAX_VALUE && grid[end_point] > grid[start_node] + time) {
						grid[end_point] = grid[start_node] + time;
						if (k == nNum) {// N-1번만큼만 돌아야하는데 N번째에 여기에 왔다면 음의 싸이클
							flag = true;
							return;
						}
					}
				}
			}
			
		}
		// 다익스트라는 1번부터 작은수를 찾으니까 모든 수를 돌지만 음수가 포함되면 정점갯수 이상으로 계속 루프가 진행됨

	}
}
