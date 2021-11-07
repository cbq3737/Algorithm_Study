package step11_브루트포스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class num_2798 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(br.readLine());
		int nNum = Integer.parseInt(tk.nextToken());
		int mNum = Integer.parseInt(tk.nextToken());
		int[] arr = new int[nNum];
		tk = new StringTokenizer(br.readLine());
		for(int i=0;i<(arr.length);i++) {
			arr[i]= Integer.parseInt(tk.nextToken());
		}
		boolean brun = true;
		int hap = 0;
		while(brun) {
			for(int i=0;i<nNum;i++) {
				for(int j=(i+1);j<nNum;j++) {
					for(int k=(j+1);k<nNum;k++) {
						if((mNum-arr[i])==(arr[j]+arr[k])) {
							hap = arr[i]+arr[j]+arr[k];
							brun = false;
						}
					}
				}
			}
			mNum--;
		}
		System.out.println(hap);
		
	}
}
