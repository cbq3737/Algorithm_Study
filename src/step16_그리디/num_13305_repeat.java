package step16_그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class num_13305_repeat {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int nNum = Integer.parseInt(br.readLine());
		long[] load = new long[nNum-1];
		long[] city = new long[nNum];
		StringTokenizer tk = new StringTokenizer(br.readLine());
		for(int i=0;i<load.length;i++) {
			load[i] =Long.parseLong(tk.nextToken());
		}
		tk = new StringTokenizer(br.readLine());
		for(int i=0;i<city.length;i++) {
			city[i] = Long.parseLong(tk.nextToken());
		}
		int cur = 0;
		int next = cur+1;
		int load_cur=0;
		long pay =0;
		while(next!=nNum) {
			if(city[cur]>city[next]) {
				pay += load[load_cur]*city[cur];
				cur = next;
				load_cur = next;
			}else {
				pay += load[load_cur]*city[cur];
				load_cur+=1;
			}
			next+=1;
		}
		System.out.println(pay);
	}
}
