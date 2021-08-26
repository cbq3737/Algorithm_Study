
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_1859 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tcase = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int t=0;t<tcase;t++) {
			int nNum = Integer.parseInt(br.readLine());
			int[] arr = new int[nNum];
			StringTokenizer tk = new StringTokenizer(br.readLine());
			for(int i=0;i<nNum;i++) {
				arr[i] = Integer.parseInt(tk.nextToken());
			}
			long cnt =0;
			long max = Long.MIN_VALUE;
			long sum =0;
			for(int i=nNum-1;i>=0;i--) {
				int current = arr[i];
				if(max>current) { //비싸게 파는 날
					sum+=(max-current);
				}else {
					max= current; //오늘 가격이 더 커
				}
			}
			
			sb.append("#"+(t+1)+" "+sum+"\n");
		}
		System.out.println(sb);
	}
}
