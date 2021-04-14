package step9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class num_3053 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int rNum=Integer.parseInt(br.readLine());
		System.out.println(String.format("%.6f", Math.pow(rNum,2)*Math.PI));
		System.out.println(String.format("%.6f", Math.pow(rNum,2)*2));
	}
}
