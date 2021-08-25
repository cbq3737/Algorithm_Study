import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class swea_1251 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tcase = Integer.parseInt(br.readLine());
		StringBuilder sb= new StringBuilder();
		for(int t=0;t<tcase;t++) {
			int nNum = Integer.parseInt(br.readLine());
			int[][] prim = new int[2][nNum];
			double[] minPay = new double[nNum];
			boolean[] visited = new boolean[nNum];
					
			for(int i=0;i<2;i++) {
				StringTokenizer tk = new StringTokenizer(br.readLine());
				for(int j=0;j<nNum;j++) {
				prim[i][j] = Integer.parseInt(tk.nextToken());
				}
			}
			double eNum = Double.parseDouble(br.readLine());
			Arrays.fill(minPay, Double.MAX_VALUE);

			double result = 0;
			minPay[0] = 0;
			
			for(int i=0;i<nNum;i++) {
				double min= Double.MAX_VALUE;
				int minVertex = -1 ;
				for(int j=0;j<nNum;j++) {
					if(!visited[j]&&min>minPay[j]) {
						min=minPay[j];
						minVertex = j;
					}
				}
				if(minVertex==-1) {
					break;
				}
				visited[minVertex] = true;
				result+=min;
				
				for(int j=0;j<nNum;j++) {
					if(!visited[j]&&minPay[j]>(Math.pow(Math.abs(prim[0][minVertex]-prim[0][j]),2)+Math.pow(Math.abs(prim[1][minVertex]-prim[1][j]), 2))*eNum) {
						minPay[j] = (Math.pow(Math.abs(prim[0][minVertex]-prim[0][j]),2)+Math.pow(Math.abs(prim[1][minVertex]-prim[1][j]), 2))*eNum;
					}
				}
			}
			sb.append("#"+(t+1)+" "+((result*10)%10>=5? (long)result+1:(long)result)+"\n");
		}
		System.out.println(sb);
	}
}
