import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class swea_8458 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tcase = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int t=0;t<tcase;t++) {
			int nNum = Integer.parseInt(br.readLine());
			int[] arr = new int[nNum];
			int max = -1; //원점으로부터 제일 먼 거리
			int answer =0;
			for(int i=0;i<nNum;i++) {
				StringTokenizer tk = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(tk.nextToken());
				int y = Integer.parseInt(tk.nextToken());
				arr[i] = Math.abs(x)+Math.abs(y);//원점까지 거리
				if(max<arr[i]) { //
					max = arr[i]; //최대 거리값
				}
			}
			//홀수 인지 짝수인지 판단 ->어떤 점이라도 모두 동일하지않으면 다른점들 모두 원점에 도착해도 다른 점만 혼자 원점으로 못옴
			for(int i=1;i<nNum;i++) {
				if(arr[i]%2!=arr[i-1]%2) {
					answer = -1;
				}
			}
			
			//제일 멀리 있는 점이 와야지 모두 원점으로 들어오는 것. 
			int cnt=0;
			if(answer==0) { //홀수 짝수 모두 동일하고				
				while(true) {
					if(cnt>=max&&(max-cnt)%2==0) {
						break;
					}
					cnt+=++answer;
				}
			}
			sb.append("#"+(t+1)+" "+answer+" "+"\n");
		}
		System.out.println(sb);
	}
}
