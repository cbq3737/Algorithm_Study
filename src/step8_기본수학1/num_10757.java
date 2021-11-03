package step8_기본수학1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class num_10757 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(br.readLine());
		BigInteger aInt = new BigInteger(tk.nextToken());
		BigInteger bInt = new BigInteger(tk.nextToken());
		System.out.println(aInt.add(bInt));
	}
}
