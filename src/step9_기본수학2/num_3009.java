package step9_기본수학2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class num_3009 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(br.readLine());
		int[] arr = {Integer.parseInt(tk.nextToken()),Integer.parseInt(tk.nextToken())};
		tk = new StringTokenizer(br.readLine());
		int[] brr = {Integer.parseInt(tk.nextToken()),Integer.parseInt(tk.nextToken())};
		tk = new StringTokenizer(br.readLine());
		int[] crr = {Integer.parseInt(tk.nextToken()),Integer.parseInt(tk.nextToken())};
		int x=0;int y=0;
		if(arr[0]==brr[0]) {
			x=crr[0];
		}
		else if(arr[0]==crr[0]) {
			x = brr[0];
		}
		else {
			x = arr[0];
		}
		
		if(arr[1]==brr[1]) {
			y=crr[1];
		}
		else if(arr[1]==crr[1]) {
			y = brr[1];
		}
		else  {
			y = arr[1];
		}
		System.out.println(x+" "+y);
	}
}
