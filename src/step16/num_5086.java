package step16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class num_5086 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(br.readLine());
		int num1 = Integer.parseInt(tk.nextToken());
		int num2 = Integer.parseInt(tk.nextToken());
		while((num1!=0)&&(num2!=0)) {			
			if((num2>num1)&&(num2 % num1 == 0)) {
				System.out.println("factor");
			}else if((num1>num2)&&(num1 % num2 ==0)) {
				System.out.println("multiple");
			}else {
				System.out.println("neither");
			}
			tk = new StringTokenizer(br.readLine());
			num1 = Integer.parseInt(tk.nextToken());
			num2 = Integer.parseInt(tk.nextToken());
		}
		
	}
}
