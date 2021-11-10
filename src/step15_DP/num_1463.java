package step15_DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class num_1463 {
	public static Integer[] arr;
	public static int check_num(int num) {
		if(num == 1) {
			return 0;
		}
		if(arr[num]!=null) { //n값이 존재한다면 -> 메모이제이션
			return arr[num];
		}
		arr[num] = check_num(num-1)+1;
		if(num %3 == 0) {
			int temp = check_num(num/3)+1;
			if(arr[num] > temp) {
				arr[num] = temp;
			}
		}
		if(num %2 == 0) {
			int temp = check_num(num/2)+1;
			if(arr[num]>temp) {
				arr[num] = temp;
			}
		}
		return arr[num];
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		int nNum = Integer.parseInt(br.readLine());
		arr = new Integer[nNum+1];

		System.out.println(check_num(nNum));
	}
}
