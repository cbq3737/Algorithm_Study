package step14_백트래킹;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class num_14889 {
	public static int min =Integer.MAX_VALUE;
	public static int[][] power;
	public static boolean[] visit;
	public static int nNum;
	public static void check_power(int count,int member) {
		if(count == (nNum/2)) {
			int team_start =0;
			int team_link = 0;
			for(int i=0;i<nNum-1;i++) {
				for(int j=i+1;j<nNum;j++) {
					if((visit[i]==true) && (visit[j]==true)) {
						team_start = team_start+ power[i][j]+power[j][i]; 
					}
					else if((visit[i]==false) && (visit[j]==false)) {
						team_link = team_link+power[i][j]+power[j][i];
					}
				}
			}
			if(Math.abs(team_start-team_link) == 0) {
				System.out.println(Math.abs(team_start-team_link));
				System.exit(0);
			}
			else {				
				min = Math.min(Math.abs(team_start-team_link), min);
			}
			return;
		}
		for(int i=member;i<nNum;i++) {
			if(!visit[i]) {
				visit[i] = true;
				check_power(count+1,i+1);//여기서 true멤버와 false멤버를 나눠준다.
				visit[i]= false;
			}
		}	
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		nNum = Integer.parseInt(br.readLine());
		power = new int[nNum][nNum];
		visit = new boolean[nNum];
		for(int i=0;i<nNum;i++) {
			StringTokenizer tk = new StringTokenizer(br.readLine());
			for(int j=0;j<nNum;j++) {
				power[i][j] = Integer.parseInt(tk.nextToken());
			}
		}
		check_power(0,0);
		System.out.println(min);
	}
}
