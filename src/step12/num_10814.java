package step12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class num_10814 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int nNum = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		String[][] arr = new String[nNum][2];
		for(int i=0;i<nNum;i++) {
			StringTokenizer tk = new StringTokenizer(br.readLine());
			arr[i][0] = tk.nextToken();
			arr[i][1] = tk.nextToken();
		}
		Arrays.sort(arr,new Comparator<String[]>() {
			@Override
			public int compare(String[] e1,String[] e2) {
				int e1_num = Integer.parseInt(e1[0]);
				int e2_num = Integer.parseInt(e2[0]);
				if(e1_num == e2_num) {
					return 0;
				}
				else {
					return e1_num - e2_num;
				}
			}
		});
		
		for(int i=0;i<nNum;i++) {
			sb.append(arr[i][0]+" "+arr[i][1]+"\n");
		}
		System.out.println(sb);
	}
}
