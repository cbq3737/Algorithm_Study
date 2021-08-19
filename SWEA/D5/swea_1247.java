import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class swea_1247 {
	public static int[][] customer;
	public static int min;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb= new StringBuilder();
		int tcase = Integer.parseInt(br.readLine());
		for(int t=0;t<tcase;t++) {
			int nNum = Integer.parseInt(br.readLine());
			customer = new int[nNum][2];
			StringTokenizer tk = new StringTokenizer(br.readLine());
			int c_r = Integer.parseInt(tk.nextToken());
			int c_c = Integer.parseInt(tk.nextToken());
			int h_r = Integer.parseInt(tk.nextToken());
			int h_c = Integer.parseInt(tk.nextToken());
			for(int i=0;i<nNum;i++) {
				customer[i][0] = Integer.parseInt(tk.nextToken());
				customer[i][1] = Integer.parseInt(tk.nextToken());
			}
			min = Integer.MAX_VALUE;
			makePerputation(0,new int[nNum],new boolean[nNum],c_r,c_c,h_r,h_c);
			sb.append("#"+(t+1)+" "+ min+"\n");
		}
		System.out.println(sb);
	}
	public static void makePerputation(int isSelect,int[] selected,boolean[] visited,int c_r,int c_c,int h_r,int h_c) {
		if(isSelect == selected.length) {
			int dist= Math.abs(c_r-(customer[selected[0]][0]))+Math.abs(c_c-customer[selected[0]][1]);
			for(int i=1;i<selected.length;i++) {
				dist+= Math.abs(customer[selected[i]][0]-customer[selected[i-1]][0])+Math.abs(customer[selected[i]][1]-customer[selected[i-1]][1]);
			}
			dist += Math.abs(h_r-(customer[selected[selected.length-1]][0]))+Math.abs(h_c-customer[selected[selected.length-1]][1]);
			min = Math.min(min, dist);
			return;
		}
		for(int i=0;i<customer.length;i++) {
			if(!visited[i]) {
				selected[isSelect] = i;
				visited[i] = true;
				makePerputation(isSelect+1, selected, visited, c_r, c_c, h_r, h_c);
				visited[i] = false;
			}
		}
	}
}
