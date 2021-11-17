package step18_스택;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class num_10828 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int nNum = Integer.parseInt(br.readLine());
		String command =null;
		int[] arr = new int[nNum];
		int size = 0;
		int x = 0;
		StringBuilder sb = new StringBuilder();
		StringTokenizer tk  = null;
		
		while(nNum>0) {
			tk = new StringTokenizer(br.readLine());
			if(tk.countTokens()>1) {
				command = tk.nextToken();
				 x = Integer.parseInt(tk.nextToken());
			}else {				
				command = tk.nextToken();
			}
			switch(command) {
			
			case "push" :
				arr[size++] = x;
				break;
			case "pop" :
				if(size<1) {
					sb.append(-1);
					sb.append("\n");
				}else {
					sb.append(arr[size-1]);
					sb.append("\n");
					size--;
				}
				break;
			case "size" :
				sb.append(size);
				sb.append("\n");
				break;
			case "empty" :
				if(size==0) {
					sb.append(1);
					sb.append("\n");
				}else {					
					sb.append(0);
					sb.append("\n");
				}
				break;
			case "top" :
				if(size<1) {					
					sb.append(-1);
					sb.append("\n");
				}else {
					sb.append(arr[size-1]);
					sb.append("\n");
				}
				break;
			default :
				break ;
			}	
			nNum--;
		}
		System.out.println(sb.toString());
	}
}
