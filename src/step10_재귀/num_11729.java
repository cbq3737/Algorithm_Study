package step10_재귀;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class num_11729 {
	public static StringBuilder sb = new StringBuilder();
	public static void hanoi(int nNum,int start,int mid,int end) {
		if(nNum==1) {//맨마지막원판 
			sb.append(start+" "+end+"\n");
			return ;
		}
		else {
	
			hanoi(nNum-1,start,end,mid);//맨처음 n-1개씩 start에서 mid로보냄
			sb.append(start+" "+end+"\n");
			hanoi(nNum-1,mid,start,end);//마지막 mid에 있는 애를 하나씩 end로 보낸다.
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int nNum = Integer.parseInt(br.readLine());
		sb.append((int)(Math.pow(2,nNum)-1)+"\n");
		hanoi(nNum,1,2,3);
		System.out.println(sb);
	}
}
