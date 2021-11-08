package step12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class num_2108 {

	public static void num_avg(int[] arr, int nNum) {
		double sum = 0;
		for (int i = 0; i < nNum; i++) {
			sum += arr[i];
		}
		System.out.println((int)Math.round(sum / nNum));
	}

	public static void num_center(int[] arr, int nNum) {
		int mid = (nNum / 2);
		int[] new_arr = new int[nNum];
		for (int i = 0; i < nNum; i++) {
			new_arr[i] = arr[i];
		}
		Arrays.sort(new_arr);
		System.out.println(new_arr[mid]);
	}

	public static void num_count(int[] arr, int nNum) {
		int[] check = new int[8001];
		int max = 1;
		for (int i = 0; i < nNum; i++) {
			int num = arr[i];
			check[4000 + num]++;
			if (max < check[4000 + num]) {
				max = check[4000 + num]; // 카운팅
			}
		}
		
		int max_count = 0;
		int num_count = 0;
		int second_min = 0;
		for (int i = 0; i < 8001; i++) {
			if (max == check[i]) { 
				max_count++;	
				num_count = i - 4000;
				if(max_count==2) {
					second_min= i-4000;
				}
			}
		}
		
		if (max_count == 1) { //최빈값이 1개 일 시 
			System.out.println(num_count);
		} 
		else { //최빈값이 여러개일 시 
			System.out.println(second_min);
		}
	}

	public static void num_scope(int[] arr,int nNum) {
		int min = arr[0];int max = arr[0];
		for(int i=0;i<nNum;i++) {
			if(min>arr[i]) {
				min = arr[i];
			}
			if(max<arr[i]) {
				max = arr[i];
			}
		}
		System.out.println(max - min);
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int nNum = Integer.parseInt(br.readLine());
		int[] arr = new int[nNum];
		for (int i = 0; i < nNum; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		num_avg(arr, nNum);
		num_center(arr, nNum);
		num_count(arr, nNum);
		num_scope(arr,nNum);
	}
}
