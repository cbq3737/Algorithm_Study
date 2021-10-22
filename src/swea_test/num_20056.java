package swea_test;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class num_20056 {
	public static class Fireball{
		private int r;
		private int c;
		private int m;//질량
		private int s;//속력
		private int d;//방향
		public Fireball(int r,int c,int m,int s,int d) {
			this.r = r;
			this.c = c;
			this.m = m;
			this.s = s;
			this.d = d;
		}
		public int getR() {
			return r;
		}
		public void setR(int r) {
			this.r = r;
		}
		public int getC() {
			return c;
		}
		public void setC(int c) {
			this.c = c;
		}
		public int getM() {
			return m;
		}
		public void setM(int m) {
			this.m = m;
		}
		public int getS() {
			return s;
		}
		public void setS(int s) {
			this.s = s;
		}
		public int getD() {
			return d;
		}
		public void setD(int d) {
			this.d = d;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(br.readLine());
		int nNum = Integer.parseInt(tk.nextToken());
		int mNum = Integer.parseInt(tk.nextToken());//파이어볼
		int kNum = Integer.parseInt(tk.nextToken());//명령 횟수
		int[][] map = new int[nNum][nNum];
		Queue<Fireball> fb = new LinkedList();
		for(int i=0;i<mNum;i++) {
			tk = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(tk.nextToken());
			int c = Integer.parseInt(tk.nextToken());
			int m = Integer.parseInt(tk.nextToken());
			int s = Integer.parseInt(tk.nextToken());
			int d = Integer.parseInt(tk.nextToken());
			fb.offer(new Fireball(r,c,m,s,d));
		}
		
		while(kNum>0) {
			kNum--;
			//1. 모든 파이어볼 이동
			
			//2. 이동 후, 만일 한 칸에 2개이상의 파이어볼이 존재한다면??
				
				//2-1 같은 칸에 있는 파이어 볼 합치기
				//2-2 파이어볼을 4개로 나누기
			
		
		}
	
	}
}
