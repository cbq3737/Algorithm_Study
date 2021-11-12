package step15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class num_13305 {
	public static long[] road;
	public static long[] price;
	public static void main(String[] args) throws NumberFormatException, IOException {		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int nNum = Integer.parseInt(br.readLine());
		price = new long[nNum];
		road = new long[nNum-1];
		StringTokenizer tk = new StringTokenizer(br.readLine());
		for(int i=0;i<road.length;i++) {
			road[i] = Long.parseLong(tk.nextToken());
		}
		
		tk = new StringTokenizer(br.readLine());	
		for(int i=0;i<price.length;i++) {
			price[i] = Long.parseLong(tk.nextToken());
		}
		
		long cost = price[0] * road[0];
		int nowcity = 0;
		int nextcity = nowcity+1;
		
		while(nextcity<nNum-1) {
			if(price[nowcity]<price[nextcity]) {
				cost+=price[nowcity]*road[nextcity];
			}else {
				cost+=price[nextcity]*road[nextcity];
				nowcity = nextcity;
			}
			nextcity++;
		}
		System.out.println(cost);
	}
}
