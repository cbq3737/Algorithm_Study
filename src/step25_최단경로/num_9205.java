package step25_최단경로;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class num_9205 {
	public static int INF = 987654321;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int tcase = 0; tcase<t;tcase++) {
			int nNum = Integer.parseInt(br.readLine());
			int[][] arr = new int[nNum+2][nNum+2];
			int[][] dis = new int[nNum+2][2];
			StringTokenizer tk = new StringTokenizer(br.readLine());
			int hx=Integer.parseInt(tk.nextToken());
			int hy= Integer.parseInt(tk.nextToken());
			int idx =0;
			dis[idx][0] = hx;
			dis[idx][1] = hy;
			idx++;
			for(int i=0;i<nNum;i++) {
				tk = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(tk.nextToken());
				int y = Integer.parseInt(tk.nextToken());
				dis[idx][0]= x;
				dis[idx][1] =y;
				idx++;
			}
			tk = new StringTokenizer(br.readLine());
			int rockx = Integer.parseInt(tk.nextToken());
			int rocky = Integer.parseInt(tk.nextToken());
			dis[idx][0] = rockx;
			dis[idx][1] = rocky;
			idx++;
			for(int i=0;i<dis.length;i++) {  //얘가1000<= 맥주 한박스로 갌으로 있는 애들 이은거.
				for(int j=0;j<dis.length;j++) {
					if(Math.abs(dis[i][0]-dis[j][0])+Math.abs(dis[i][1]-dis[j][1])<=1000) {						
						arr[i][j] = Math.abs(dis[i][0]-dis[j][0])+Math.abs(dis[i][1]-dis[j][1]);
					}
					else {
						arr[i][j] = INF;
					}
				} 
			}
			for(int k=0;k<nNum+2;k++) { //이은애들끼리 어떻게 든 해서 갈때 비용.  
				for(int i=0;i<nNum+2;i++) {
					if(i==k) {
						continue;
					}
					for(int j=0;j<nNum+2;j++) {	
						if(j==k) {
							continue;
						}
						arr[i][j] = Math.min(arr[i][k]+arr[k][j], arr[i][j]);
					}
				}
			}
			//락페를 갈수있냐없냐 -> 락페를 어떻게든 가면 INF값이 아닌거고, 
			if(arr[0][nNum+1]==INF||arr[nNum+1][0]==INF) {
				sb.append("sad"+"\n");
			}else {
				sb.append("happy"+"\n");
			}
		}
		System.out.println(sb);
	}
}
