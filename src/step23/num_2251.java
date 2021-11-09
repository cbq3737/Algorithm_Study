import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class num_2251 {//물통
	public static StringBuilder sb = new StringBuilder();
	public static boolean[] check = new boolean[201];
	public static int aNum,bNum,cNum;
	public static void main(String[] args) throws IOException {//
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(br.readLine());
		aNum = Integer.parseInt(tk.nextToken());
		bNum = Integer.parseInt(tk.nextToken());
		cNum = Integer.parseInt(tk.nextToken());
		boolean[][][] visited = new boolean[201][201][201];
		Queue<int[]> queue = new LinkedList();
		visited[0][0][cNum]=true;
		queue.offer(new int[] {0,0,cNum});
		bfs(queue,visited);
		for(int i=0;i<check.length;i++) {
			if(check[i]) {
				sb.append(i+" ");
			}
		}
		System.out.println(sb);
	}
	//한 물통이 비거나, 다른 물통이 꽉차거나
	public static void bfs(Queue<int[]> queue,boolean[][][] visited) {
		while(!queue.isEmpty()) {
			int[] arr = queue.poll();
			int a = arr[0];
			int b = arr[1];
			int c = arr[2];
			if(a==0&&!check[c]) {
				check[c]= true;
			}
			//A에서 물을 부을때 
			if(a>0) {
				if(a+b<=bNum) {//B로 다 부을 수 있다면
					if(!visited[0][a+b][c]) {						
						visited[0][a+b][c] = true;
						queue.offer(new int[] {0,a+b,c});
					}
				}else {//B가 넘친다면 B에 보낼수 있을만큼만 보내자
					if(!visited[a+b-bNum][bNum][c]) {
						visited[a+b-bNum][bNum][c]=true;
						queue.offer(new int[] {a+b-bNum,bNum,c});
					}
				}
				if(a+c<=cNum) {//C에 다 부을 수 있다면
					if(!visited[0][b][a+c]) {						
						visited[0][b][a+c]= true;
						queue.offer(new int[] {0,b,a+c});
					}
				}else {//C가 넘친다면 c에 부을 수 있을만큼만 붓자
					if(!visited[a+c-cNum][b][cNum]) {
						visited[a+c-cNum][b][cNum]= true;
						queue.offer(new int[] {a+c-cNum,b,cNum});
					}
				}
			}
			//B에서 물을 부을때
			if(b>0) {
				if(a+b<=aNum) {//A에 물을 다 부을 수 있다면
					if(!visited[a+b][0][c]) {						
						visited[a+b][0][c]=true;
						queue.offer(new int[] {a+b,0,c});
					}
				}else {//A에 물이 넘친다면
					if(!visited[aNum][a+b-aNum][c]) {						
						visited[aNum][a+b-aNum][c]=true;
						queue.offer(new int[] {aNum,a+b-aNum,c});
					}
				}
				if(b+c<=cNum) {//C에 다 부을 수 있다면
					if(!visited[a][0][b+c]) {						
						visited[a][0][b+c]=true;
						queue.offer(new int[] {a,0,b+c});
					}
				}else {//C에 물이 넘친다면
					if(!visited[a][b+c-cNum][cNum]) {						
						visited[a][b+c-cNum][cNum]=true;
						queue.offer(new int[] {a,b+c-cNum,cNum});
					}
				}
			}
			//C에서 물을 부을때
			if(c>0) {
				if(a+c<=aNum) {//A에 물을 다 부을 수 있다면
					if(!visited[a+c][b][0]) {
						visited[a+c][b][0]=true;
						queue.offer(new int[] {a+c,b,0});						
					}
				}else {//A에 물이 넘친다면
					if(!visited[aNum][b][a+c-aNum]) {						
						visited[aNum][b][a+c-aNum]=true;
						queue.offer(new int[] {aNum,b,a+c-aNum});
					}
				}
				if(b+c<=bNum) {//B에 다 부을 수 있다면
					if(!visited[a][b+c][0]) {						
						visited[a][b+c][0]=true;
						queue.offer(new int[] {a,b+c,0});
					}
				}else {//B에 물이 넘친다면
					if(!visited[a][bNum][b+c-bNum]) {
						visited[a][bNum][b+c-bNum]=true;
						queue.offer(new int[] {a,bNum,b+c-bNum});						
					}
				}
			}
		}
	}
}
