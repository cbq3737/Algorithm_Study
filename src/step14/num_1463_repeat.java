package step14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class num_1463_repeat {
	public static int[] arr;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int nNum = Integer.parseInt(br.readLine());
		arr = new int[nNum+1];
		arr[0] = 0;
		arr[1] = 0;
		for(int i=2;i<nNum+1;i++) {
			arr[i] = arr[i-1]+1;//-1
			if(i%3==0) {
				arr[i] = Math.min(arr[i/3]+1, arr[i]);
			} 
			if(i%2==0) {
				arr[i] = Math.min(arr[i/2]+1, arr[i]);
			}
		}
		System.out.println(arr[nNum]);
	}
}
