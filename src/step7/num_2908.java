package step7;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class num_2908 {
	public static int change_num(String num) {
		int newNum = Integer.parseInt(num);
		int hundred = (newNum/10)/10;
		int ten = (newNum/10)%10;
		int one= newNum%10;
		String ch_num = String.valueOf(one)+String.valueOf(ten)+String.valueOf(hundred); 
		return Integer.parseInt(ch_num);
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(br.readLine());
		String aNum = tk.nextToken();
		String bNum = tk.nextToken();
		System.out.println();
		int x_Num = change_num(aNum);
		int y_Num =  change_num(bNum);
		if(x_Num>y_Num) {
			System.out.println(x_Num);
		}
		else {
			System.out.println(y_Num);
		}
	}
}
