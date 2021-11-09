package step14_백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class num_14889_repeat {
	public static int nNum;
	public static int[][] check_power;
	public static boolean[] visit;
	public static int min = Integer.MAX_VALUE;
	public static void power(int count,int start) {
		if(count == nNum/2) {
			int team_start = 0;
			int team_link = 0;
			for(int i=0;i<nNum-1;i++) {
				for(int j=i+1;j<nNum;j++) {
					if(visit[i]==true && visit[j]== true) {
						team_start = team_start+check_power[i][j]+check_power[j][i];
					}
					else if(visit[i]==false && visit[j]==false) {
						team_link = team_link+check_power[i][j]+check_power[j][i];
					}
				}
			}
			int gap = Math.abs(team_start - team_link);
			if(gap ==0 ) {
				min = gap;
				return;
			}
			min = Math.min(min,gap);
			return;
		}
		
		for(int i=start;i<nNum;i++) {
			while(!visit[i]) {
				visit[i]= true;
				power(count+1,i+1);
			}
			visit[i]= false;
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		nNum = Integer.parseInt(br.readLine());
		check_power = new int[nNum][nNum];
		for(int i=0;i<nNum;i++) {
			StringTokenizer tk = new StringTokenizer(br.readLine());
			for(int j=0;j<nNum;j++) {
				check_power[i][j] = Integer.parseInt(tk.nextToken());
			}
		}
		visit =new boolean[nNum];
		power(0,0);
		System.out.println(min);
	}
}
