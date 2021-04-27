package step12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class num_2750 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int nNum = Integer.parseInt(br.readLine());
		int[] arr = new int[nNum];
		for (int i = 0; i < nNum; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		for (int i = 1; i < nNum; i++) {
			int key = arr[i];
			for(int j=(i-1);j>=0;j--) {
				if (arr[j] > key) {
					arr[j + 1] = arr[j];
					arr[j] = key;
				}	
			}
		}
//		for(int i=0;i<nNum;i++) {
//			for(int j=0;j<(nNum-1);j++) {
//				if(arr[j]>arr[j+1]) {
//					int temp = arr[j+1];
//					arr[j+1]= arr[j];
//					arr[j]= temp;
//				}
//			}
//		}
		
		for(int i=0;i<nNum;i++) {
			System.out.println(arr[i]);
		}
	}
}
