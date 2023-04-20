import java.util.*;
import java.util.stream.*;

public class Main {

	static int[][] graph;
	static int n, m, answer = 0;
	static int[] chk;
	
	public static void DFS(int row) {
		if(row == n) {
			answer++;
			return;
		}
		chk[row] = 1;
		
		IntStream.rangeClosed(1, 5).forEach(i -> {
			if(graph[row][i] == 1 && chk[i] != 1) DFS(i);
		});
		
		chk[row] = 0;
		return;
	}
	
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		graph = new int[n + 1][n + 1];
		chk = new int[n + 1];
		
		IntStream.rangeClosed(1, m).forEach( i-> {
			int a = sc.nextInt();
			int b = sc.nextInt();
			graph[a][b] = 1;
		});
		
		DFS(1);
		System.out.println(answer);
	}
}