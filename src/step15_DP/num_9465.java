package step15_DP;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class num_9465 {//스티커
	public static int[][] deltas = {{0,1},{0,-1},{1,0},{-1,0}};
	public static int[][] sticker;
	public static int[][] dp;
	public static int max;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tcase = Integer.parseInt(br.readLine());
		for(int t=0;t<tcase;t++) {
			int nNum = Integer.parseInt(br.readLine());
			sticker = new int[2][nNum];
			dp = new int[2][nNum];
			for(int i=0;i<2;i++) {
				StringTokenizer tk = new StringTokenizer(br.readLine());
				for(int j=0;j<nNum;j++) {
					sticker[i][j] = Integer.parseInt(tk.nextToken());
				}
			}
			
			max = Integer.MIN_VALUE;
			//처음 시작 지점 정해주기
			for(int i=0;i<2;i++) {
				for(int j=0;j<nNum;j++) {
					
				}
			}
		}
	}
	
}
