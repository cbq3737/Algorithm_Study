package step11_브루트포스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class num_16439 {
	public static int nNum;
	public static int mNum;
	public static int max = -1;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(br.readLine());  
		nNum =  Integer.parseInt(tk.nextToken());
		mNum = Integer.parseInt(tk.nextToken());
		int[][]chicken = new int[nNum][mNum];
		
		for(int i=0;i<nNum;i++) {
			tk = new StringTokenizer(br.readLine());
			for(int j=0;j<mNum;j++) {
				chicken[i][j] = Integer.parseInt(tk.nextToken());
			}
		}
		makeCombi(0,new int[3],0,chicken);
		System.out.println(max);
	}
	public static void makeCombi(int isSelect,int[] select, int startIdx,int[][] chicken) {
		if(isSelect==3) {
			int sum =0;
			for(int i=0;i<nNum;i++) {
				int max_num = -1;
				for(int j=0;j<3;j++) {
					if(max_num<chicken[i][select[j]]) {
						max_num = chicken[i][select[j]];				
					}
				}
				sum+=max_num;
			}
			if(sum>max) {
				max = sum;
			}
			return;
		}
		
		for(int i=startIdx;i<mNum;i++) {
			select[isSelect] = i;
			makeCombi(isSelect+1,select,i+1,chicken);
		}
		
	}
}
