package step23;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class num_2251 {//물통
	public static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {//
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(br.readLine());
		int aNum = Integer.parseInt(tk.nextToken());
		int bNum = Integer.parseInt(tk.nextToken());
		int cNum = Integer.parseInt(tk.nextToken());
		int[] arr = new int[3];//물의 실제 양
		arr[2] = cNum;//C번째 물통
		dfs(arr,new boolean[3],2);
	}
	//한 물통이 비거나, 다른 물통이 꽉차거나
	public static void dfs(int[] arr,boolean[] visited,int idx) {
		
		
	}
}
