import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class swea_4012 {
	public static int[][] grid;
	public static int min;
	public static int nNum;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb= new StringBuilder();
		int tcase = Integer.parseInt(br.readLine());
		for(int t=0;t<tcase;t++) {
			nNum = Integer.parseInt(br.readLine());
			grid = new int[nNum][nNum];
			for(int i=0;i<nNum;i++) {
				StringTokenizer tk = new StringTokenizer(br.readLine());
				for(int j=0;j<nNum;j++) {
					grid[i][j]= Integer.parseInt(tk.nextToken());					
				}
			}
			min =Integer.MAX_VALUE;
			makeCombi(0,new int[nNum/2],0);
			sb.append("#"+(t+1)+" "+min+"\n");
		}
		System.out.println(sb);
	}
	public static void makeCombi(int isSelect,int[] isSelected,int startIdx) {
		if(isSelect==isSelected.length) {
			int is =0;
			int t =0;
			int[] remain = new int[nNum/2];
			for(int i=0;i<nNum;i++) {
				if(is<isSelected.length && i==isSelected[is]) {
					is++;
				}else {
					remain[t++] = i; 
				}
			}
			int food1 = 0;	
			int food2 = 0;

			for(int i=0;i<isSelected.length;i++) {
				for(int j=0;j<isSelected.length;j++) {
					food1 += grid[isSelected[i]][isSelected[j]];
				}
			}
			for(int i=0;i<isSelected.length;i++) {
				for(int j=0;j<isSelected.length;j++) {
					food2 += grid[remain[i]][remain[j]];
				}
			}
			min = Math.min(min, Math.abs(food1-food2));
			return;
		}
		
		for(int i=startIdx;i<grid.length;i++) {
			isSelected[isSelect] = i;
			makeCombi(isSelect+1,isSelected,i+1);
		}
	}
}
