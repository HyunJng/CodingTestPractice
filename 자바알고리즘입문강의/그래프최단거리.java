import java.util.*;
import java.util.stream.*;

public class Main {

	static List<List<Integer>> graph;
	static int[] chk;
	
	public static void BFS(int start) {
		Queue<Integer> q = new LinkedList<>();
		int L = 1;
		q.offer(start);
		chk[start] = -1;
		while(!q.isEmpty()) {
			int len = q.size();
			for(int i = 0; i<len; i++){
				int t = q.poll();
				for(int j : graph.get(t)){
					if(chk[j] == 0) {
						q.offer(j);
						chk[j] = L;
					}
				};
			};
			L++;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		graph = new ArrayList<>();
		
		chk = new int[n + 1];
		IntStream.rangeClosed(0, n).forEach(i -> {
			graph.add(new ArrayList<>());
		});
		
		IntStream.rangeClosed(1, m).forEach(i ->{
			int a = sc.nextInt();
			int b = sc.nextInt();
			graph.get(a).add(b);
		});
		
		BFS(1);
		for(int i = 1; i <= n; i++) {
			if(chk[i] > 0) System.out.println(i + " : " + chk[i]);
		}
	}
}