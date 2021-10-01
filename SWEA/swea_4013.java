import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

public class swea_4013 {
	public static List<Integer>[] list = new List[] {new ArrayList<Integer>(),new ArrayList<Integer>(),new ArrayList<Integer>(),new ArrayList<Integer>()};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tcase = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int t=0;t<tcase;t++) {
			int kNum = Integer.parseInt(br.readLine());
			StringTokenizer tk = null;
			for(int i=0;i<4;i++) {//톱니바퀴 정보 넣기
				list[i].clear();//각 톱니바퀴 생성
				tk = new StringTokenizer(br.readLine());
				for(int j=0;j<8;j++) {
					list[i].add(Integer.parseInt(tk.nextToken()));
				}
			}
			for(int i=0;i<kNum;i++) {
				tk = new StringTokenizer(br.readLine());
				int idx = Integer.parseInt(tk.nextToken()); //톱니바퀴 번호
				int direct = Integer.parseInt(tk.nextToken()); //방향
				move(idx,direct,new boolean[4]);
			}
			int sum =0;
			int cnt =1;
			for(int i=0;i<list.length;i++) {
				sum+=list[i].get(0)*cnt;
				cnt*=2;
			}
			sb.append("#"+(t+1)+" "+sum+"\n");
//			System.out.println(Arrays.toString(list));
		}
		System.out.println(sb);
	}
	//dfs처럼 자신과 연결되어있는 애들 모두 검사하는 듯
	public static void move(int idx,int direct,boolean[] visited) {
		if(idx==2||idx==3) {
			visited[idx-1] = true;//나 방문했다.
			if(!visited[idx-2]&&list[idx-2].get(2)!=list[idx-1].get(6)) {//왼쪽이랑 같은지
				move(idx-1,direct*-1,visited);//왼쪽 톱니바퀴 확인
			}
			if(!visited[idx]&&list[idx-1].get(2)!=list[idx].get(6)) {//오른쪽이랑 같은지
				move(idx+1,direct*-1,visited);//오른쪽 톱니바퀴 확인
			}
			if(direct>0) { //시계방향
				list[idx-1].add(0,list[idx-1].get(7));//1번
				list[idx-1].remove(8);
			}else { //반시계방향
				list[idx-1].add(list[idx-1].get(0));//1번
				list[idx-1].remove(0);
			}
		}else if(idx==4) {//맨 오른쪽
			visited[idx-1]= true;
			if(!visited[idx-2]&&list[idx-2].get(2)!=list[idx-1].get(6)) {//왼쪽이랑 같은지
				move(idx-1,direct*-1,visited);//왼쪽 톱니바퀴 확인
			}
			if(direct>0) { //시계방향
				list[idx-1].add(0,list[idx-1].get(7));//1번
				list[idx-1].remove(8);
			}else { //반시계방향
				list[idx-1].add(list[idx-1].get(0));//1번
				list[idx-1].remove(0);
			}			
		}else if(idx==1) {//맨 왼쪽
			visited[idx-1]= true;
			if(!visited[idx]&&list[idx-1].get(2)!=list[idx].get(6)) {//오른쪽이랑 같은지
				move(idx+1,direct*-1,visited);//오른쪽 톱니바퀴 확인
			}
			if(direct>0) { //시계방향
				list[idx-1].add(0,list[idx-1].get(7));//1번
				list[idx-1].remove(8);
			}else { //반시계방향
				list[idx-1].add(list[idx-1].get(0));//1번
				list[idx-1].remove(0);
			}
		}
	}
}
