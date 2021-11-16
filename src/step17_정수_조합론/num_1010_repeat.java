package step17_정수_조합론;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class num_1010_repeat {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tcase = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int t=0;t<tcase;t++) {
			StringTokenizer tk= new StringTokenizer(br.readLine());
			int nNum = Integer.parseInt(tk.nextToken());
			int mNum = Integer.parseInt(tk.nextToken());
//			double cnt =makeCombi(mNum,nNum) ;
			
			sb.append(makeCombi(mNum,nNum)+"\n");
		}
		System.out.println(sb);
	}
	//7C4 = 7*6*5 / 4*3*2*1
	public static String makeCombi(int mNum,int nNum) {
		double a = 1;
		double b = 1;
		for(int i=mNum;i>mNum-nNum;i--) {
			a*= i;
		}
		for(int i=1;i<=nNum;i++) {
			b*= i;
		}
		return String.format("%.0f",a/b); //long형은 문제가 많다. double형으로 출력
	}
}
