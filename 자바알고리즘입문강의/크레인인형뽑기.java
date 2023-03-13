package Main;
import java.util.*;

public class Main {
	
	public static int solution(int n, int[][] board, int m, int[] moves) {
		int answer = 0;
		Stack<Integer> stack = new Stack<>();
		
		for(int x : moves) {
			// 넣을거 집기
			int temp = 0, target = 0;
			
			while(temp < n) {
				if(board[temp][x - 1] != 0) {
					target = board[temp][x - 1];
					board[temp][x - 1] = 0;
					break;
				}
				temp++;
			}
			
			if(target == 0) continue;
			
			// 스택의 값과 같으면 pop + answer++
			if(!stack.isEmpty() && stack.peek() == target) {
				stack.pop();
				answer += 2;
			}
			// 아니면 push
			else stack.push(target);
		}
		
		return answer;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int[][] board = new int[n][n];
		
		for(int i = 0; i< n; i++)
			for(int j = 0; j< n; j++)
				board[i][j] = sc.nextInt();
		int m = sc.nextInt();
		int[] moves = new int[m];
		for(int i = 0; i< m; i++)
			moves[i] = sc.nextInt();
		
		System.out.println(Main.solution(n, board, m, moves));
	}
}