package step11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class num_1759 {
	public static char[] carr;
	public static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(br.readLine());
		int lNum = Integer.parseInt(tk.nextToken());
		int cNum = Integer.parseInt(tk.nextToken());
		carr = new char[cNum];
		tk = new StringTokenizer(br.readLine());
		for(int i=0;i<cNum;i++) {
			carr[i] = tk.nextToken().charAt(0); 
		}
		Arrays.sort(carr);
		makeCombi(0,new char[lNum],0);
		System.out.println(sb);
	}
	public static void makeCombi(int isSelect,char[] isSelected,int startIdx) {
		if(isSelect == isSelected.length) {
			if(isCorrect(isSelected)) {
				for(int i=0;i<isSelected.length;i++) {
					sb.append(isSelected[i]);
				}
				sb.append("\n");
			}else {				
				return;
			}
			return;
		}
		
		for(int i=startIdx;i<carr.length;i++) {
			isSelected[isSelect] = carr[i];	
			makeCombi(isSelect+1,isSelected,i+1);
		}
	}
	public static boolean isCorrect(char[] isSelected) {
		int cnt_mo = 0;
		int cnt_ja = 0;
		for(int i=0;i<isSelected.length;i++) {
			if(isSelected[i]=='a' ||isSelected[i]=='e' ||isSelected[i]=='i' ||isSelected[i]=='o' ||isSelected[i]=='u') {
				cnt_mo++;
			}else {
				cnt_ja++;
			}
		}
		if(cnt_mo>=1&&cnt_ja>=2) { //모음 하나 이상, 자음 두개 이상
			return true;
		}
		return false;
	}
}
