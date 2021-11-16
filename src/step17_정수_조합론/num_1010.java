package step17_정수_조합론;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class num_1010 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int nNum =Integer.parseInt(br.readLine());
		for(int i=0;i<nNum;i++) {
			StringTokenizer tk = new StringTokenizer(br.readLine());
			double n = Double.parseDouble(tk.nextToken());
			double m = Double.parseDouble(tk.nextToken());
			
			double fac = combi(m,n);

			System.out.println(fac);
		}
	}
	
	//4C2 = 4*3/2*1
	public static double combi(double m,double n) {
		double a =1;
		double b= 1;
		for(double i=m;i>m-n;i--) {
			a = a*i;
		}
		for(double i=n;i>0;i--) {
			b = b*i;
		}
		return a/b;
	}
	
}
