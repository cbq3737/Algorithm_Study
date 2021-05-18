package step14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class num_2579 {
	
	public static int[] arr;
	public static Integer[] sum;
	public static int nNum;
//	public static int check_sum(int index) {
//		
//		if(sum[index]==null) {
//			return sum[index] = Math.max(check_sum(index-2), check_sum(index-3)+arr[index-1]) + arr[index];
//		}
//		return sum[index]; 
//	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		nNum = Integer.parseInt(br.readLine());
		arr = new int[nNum+1];
		sum = new Integer[nNum+1];
		for(int i=1;i<nNum+1;i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		sum[0] = arr[0];
		sum[1] = arr[1];
		if(nNum>=2) {
			sum[2] = arr[1]+arr[2];
		}
		for(int i=3;i<(nNum+1);i++) {
			sum[i] = Math.max(sum[i-2],sum[i-3]+arr[i-1])+arr[i];
		}
		//		System.out.println(check_sum(nNum));
		System.out.println(sum[nNum]);
	}
}
