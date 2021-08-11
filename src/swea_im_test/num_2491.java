package swea_im_test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class num_2491 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		int nNum = Integer.parseInt(br.readLine());
		StringTokenizer tk = new StringTokenizer(br.readLine());
		int[] arr = new int[nNum+1];
		for(int i=0;i<nNum;i++) {
			arr[i] = Integer.parseInt(tk.nextToken());
		}
		int max_cnt_asc =0;
		int max_cnt_desc =0;
		int asc =1;
		int desc =1;
		for(int i=1;i<nNum;i++) {
			if(arr[i-1]<=arr[i]) {
				asc++;
				
			}else {
				max_cnt_asc = Math.max(max_cnt_asc, asc);
				asc = 1;
			}
			if(arr[i-1]>=arr[i]) {
				desc++;
			}else {
				max_cnt_desc = Math.max(max_cnt_desc, desc);
				desc =1;
			}
		}
		//루프가 끝나도 남아있을 수 있으므로 
		max_cnt_asc = Math.max(max_cnt_asc, asc);
		max_cnt_desc = Math.max(max_cnt_desc, desc);
		int max_cnt = Math.max(max_cnt_desc, max_cnt_asc);	
		System.out.println(max_cnt);
	}	
}
