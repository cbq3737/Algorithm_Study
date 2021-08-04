
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class swea_2805 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());
		for(int i=0;i<tc;i++) {
			int nNum = Integer.parseInt(br.readLine());
			int middle =0;
			int[][] farm = new int[nNum+1][nNum+1];
			for(int j=1;j<=nNum;j++) {
				String str = br.readLine();
				for(int k=1;k<=nNum;k++) {
					farm[j][k] = str.charAt(k-1)-'0';
				}
			}
			if(nNum!= 1) {				
				middle = (nNum/2)+1; 
			}
			int sum =0;
			int cnt_u =1;
			int cnt_d =1;
			for(int f=1;f<=nNum;f++) {
				if(f<=((nNum/2)+1)) {					
					for(int m= middle;m<(nNum/2)+1+cnt_u;m++) {
						sum+= farm[f][m];
					}
					middle -=1;
					cnt_u++;
				}
				else {
					middle+=1;
					for(int m= (middle+1);m<=nNum-cnt_d;m++) {
						sum+=farm[f][m];
					}
					cnt_d++;
				}
			}
			sb.append("#"+(i+1)+" "+sum);
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
