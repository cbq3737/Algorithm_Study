package step10_재귀;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class num_2477_1 {
	static char[][] array;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		array = new char[N][N];
		for (int i = 0; i < N; i++) {
			Arrays.fill(array[i], ' ');
		}
		MyStack(N, 0, 0);
		for (int i = 0; i < N; i++) {
			bw.write(array[i]);
			bw.write("\n");
		}
		bw.flush();
		bw.close();
	}

	public static void MyStack(int k, int row, int col) {
		if (k == 1) { //제일 작은 단위
			array[row][col] = '*';
			return;
		}
		for (int i = 0; i <= 2; i++) {
			for (int j = 0; j <= 2; j++) {
				if (i * j == 1)
					continue;
				MyStack(k / 3, row * 3 + i, col * 3 + j);
			}
		}
	}
}
