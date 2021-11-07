package step11;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class num_2961 {
	public static int min;
	public static void powerSet(int cnt,int[][] ingredient,boolean[] visited) {
		if(cnt==ingredient.length) {
			int s_mat = 1;
			int b_mat =0;
			for(int i=0;i<ingredient.length;i++) {
				if(visited[i]) {
					s_mat*=ingredient[i][0];
					b_mat+=ingredient[i][1];
					int sub = Math.abs(s_mat-b_mat);
					min = Math.min(sub, min);
				}
			}
			return;
		}
		visited[cnt]=true;
		powerSet(cnt+1, ingredient,visited);
		visited[cnt]=false;  //이게 없으면 그냥 쭉 더해졋다가 아예 쭉 내려와버림, 다시 들어와서 두번재를 고르는게 아님
		powerSet(cnt+1, ingredient,visited);
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int nNum = Integer.parseInt(br.readLine());
		int[][] ingredient = new int[nNum][2];
		for(int i=0;i<nNum;i++) {
			StringTokenizer tk = new StringTokenizer(br.readLine());
			ingredient[i][0] = Integer.parseInt(tk.nextToken());
			ingredient[i][1] = Integer.parseInt(tk.nextToken());
		}
		min =Integer.MAX_VALUE;
			
		powerSet(0,ingredient,new boolean[nNum]);
		System.out.println(min);
	}
}
