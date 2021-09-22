package swea_test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class num_2563 {
	//픽셀처럼 하나하나씩 비교
	public static int[][] paper = new int[100][100];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int nNum = Integer.parseInt(br.readLine());
		for(int t=0;t<nNum;t++) {
			StringTokenizer tk = new StringTokenizer(br.readLine());
			int row = Integer.parseInt(tk.nextToken());
			int col = Integer.parseInt(tk.nextToken());
			for(int i=row;i<(row+10);i++) {
				for(int j=col;j<(col+10);j++) {
					paper[i][j]=1;
				}
			}
		}
		int sum = 0;
		sum = check_sum(sum);
		System.out.println(sum);
	}
	public static int check_sum(int sum) {
		for(int i=0;i<paper.length;i++) {
			for(int j=0;j<paper.length;j++) {
				sum+=paper[i][j];
			}
		}
		return sum;
	}
}
