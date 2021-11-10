package step15_DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class num_1149 {
	public static Integer[][] arr= new Integer[1001][3];
	public static int[][] cost = new int[1001][3];
	public static int paint_cost(int N,int color) {
		if(cost[N][color] == 0 ) {
			if(color ==0) {		//맨마지막 값
				return cost[N][color] = Math.min(paint_cost(N-1,1),paint_cost(N-1,2))+arr[N][0]; 
			}
			else if(color ==1) {
				return cost[N][color] = Math.min(paint_cost(N-1,0),paint_cost(N-1,2))+arr[N][1]; 
			}
			else if(color ==2) {
				return cost[N][color] = Math.min(paint_cost(N-1,0),paint_cost(N-1,1))+arr[N][2]; 
			}
		}
		return cost[N][color];
	} 
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int nNum = Integer.parseInt(br.readLine());
		for(int i=0;i<nNum;i++) {
			StringTokenizer tk = new StringTokenizer(br.readLine());
			int red_price = Integer.parseInt(tk.nextToken());
			int green_price = Integer.parseInt(tk.nextToken());
			int blue_price = Integer.parseInt(tk.nextToken());
			arr[i][0] = red_price;
			arr[i][1] = green_price;
			arr[i][2] = blue_price;
		}
			cost[0][0] = arr[0][0];
			cost[0][1] = arr[0][1];
			cost[0][2] = arr[0][2];
			
			int result = Math.min(paint_cost(nNum-1,0),Math.min(paint_cost(nNum-1,1),paint_cost(nNum-1,2)));		
			System.out.println(result);
			
	}
}
