package swea_test;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class num_2477 {
	//긴 거 바로 전인지 바로 앞일지 모른다
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int kNum = Integer.parseInt(br.readLine());
		int[] arr = new int[6];
		int max = 0;
		
		for(int i=0;i<6;i++) {
			StringTokenizer tk= new StringTokenizer(br.readLine());
			tk.nextToken();
			arr[i] = Integer.parseInt(tk.nextToken());
		}
		int sum =-1;
		int small =-1;
		for(int i=0;i<arr.length;i++) {
			max = arr[i]*arr[(i+1)%6];
			if(max>=sum) {
				sum = Math.max(max, sum);
				small = arr[(i+3)%6]*arr[(i+4)%6];
			}
		}
		
		System.out.println((sum-small)*kNum);
		
	}
}
