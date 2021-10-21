package step23;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class num_12851 {//숨바꼭질2
		public static int min=Integer.MAX_VALUE;
	public static int cnt;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int nNum = Integer.parseInt(tk.nextToken());
		int xNum = Integer.parseInt(tk.nextToken());
		int[] time = new int[100001];
		Arrays.fill(time, Integer.MAX_VALUE);
		cnt = 0;
		if(nNum>=xNum) {//동생이 앞에 있는 경우
			sb.append(nNum-xNum+"\n");
			sb.append(1+"\n");
		}else {
			bfs(time,nNum,xNum);
			sb.append(time[xNum]+"\n");
			sb.append(cnt+"\n");			
		}
		System.out.println(sb);
	}
	public static void check_num(int[] time,int loc) {
			if(min>time[loc]) {//동일한 방법의 수 찾기
				min = time[loc]; //값이 갱신되면
				cnt =1;		//카운팅 초기화
			}else
				if(min==time[loc]) {
				cnt++;
			}
	}
	public static void bfs(int[] time,int nNum,int xNum) {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(nNum);
		time[nNum] = 0;
		while(!queue.isEmpty()) {
			int loc = queue.poll();
			if(loc+1<time.length) {//앞으로 한걸음 걸어갈때
				if(time[loc+1]>=time[loc]+1) {//크기
					queue.offer(loc+1);
					if(time[loc+1]>time[loc]+1) {//값을 갱신해야하는 경우만						
						time[loc+1] = time[loc]+1;
					}
					if(loc+1==xNum) {//몇번 동일한지
						check_num(time,loc+1);
					}	
				}
			}
			if(loc-1>=0) {//뒤로 한걸을 걸어갈때
				if(time[loc-1]>=time[loc]+1) {
					queue.offer(loc-1);
					if(time[loc-1]>time[loc]+1) {						
						time[loc-1] = time[loc]+1;
					}
					if(loc-1==xNum) {
						check_num(time,loc-1);
					}
				}
			}
			if(loc*2<time.length)//순간이동한 경우
				if(time[loc*2]>=time[loc]+1) {
					queue.offer(loc*2);
					if(time[loc*2]>time[loc]+1) {						
						time[loc*2] = time[loc]+1;
					}
					if(loc*2==xNum) {
						check_num(time,loc*2);
					}
				}
		}
	}
}
