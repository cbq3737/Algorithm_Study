package step11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class num_7568 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int nNum = Integer.parseInt(br.readLine());
		int[] xarr = new int[nNum];
		int[] yarr = new int[nNum];
		int[] count = new int[nNum];
		int maxx = -1;
		int maxy = -1;
		for(int i =0;i<nNum;i++) {
			StringTokenizer tk = new StringTokenizer(br.readLine());
			xarr[i] = Integer.parseInt(tk.nextToken());
			yarr[i] = Integer.parseInt(tk.nextToken());
			for(int j=0;j<nNum;j++) {
				if(maxx<xarr[j]) {
					maxx = xarr[j];
				}
				if(maxy<yarr[j]) {
					maxy = yarr[j];
				}
			}
		}
		for(int i=0;i<nNum;i++) {
			count[i]++;
			for(int j=0;j<nNum;j++) {
				if((xarr[i]<xarr[j])&&(yarr[i]<yarr[j])) {
					count[i]++ ;
				}
			}
			sb.append(count[i]+" ");
		}
		System.out.println(sb);
	}
}
