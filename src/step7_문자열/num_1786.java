package step7_문자열;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class num_1786{
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb =new StringBuilder();
		char[] text = in.readLine().toCharArray();
		char[] pattern = in.readLine().toCharArray();
		
		int tLength = text.length, pLength = pattern.length;
		//make table
		// 부분일치테이블 만들기 : KMP의 아이디어를 똑같이 적용, W에서 W를 찾는 듯한 행위를 해서...
		int[] pi = new int[pLength];
	    for(int i=1, j=0; i<pLength; i++){// i:접미사 포인터(i=1부터 시작: 우리는 부분일치테이블를 만드는게 목적이므로 첫글자 틀리면 0위치로 가야하므로.), 
//	    								j:접두사 포인터
	    	while(j>0 && pattern[i] != pattern[j]) {//일치하지않을때는 새로운 비교 시작위치를 앞으로오면서 맞추는 작업을 해야하므로
	    		j = pi[j-1];
	    	}
	    	
	    	if(pattern[i] == pattern[j]) 
	    		{
	    		System.out.print("pattern[i]"+pattern[i]+" "+"pattern[j]"+pattern[j]);
	    		pi[i] = ++j;
	    		System.out.println();
	    		}	
	    	else pi[i] = 0;
	    }
		
	    //kmp
		int cnt = 0;
		ArrayList<Integer> list = new ArrayList<Integer>();
		// i : 텍스트 포인터 , j: 패턴 포인터 
		for(int i=0,j=0; i<tLength; ++i) { 

			while(j>0 && text[i] != pattern[j]) {//여기서 비교
				j = pi[j-1];
			}
			
			if(text[i] == pattern[j]) {// 두 글자 일치
				if(j == pLength-1) { // 패턴글자 모두일치
					++cnt;
					list.add(i+1-pLength);
					j = pi[j];
				}else {// 패턴 일치 중간 과정(패턴 앞쪽 일치하며 진행중인 상황)
					++j;
				}
			}
		}
		
		sb.append(cnt+"\n");
		if(cnt>0) {
			for(int i=0;i<list.size();i++) {				
				sb.append((list.get(i)+1)+" ");
			}	
		}
		System.out.println(sb);
	}
}