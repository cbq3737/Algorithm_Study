package step12_정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class num_11651 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int nNum = Integer.parseInt(br.readLine());
		StringBuilder sb= new StringBuilder();
		
		int[][] arr = new int[nNum][2];
		for(int i=0;i<nNum;i++) {
			StringTokenizer tk = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(tk.nextToken());
			arr[i][1] = Integer.parseInt(tk.nextToken());
		}
		Arrays.sort(arr,new Comparator<int[]>() {
			@Override
			public int compare(int[] e1,int[] e2) {
				if(e1[1]==e2[1]) {
					return e1[0] - e2[0];
				}
				else {
					return e1[1] - e2[1];
				}
			}
		});
		for(int i=0;i<nNum;i++) {
			sb.append(arr[i][0]+" "+arr[i][1]+"\n");
		}
		System.out.println(sb);
	}
}
