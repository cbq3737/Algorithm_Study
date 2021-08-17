import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_1493 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());
		
		for(int i=0;i<tc;i++) {
			StringTokenizer tk = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(tk.nextToken());
			int y = Integer.parseInt(tk.nextToken());
			
			int[] p_grid = getGrid(x);
			int[] q_grid = getGrid(y);
			int result = getPoint(p_grid[0]+q_grid[0],p_grid[1]+q_grid[1]);
			sb.append("#"+(i+1)+" "+result+"\n");
		}
		System.out.println(sb);
	}
	public static int getPoint(int x, int y) {
		int sum =0;
		for(int i=1;i<=x;i++) {
			sum+=i;
		}
		for(int i=x;i<(y+x)-1;i++) { 
			sum+=i;
		}
		return sum;
	}
	public static int[] getGrid(int num) {
		int sum =1;
		int cnt =1;
		while(true) {
			if(num<sum) {
				sum -=--cnt;
				break;
			}else if(num==sum) {
				break;
			}
			sum+=cnt++;
		}
		int y = cnt;
		int check= sum;
		int x =1;
		while(true) {
			if(num==check) {
				return new int[] {x,y};
			}
			x++;
			y--;
			check++;
		}
		
	}
}
