package programmers;

import java.util.Arrays;

public class k_num {
	public static int[] solution(int[] array, int[][] commands) {
			int[] answer = new  int[commands.length];
	        for(int i=0;i<commands.length;i++) {
	        	int[] k_array = Arrays.copyOfRange(array,(commands[i][0]-1), commands[i][1]);
	        	Arrays.sort(k_array);
	        	int numbers = k_array[(commands[i][2]-1)];
	        	answer[i] = numbers;
	        }
	        return answer;
	    }

	public static void main(String[] args) {
		int[] array = { 1, 5, 2, 6, 3, 7, 4 };
		int[][] commands = { { 2, 5, 3 }, { 4, 4, 1 }, { 1, 7, 3 } };
		int[] answer = solution(array, commands);
	}
}
