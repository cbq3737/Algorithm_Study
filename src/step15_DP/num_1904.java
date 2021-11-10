package step15_DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class num_1904 {
	public static Integer[] arr;
	public static int count;
	public static int check_array(int i) {
		if(arr[i]==null) {
			return arr[i]= (check_array(i-1) + check_array(i-2))%15746;
		}
		return arr[i];
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int nNum = Integer.parseInt(br.readLine());
		arr = new Integer[1000001];
	
		arr[0] = 0;
		arr[1] = 1;
		arr[2] = 2;
		
		System.out.println(check_array(nNum));
	}
}
