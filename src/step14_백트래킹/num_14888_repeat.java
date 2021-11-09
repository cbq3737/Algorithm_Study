package step14_백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class num_14888_repeat {
	public static int nNum;
	public static int[] arr;
	public static int[] operator;
	public static StringTokenizer tk;
	public static int max = Integer.MIN_VALUE;
	public static int min = Integer.MAX_VALUE;
	public static void combi(int result, int depth) {
		if (depth == nNum) {
			max = Math.max(max, result);
			min = Math.min(min, result);
			return;
		}
		for (int i = 0; i < 4; i++) {
			if (operator[i] > 0) {
				if (i == 0) {
					operator[i]--;
					combi(result + arr[depth], depth + 1);
					operator[i]++;
				} else if (i == 1) {
					operator[i]--;
					combi(result - arr[depth], depth + 1);
					operator[i]++;
				} else if (i == 2) {
					operator[i]--;
					combi(result * arr[depth], depth + 1);
					operator[i]++;
				} else if (i == 3) {
					operator[i]--;
					combi(result / arr[depth], depth + 1);
					operator[i]++;
				}
			}
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		nNum = Integer.parseInt(br.readLine());
		tk = new StringTokenizer(br.readLine());
		arr = new int[nNum];
		for (int i = 0; i < nNum; i++) {
			arr[i] = Integer.parseInt(tk.nextToken());
		}
		operator = new int[4];
		tk = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++) {
			operator[i] = Integer.parseInt(tk.nextToken());
		}
		combi(arr[0], 1);
		System.out.println(max);
		System.out.println(min);
	}
}