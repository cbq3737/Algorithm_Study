package jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class jungol_1828 {

	public static void main(String[] args) throws NumberFormatException, IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int nNum = Integer.parseInt(br.readLine());
			int[][] temp = new int[nNum][2];
			for(int i=0;i<nNum;i++) {
				StringTokenizer tk = new StringTokenizer(br.readLine());
				temp[i][0] = Integer.parseInt(tk.nextToken());
				temp[i][1] = Integer.parseInt(tk.nextToken());	
			}
			Arrays.sort(temp,new Comparator<int[]>() {

				@Override
				public int compare(int[] o1, int[] o2) {
					if(o1[1] == o2[1]) { //최고온도가 동일하다면
						return o1[0] - o2[0]; //최저 온도 오름차순
					}else {						
						return o1[1]-o2[1]; //최고온도 오름차순
					}
				}
			});
			int cnt =1;
			int min_y = temp[0][1]; //최고 온도
			for(int i=1;i<temp.length;i++) {
				if(min_y<temp[i][0]) {
					cnt++;
					min_y = temp[i][1];
				}
			}
			System.out.println(cnt);
	}
}
