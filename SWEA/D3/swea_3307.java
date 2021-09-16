import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class swea_3307 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tcase = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int t=0;t<tcase;t++) {
			int nNum = Integer.parseInt(br.readLine());
			int[] LIS = new int[nNum];
			int[] arr = new int[nNum];
			StringTokenizer tk = new StringTokenizer(br.readLine());
			for(int i=0;i<nNum;i++) {
				arr[i] = Integer.parseInt(tk.nextToken());
			}
			int max =0;
			for(int i=0;i<nNum;i++) {
				LIS[i]=1;
				for(int j=0;j<i;j++) {
					if(arr[j]<arr[i]&&LIS[i]<LIS[j]+1) {
						LIS[i] = LIS[j]+1;
					}
				}
				if(max<LIS[i]) {
					max = LIS[i];
				}
			}
			sb.append("#"+(t+1)+" "+max+"\n");
		}
		System.out.println(sb);
	}
}
