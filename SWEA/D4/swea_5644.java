import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
class BC{ //기지국 정보
	public int row;
	public int col;
	public int range;
	public int p;
	public BC(int row,int col,int range,int p) {
		this.col = col;
		this.row = row;
		this.range = range;
		this.p = p;
	}
	public int getRow() {
		return row;
	}
	public void setRow(int row) {
		this.row = row;
	}
	public int getCol() {
		return col;
	}
	public void setCol(int col) {
		this.col = col;
	}
	public int getRange() {
		return range;
	}
	public void setRange(int range) {
		this.range = range;
	}
	public int getP() {
		return p;
	}
	public void setP(int p) {
		this.p = p;
	}
}
public class swea_5644 {
	public static int mNum;
	public static List<BC> list;
	public static int maxNum; 
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tcase = Integer.parseInt(br.readLine());
		StringBuilder sb= new StringBuilder();
		for(int t =0;t<tcase;t++) {
			StringTokenizer tk= new StringTokenizer(br.readLine());
			mNum = Integer.parseInt(tk.nextToken());
			int aNum = Integer.parseInt(tk.nextToken());
			int[] user_A = new int[mNum];
			int[] user_B = new int[mNum];
			
			tk = new StringTokenizer(br.readLine());
			for(int i=0;i<mNum;i++) {
				user_A[i] = Integer.parseInt(tk.nextToken());
			}
			tk = new StringTokenizer(br.readLine());
			for(int i=0;i<mNum;i++) {
				user_B[i] = Integer.parseInt(tk.nextToken());
			}		
			list = new ArrayList<>();
			//사용자 정보 받기
			for(int i=0;i<aNum;i++) {
				tk = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(tk.nextToken());
				int y = Integer.parseInt(tk.nextToken());
				int range = Integer.parseInt(tk.nextToken());
				int charge = Integer.parseInt(tk.nextToken());
				list.add(new BC(y-1,x-1,range,charge));
			}
			maxNum = Integer.MIN_VALUE;
			move_check(user_A,user_B);
			sb.append("#"+(t+1)+" "+maxNum+"\n");
		}		
		System.out.println(sb);
	}
	public static void move_check(int[] user_A,int[] user_B) {

		int a_sum =0;
		int b_sum =0;
		int result = 0;
		//첫 스타트 지점 , 0,0 / 9,9
		for(int i=0;i<list.size();i++) {
			BC bc = list.get(i);
			if(Math.abs(bc.getRow()-0)+Math.abs(bc.getCol()-0)<=bc.getRange()) {
				a_sum =Math.max(a_sum, bc.getP());
			}
			if(Math.abs(bc.getRow()-9)+Math.abs(bc.getCol()-9)<=bc.getRange()) {
				b_sum =Math.max(b_sum, bc.getP());
			}
		}
		result = a_sum+b_sum;
		//얘네가 기지국과의 거리가 최솟값인지 판단
		move_User(user_A,user_B,0,0,9,9,result,0); //움직일때마다 판단
	}
	public static void move_User(int[] aMove,int[] bMove,int a_i,int a_j,int b_i,int b_j,int result,int cnt) {
		if(cnt==mNum) {
			maxNum = Math.max(result, maxNum);
			return;
		}
		int[][] deltas = {{0,0},{-1,0},{0,1},{1,0},{0,-1}};
		
		a_i = a_i + deltas[aMove[cnt]][0];
		a_j = a_j + deltas[aMove[cnt]][1];
		b_i = b_i + deltas[bMove[cnt]][0];
		b_j = b_j + deltas[bMove[cnt]][1];
		boolean[] a_boolean = new boolean[list.size()];
		boolean[] b_boolean = new boolean[list.size()];//범위에 속하는지 안속하는지 보는 배열
		
		for(int i=0;i<list.size();i++) {
			int distance_a = Math.abs(list.get(i).getRow()-a_i)+Math.abs(list.get(i).getCol()-a_j);
			int distance_b = Math.abs(list.get(i).getRow()-b_i)+Math.abs(list.get(i).getCol()-b_j);
			if(distance_a<=list.get(i).getRange()) { //범위에 포함될 때
				a_boolean[i] = true;
			}
			if(distance_b<=list.get(i).getRange()) { //범위에 포함될 때
				b_boolean[i] = true;
			}
		}
		int a_sum=0;
		int b_sum=0;
		int temp =0;
        for(int j=0; j<a_boolean.length; j++) { //그냥 싹 다 돌면서 최댓값 찾아줌.
            for(int k=0; k<b_boolean.length; k++) {
                a_sum=0;
                b_sum=0;
                if(a_boolean[j]) {
                    a_sum = list.get(j).getP();
                }
                if(b_boolean[k]) {
                    b_sum = list.get(k).getP();
                }
                if(j==k&&a_boolean[j]&&b_boolean[k]) {
                    a_sum = list.get(j).getP()/2;
                    b_sum = list.get(k).getP()/2;
                }
                temp = Math.max(temp, a_sum+b_sum);
            }
        }
		result+=temp;
		move_User(aMove, bMove, a_i, a_j, b_i, b_j, result, cnt+1);
	} 
}
