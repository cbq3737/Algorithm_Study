package step16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//D1-2072 --홀수만 구하기
public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int nNum = Integer.parseInt(br.readLine());
		int[] arr = new int[10];
		int[] sum = new int[nNum];
		for(int i=0;i<nNum;i++) {
			StringTokenizer tk= new StringTokenizer(br.readLine());
			for(int j=0;j<10;j++) {				
				arr[j] = Integer.parseInt(tk.nextToken());
				if(arr[j]%2 !=0) {					
					sum[i] +=arr[j];
				}
			}
		}
		for(int i=0;i<nNum;i++) {
			System.out.println("#"+(i+1)+" "+sum[i]);
		}
		
	}
}
