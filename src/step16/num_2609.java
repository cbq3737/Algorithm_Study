package step16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class num_2609 {
	
	
	public static void main(String[] args) throws IOException {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
	StringTokenizer tk = new StringTokenizer(br.readLine());	
	int left = Integer.parseInt(tk.nextToken());
	int right = Integer.parseInt(tk.nextToken());
	int gcd = gcd(left,right);
	int lcm = (left*right)/gcd;
	
	System.out.println(gcd);
	System.out.println(lcm);
	
	}
	public static int gcd(int left,int right) {
		while(right!=0) {
			int r = left % right;
			left = right;
			right = r;
		}
		return left;
	}
}
