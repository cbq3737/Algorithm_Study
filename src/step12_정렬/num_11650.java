package step12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class num_11650 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int nNum = Integer.parseInt(br.readLine());
		int[][] arr = new int[nNum][2];
		//2차원 배열과 람다식을 이용
		for (int i = 0; i < nNum; i++) {
			StringTokenizer tk = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(tk.nextToken());
			arr[i][1] = Integer.parseInt(tk.nextToken());
		}
		

		Arrays.sort(arr,new Comparator<int[]>() {
			@Override
			public int compare(int[] e1,int[] e2) {
				if(e1[0] == e2[0]) {
					return e1[1] - e2[1];
				}
				else {
					return e1[0] - e2[0];
				}
			}
		});
		
		for(int i=0;i<nNum;i++) {
			System.out.println(arr[i][0]+" "+arr[i][1]);
		}
	}
}
