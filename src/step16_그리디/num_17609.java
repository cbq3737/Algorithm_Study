package step15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class num_17609 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int nNum = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < nNum; i++) {
			String str = br.readLine();
			// 팰린드롬 검사
			int left =0;
			int right = str.length()-1;
			if(isPelin(str,left,right)) {
				sb.append("0\n");
				continue;
			}
			if(isSemiPelin(str,left,right)) {
				sb.append("1\n");
			}else {
				sb.append("2\n");
			}
		}
		System.out.println(sb);
	}
	public static boolean isPelin(String str,int left,int right) {
		while(left<=right) {
			if(str.charAt(left)!=str.charAt(right)) {
				return false;
			}
			left+=1;
			right-=1;
		}
		return true;
	}
	public static boolean isSemiPelin(String str,int left,int right) {
	
		while(left<=right) {
			if(str.charAt(left)!=str.charAt(right)) {
				if(!isPelin(str,left+1,right)&&!isPelin(str,left,right-1)) {
					return false;
				}else {
					return true;
				}
			}
			left+=1;
			right-=1;
		}
		return true;
	}
}
