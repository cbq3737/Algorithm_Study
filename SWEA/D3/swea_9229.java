import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_9229 {
	static int[] arr;
	static int max;
	public static void make_snack(int toSelect,int[] selected,int startIdx,int mNum) {
		if(toSelect==2) {
			if((selected[0]+selected[1]>max) && (selected[0]+selected[1]<=mNum)) {
				max = Math.max(max, selected[0]+selected[1]);
			}
			return;
		}
		for(int i=startIdx;i<arr.length;i++) {
			selected[toSelect] = arr[i];
			make_snack(toSelect+1,selected,i+1,mNum);
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int t=0;t<tc;t++) {
			StringTokenizer tk = new StringTokenizer(br.readLine());
			int nNum = Integer.parseInt(tk.nextToken());
			int mNum = Integer.parseInt(tk.nextToken());
			arr = new int[nNum];
			tk = new StringTokenizer(br.readLine());
			for(int i=0;i<nNum;i++) {
				arr[i] = Integer.parseInt(tk.nextToken());
			}
			max = -1;
			make_snack(0,new int[2],0,mNum);
			sb.append("#"+(t+1)+" "+max+"\n");
		}
		System.out.println(sb);
	}
}
