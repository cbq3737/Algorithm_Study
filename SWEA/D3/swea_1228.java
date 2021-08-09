import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class swea_1228 {
	static int y_num;
	static int x_loc;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for (int t = 0; t < 10; t++) {
			int nNum = Integer.parseInt(br.readLine());	
			List<String> str = new ArrayList<>(nNum);
			StringTokenizer tk = new StringTokenizer(br.readLine());
			
			for (int i = 0; i < nNum; i++) {
				str.add(tk.nextToken());
			}
			int command_num = Integer.parseInt(br.readLine());
			tk= new StringTokenizer(br.readLine());
			for(int i=0;i<command_num;i++) {
				String commad = tk.nextToken();
				x_loc = Integer.parseInt(tk.nextToken());
				y_num = Integer.parseInt(tk.nextToken());
				for(int j=0;j<y_num;j++) {
					str.add(x_loc+j,tk.nextToken());
				}
			}
			sb.append("#"+(t+1)+" ");
			for(int i=0;i<10;i++) {
				sb.append(str.get(i)+" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
