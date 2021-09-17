	import java.io.BufferedReader;
	import java.io.IOException;
	import java.io.InputStreamReader;
	import java.util.ArrayList;
	import java.util.Arrays;
	import java.util.LinkedList;
	import java.util.List;
	import java.util.Queue;
	import java.util.StringTokenizer;
	
	public class swea_1767 {
		public static int max;
		public static int len;
		public static List<int[]> list;
		public static int[][] grid;
		public static int[][] deltas= {{-1,0},{1,0},{0,1},{0,-1}};
		public static Queue<int[]> queue = new LinkedList();
		public static void main(String[] args) throws NumberFormatException, IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			StringBuilder sb = new StringBuilder();
			int tcase = Integer.parseInt(br.readLine());
			for(int t=0;t<tcase;t++) {
				int nNum = Integer.parseInt(br.readLine());
				grid = new int[nNum][nNum];
				list = new ArrayList();
				for(int i=0;i<nNum;i++) {
					StringTokenizer tk= new StringTokenizer(br.readLine());
					for(int j=0;j<nNum;j++) {
						grid[i][j]= Integer.parseInt(tk.nextToken());
						if(grid[i][j]==1) {
							if(i==0||j==0||i==nNum-1||j==nNum-1) {
								continue; //이미 가장 자리에 있는 친구들
							}else {								
								list.add(new int[] {i,j}); //cpu위치
							}
						}
					}
				}
				max = Integer.MIN_VALUE;
				len = Integer.MAX_VALUE;
				dfs(0,0,0);
				sb.append("#"+(t+1)+" "+len+"\n");
			}
			System.out.println(sb);
		}
		public static void dfs(int idx,int Corecnt,int sum) {
			if(idx == list.size()) {
				if(max<Corecnt) { //최고로 많이 연결된 코어 
					max = Corecnt;
					len = sum;
				}else if(max==Corecnt) {
					if(len>sum) {
						len = sum;
					}
				}
				return;
			}
			for(int d=0;d<deltas.length;d++) {
				int r = list.get(idx)[0];
				int c = list.get(idx)[1];
				boolean flag =false;
				//방향 빼주기 - 함수로 빼면 백트래킹
				for(int j=0;j<list.size();j++) {
					if(r==list.get(j)[0]) {//같은 행
						if(c<list.get(j)[1] && d==2) {//오른쪽에 cell이 있다면??
							flag = true;
							break;
						}else if(c>list.get(j)[1]&&d==3) {//왼쪽에 cellㅣ 있다면??
							flag = true;
							break;
						}
					}
					if(c==list.get(j)[1]) {//같은 열에 있다면
						if(r<list.get(j)[0] && d==1) { //아래에 있다면
							flag = true;
							break;
						}else if(r>list.get(j)[0] && d==0) { //위쪽에 있다면??
							flag = true;
							break;
						}
					}
				}
				if(flag) { //탐색하려는 방향에 존재한다면 
					dfs(idx+1,Corecnt,sum);
				}else {
					int cnt =0;
					int nr = r;
					int nc = c;
					while(true) {//방향으로  쭉 직진했을 때. 전선길이 구하기
						nr=nr+deltas[d][0];
						nc=nc+deltas[d][1];
						if(nr<0 || nc<0 || nr>=grid.length ||nc>=grid[nr].length) { //전선나가리
							break;
						}
						if(grid[nr][nc]==1) {//전선이나 코어라도 만나면 
							cnt=0;
							break;
						}
						cnt++; //전선길이
					}
					int new_r = r;
					int new_c = c;
	
					if(cnt==0) { //전선길이가 없다는건 연결될 코어가 없다는것.
						dfs(idx+1,Corecnt,sum);
					}else {
						for(int j=0;j<cnt;j++) { //전선 길이 구한 만큼 전선 깔아주기
							new_r = new_r+deltas[d][0];
							new_c = new_c+deltas[d][1];
							grid[new_r][new_c] = 1;
						}
						dfs(idx+1,Corecnt+1,sum+cnt);
						new_r = r;
						new_c = c;
						for(int j=0;j<cnt;j++) { //다시 그린거 초기화
							new_r = new_r+deltas[d][0];
							new_c = new_c+deltas[d][1];
							grid[new_r][new_c] =0;
						}
					}
				}	
			}
			
		}
	}
