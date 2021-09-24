package swea_test;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class num_18111 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(br.readLine());
		int nNum = Integer.parseInt(tk.nextToken());
		int mNum = Integer.parseInt(tk.nextToken());
		int bNum = Integer.parseInt(tk.nextToken());
		int[][] map = new int[nNum][mNum];
		Queue<Integer> queue = new LinkedList<>();
		
		for(int i=0;i<nNum;i++) {
			tk = new StringTokenizer(br.readLine());
			for(int j=0;j<mNum;j++) {
				map[i][j] = Integer.parseInt(tk.nextToken());
			}
		}
		
		
		
		
	}
}
