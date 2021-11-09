package step14_백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class num_14888 {
	public static int[] operator = new int[4];
	public static int min = Integer.MAX_VALUE;
	public static int max = Integer.MIN_VALUE;
	public static void num_check(int[] arr, int result, int num) {
		if (num == arr.length) {
			max = Math.max(max, result);
			min = Math.min(min, result);
			return;
		}
		for (int j = 0; j < 4; j++) {
			if (operator[j] > 0) {
				if (j == 0) {
					operator[j]--;
					result += arr[num];
					num_check(arr, result, num + 1);
					result -= arr[num];
					operator[j]++;
				} else if (j == 1) {
					operator[j]--;
					result -= arr[num];
					num_check(arr, result, num + 1);
					result += arr[num];
					operator[j]++;

				} else if (j == 2) {
					operator[j]--;
					result *= arr[num];
					num_check(arr, result, num + 1);
					result /= arr[num];
					operator[j]++;
				} else if (j == 3) {
					operator[j]--;
					result /= arr[num];
					num_check(arr, result, num + 1);
					result = (result * arr[num]) +((result % arr[num])*-1);
					operator[j]++;
				}

			}
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int nNum = Integer.parseInt(br.readLine());
		int[] arr = new int[nNum];
		StringTokenizer tk = new StringTokenizer(br.readLine());

		for (int i = 0; i < nNum; i++) {
			arr[i] = Integer.parseInt(tk.nextToken());
		}
		StringTokenizer tk1 = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++) {
			operator[i] = Integer.parseInt(tk1.nextToken());
		}
		num_check(arr, arr[0], 1);
		System.out.println(max);
		System.out.println(min);
	}
}
