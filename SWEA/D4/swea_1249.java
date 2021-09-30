import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class swea_1249 {
	public static int[][] map;
	public static int[][] distance;
	public static int nNum;
	public static Queue<int[]> queue = new LinkedList<int[]>();
	public static int[][] deltas = {{-1,0},{1,0},{0,1},{0,-1}};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tcase = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int t=0;t<tcase;t++) {
			nNum =  Integer.parseInt(br.readLine());
			map = new int[nNum][nNum];
			distance = new int[nNum][nNum];
			for(int i=0;i<nNum;i++) {
				String str = br.readLine();
				for(int j=0;j<nNum;j++) {
					map[i][j] = str.charAt(j)-'0';			
					distance[i][j] = Integer.MAX_VALUE;
				}
			}
			distance[0][0] = 0;
			queue.offer(new int[] {0,0});
			int dis = bfs();
			sb.append("#"+(t+1)+" "+dis+"\n");
		}
		System.out.println(sb);
	}
	public static int bfs() {
		while(!queue.isEmpty()) {

			int[] arr = queue.poll();
			int i = arr[0];
			int j = arr[1];
			for(int d=0;d<4;d++) {
				int ni = i+deltas[d][0];
				int nj = j+deltas[d][1];
				if(ni>=0&&nj>=0&&ni<map.length&&nj<map[ni].length) {//이동가능
					if(distance[ni][nj]>map[ni][nj]+distance[i][j]) {
						distance[ni][nj] = map[ni][nj]+distance[i][j];
						queue.offer(new int[] {ni,nj});
					}
				}
			}
		}
		return distance[nNum-1][nNum-1];
	}
}
