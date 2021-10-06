import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_4014 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tcase = Integer.parseInt(br.readLine());
		StringBuilder sb= new StringBuilder();
		for(int t=0;t<tcase;t++) {
			StringTokenizer tk = new StringTokenizer(br.readLine());
			int nNum = Integer.parseInt(tk.nextToken());
			int xNum = Integer.parseInt(tk.nextToken());
			int[][] grid = new int[nNum][nNum];
			for(int i=0;i<nNum;i++) {
				tk = new StringTokenizer(br.readLine());
				for(int j=0;j<nNum;j++) {
					grid[i][j] = Integer.parseInt(tk.nextToken());
				}
			}
			int success =0;//가능 횟수
			//가로 순회
			for(int i=0;i<nNum;i++) {
				int pre = grid[i][0];//첫번째 원소
				int cnt =1;//동일한 갯수 
				boolean pass = true;//통과되는지
				boolean down =false;//아래 경사로 진행되고 있는지
				for(int j=1;j<nNum;j++) {
					int cur = grid[i][j];
					//동일한지 비교
					if(pre==cur) {
						cnt++;
						pre = cur;//전꺼로 바꿔주기
						if(down&&cnt>=xNum) {
							down = false;//내려가기 끝
							cnt=0;//새롭게 시작하기 위해
						}
					}else if(pre>cur&&pre-cur==1&&!down) {//아래로 경사
						down = true; //내려간다.
						cnt=1;
						pre=cur;
					}else if(pre<cur&&cur-pre==1&&cnt>=xNum) {//위로 경사
						cnt= 1;
						pre= cur;
					}else {//내려가는 중이거나 올라가야하는데 여기 들어온다?바로 나가리
						pass = false;
						break;
					}
				}
				if(!down&&pass) {
					success++;
				}
			}
			
			//세로 순회
			for(int j=0;j<nNum;j++) {
				int pre = grid[0][j];//첫번째 원소
				int cnt =1;//동일한 갯수 
				boolean pass = true;
				boolean down =false;
				for(int i=1;i<nNum;i++) {
					int cur = grid[i][j];
					//동일한지 비교
					if(pre==cur) {
						cnt++;
						pre = cur;//전꺼로 바꿔주기
						if(down&&cnt>=xNum) {
							down = false;//내려가기 끝
							cnt=0;
						}
					}else if(pre>cur&&pre-cur==1&&!down) {//아래로 경사
						down = true; //내려간다.
						cnt=1;
						pre=cur;
					}else if(pre<cur&&cur-pre==1&&cnt>=xNum) {//위로 경사
						cnt= 1;
						pre= cur;
					}else {//내려가는 중이거나 올라가야하는데 여기 들어온다?바로 나가리
						pass = false;
						break;
					}
				}
				if(!down&&pass) {
					success++;
				}
			}
			sb.append("#"+(t+1)+" "+success+"\n");
		}
		System.out.println(sb);
	}
}
