import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class swea_1233 {
	public static boolean flag;
	public static Queue<Integer> queue = new LinkedList<Integer>();
	public static void dfs(String[] str,int idx,String element) {
		
		if(str[idx].equals("+")||str[idx].equals("-")||str[idx].equals("*")||str[idx].equals("/")) {
			if(idx*2>str.length-1 && idx*2+1>str.length-1) {
				flag = true;
				return;
			}
		}
		
		if(idx*2<=str.length-1) {//왼쪽 친구
			dfs(str,idx*2,str[idx]);
		}
		
		if(idx*2+1<=str.length-1) {//오른쪽 친구
			dfs(str,idx*2+1,str[idx]);
		}
		
	}
	public static void bfs(String[] str,int idx) {
		queue.offer(1);
		while(!queue.isEmpty()) {
			int current = queue.poll();
			
			if(str[current].equals("-")||str[current].equals("-")||str[current].equals("*")||str[current].equals("/")) {
				if(current*2>str.length-1 && current*2+1>str.length-1) {
					flag= true;
					queue.clear();
					break;
				}
			}
			if(current*2<=str.length-1) {
				queue.offer(current*2);
			}
			if(current*2+1<=str.length-1) {
				queue.offer(current*2+1);
			}			
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int t=0;t<10;t++) {
			int num = Integer.parseInt(br.readLine());
			String[] str = new String[num+1];
			
			while(num-->0) {
				StringTokenizer tk = new StringTokenizer(br.readLine());
				int idx = Integer.parseInt(tk.nextToken());
				str[idx] = tk.nextToken(); //내가 갖고있는 것.
			}
			flag= false;
//			dfs(str,1,null);
			
			bfs(str,1);
			if(!flag) {
				System.out.println("#"+(t+1)+" "+1);
			}else {
				System.out.println("#"+(t+1)+" "+0);
			}
		}
	}
}
