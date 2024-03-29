package step_구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class num_20055 {
	public static class kan{
		private boolean exist;//로봇이 존재여부
		private int hp;//내구도
		public kan(boolean exist,int hp) {
			this.exist = exist;
			this.hp = hp;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(br.readLine());
		int nNum = Integer.parseInt(tk.nextToken());
		int kNum = Integer.parseInt(tk.nextToken());
		ArrayList<kan> belt = new ArrayList();
		tk = new StringTokenizer(br.readLine());
		for(int i=0;i<nNum*2;i++) {
			belt.add(new kan(false,Integer.parseInt(tk.nextToken())));
		}
		boolean flag = true;
		int cnt =0;
		while(flag) {
			cnt++;
			//1. 한 칸 이동하기
			kan last = belt.get(belt.size()-1);
			belt.remove(last);
			belt.add(0, last);//맨 앞으로 넣어주기
			if(belt.get(nNum-1).exist) {//내리는 위치에 로봇이 존재한다면
				belt.get(nNum-1).exist = false;//로봇빼주기
			}
			
			//2.벨트가장 먼저 올라간 로봇부터 한칸 이동할 수 있다면 이동하자.그 칸에 로봇이 없고, 내구도가 1이상
			//N번째부터 가까운 
			for(int i=nNum-1;i>0;i--) {
				if(!belt.get(i).exist&&belt.get(i-1).exist&&belt.get(i).hp>=1) {//한 칸 이동하기
					belt.get(i-1).exist = false;//로봇빼주고
					belt.get(i).exist = true;//로봇옮겨주고
					belt.get(i).hp-=1;//내구도 감소
					if(belt.get(nNum-1).exist) {//내리는 위치에 로봇이 존재한다면
						belt.get(nNum-1).exist = false;
					}
				}
			}
			
			//3.로봇올리기, 올리는 칸에 내구도가 0이 아니라면 올리기
			if(belt.get(0).hp>=1) {
				belt.get(0).exist= true;//로봇올려주기
				belt.get(0).hp-=1;//내구도 감소
			}
			
			//4.체크하기
			if(check(belt,kNum)) {//종료시점
				flag = false;
			}
		}
		System.out.println(cnt);
	}
	private static boolean check(ArrayList<kan> belt,int kNum) {
		int cnt =0;
		for(int i=0;i<belt.size();i++) {
			if(belt.get(i).hp==0) {
				++cnt;
			}
		}
		if(cnt>=kNum) { //종료시점
			return true;
		}
		return false;
	}
}
