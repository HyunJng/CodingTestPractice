import java.util.*;

public class Main {
	public int solution(int n, int k) {
		Queue<Integer> queue = new LinkedList<>();

		for(int i = 1; i<= n; i++) queue.offer(i);
		
		int cnt = 0;
		while(queue.size() != 1) {
			cnt ++;
			if(cnt == k) {
				queue.poll();
				cnt = 0;
			} else queue.offer(queue.poll());
		}
		
		return queue.poll();
	}	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		Main M = new Main();
		
		System.out.println(M.solution(n, k));
	}
}