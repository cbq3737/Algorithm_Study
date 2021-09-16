import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class swea_1263 {
	static int T,N; //테스트 케이스
	static int[][] graph;
	static int INF = 987654321; //다른 두 수를 더하는 과정에서 MAX는 오버플로우 뜬다
			
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		StringTokenizer tk =null;
		for(int t=1;t<=T;t++) {
			tk= new StringTokenizer(br.readLine());
			N = Integer.parseInt(tk.nextToken());
			graph = new int[N][N];
			for(int r =0;r<N;r++) {
				for(int c=0;c<N;c++) {
					graph[r][c] = Integer.parseInt(tk.nextToken());
					//연결 불가하다면 무한대로 처리해주자.
					if(graph[r][c]==0) { //아예 접근도 못하도록 무한대로 변경해준다. 
						graph[r][c]=INF;
					}
				}
			}
			for(int[] row:graph) {
				System.out.println(Arrays.toString(row));
			}
			int result = floyd();
//			int result = Integer.MAX_VALUE;
//			for(int i=0;i<N;i++) {
//				result = Math.min(result, bfs(i));
//			}
			sb.append("#"+t+" "+result+"\n");
		}
		System.out.println(sb);
	}
	
	public static int bfs(int start) {//start에서 시작해서 모든 노드를 방문하는데 걸리는 시간? 단계?
		int sum =0;
		Queue<Integer> queue = new LinkedList<>();
		boolean[] visited = new boolean[N];
		visited[start]= true;
		queue.offer(start);
		int depth = 1;
		int found =1;
		while(!queue.isEmpty()) {
			//depth가 단계에 따라 증가되어야 하기 때문에
			int size = queue.size();
			while(size-- >0) { //하나의 depth가 되는 것이다.
			int head = queue.poll();
			//연결지점 탐색
			for(int c=0;c<N;c++) {
				//연결되어있고 미방문이면??
				if(!visited[c]&&graph[head][c]==1) {//그 지점을 방문하고
					visited[c]= true;
					queue.offer(c);
					sum+=depth; //방문한 비용 추가
					found++;
					if(found==N) {//다끝냈으면 그냥 바로 반환해줘버려라
						return sum;
					}
				}
			}
		}
			depth++; //+1씩 되던게 +2씩 증가
		}
		return sum;
	}
	static int floyd() {
		//경우지 k를 거쳐서 출발지 i에서 목적지 j로 가는 비용을 계산
		for(int k=0;k<N;k++) {//경유지
			for(int i=0;i<N;i++) {//출발지
				if(i==k) { //출발지==경유지 관심없다.
					continue;
				}
				for(int j=0;j<N;j++) {//도착지
					if(k==j) { //경유지==목적지 관심없다.
						continue;
					}
					//경유해서가는 비용이 더 적다면 바꿔주자.
					graph[i][j] = Math.min(graph[i][k]+graph[k][j], graph[i][j]);
				}
			}
		}
		int minCC = Integer.MAX_VALUE;
		for(int r=0;r<N;r++) {
			int sum=0;
			for(int c=0;c<N;c++) {
				if(r!=c) {
					sum+=graph[r][c];
				}
			}
			minCC =  Math.min(sum, minCC);
		}
				
		for(int[] row:graph) {
			System.out.println(Arrays.toString(row));
		}
		return minCC;
	}
}
