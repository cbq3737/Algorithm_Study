import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_1940 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for(int i=0;i<tc;i++) {
			int nNum = Integer.parseInt(br.readLine());
			int v =0;//속도
			int move=0;//거리
			for(int j=0;j<nNum;j++) {
				StringTokenizer tk = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(tk.nextToken());
				if(a==1) {
					int b = Integer.parseInt(tk.nextToken());
					v=v+b;
				}else if(a==2) {
					int b = Integer.parseInt(tk.nextToken());
					v= v-b;		
					if(v<0) {
						v=0;
					}
				}else if(a==0) {
				}
				move=move+v;
			}
			System.out.println("#"+(i+1)+" "+move);
		}
	}

}
