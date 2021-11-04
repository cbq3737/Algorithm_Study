package swea_test;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class num_16967 {//배열 복원하기
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(br.readLine());
		int hNum = Integer.parseInt(tk.nextToken());
		int wNum = Integer.parseInt(tk.nextToken());
		int xNum = Integer.parseInt(tk.nextToken());
		int yNum = Integer.parseInt(tk.nextToken());
		StringBuilder sb = new StringBuilder();
		int[][] arr = new int[hNum][wNum];
		int[][] check_arr = new int[hNum][wNum];
		int[][] barr = new int[hNum+xNum][wNum+yNum];
		int[][] new_barr  = new int[hNum+xNum][wNum+yNum];
		
		for(int i=0;i<(hNum+xNum);i++) {
			 tk = new StringTokenizer(br.readLine());
			for(int j=0;j<(wNum+yNum);j++) {
				barr[i][j] = Integer.parseInt(tk.nextToken());//B배열 받기
			}
		}
		//1을 채워넣어 중복된 부분 체크, 1이면 중복x,
		for(int i=0;i<hNum;i++) {
			for(int j=0;j<wNum;j++) {
				check_arr[i][j] = 1;
				new_barr[i][j]+=check_arr[i][j];
			}
		}
		for(int i=xNum;i<hNum+xNum;i++) {
			for(int j=yNum;j<wNum+yNum;j++) {
				new_barr[i][j]+=check_arr[i-xNum][j-yNum];
			}
		}
		
		for(int i=0;i<hNum;i++) {
			for(int j=0;j<wNum;j++) {
				if(new_barr[i][j]==1) {//기존 위치 값 그대로
					arr[i][j] = barr[i][j];
				}else if(new_barr[i][j]==2) {//B배열에서 기존 값 빼주기
					arr[i][j] = barr[i][j] - arr[i-xNum][j-yNum];
				}
			}
		}
//		for(int[] row:new_barr) {
//			System.out.println(Arrays.toString(row));			
//		}
		
		for(int i=0;i<hNum;i++) {
			for(int j=0;j<wNum;j++) {
				sb.append(arr[i][j]+" ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
	}
}
