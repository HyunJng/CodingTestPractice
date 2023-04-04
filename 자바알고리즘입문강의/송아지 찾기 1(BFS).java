import java.util.*;
import java.util.stream.IntStream;

public class Main {
	int answer = 0;
	int[] dis = {1, -1, 5};
	int[] chk;
	Queue<Integer> Q= new LinkedList<>();
	
	public int BFS(int s, int e) {
		chk = new int[10001];
		chk[s] = 1;
		Q.offer(s);
		int L = 0;
		
		while(!Q.isEmpty()) {
			int len = Q.size();
			
			for(int j = 0; j < len; j++) {
				int cur = Q.poll();
				for(int i = 0; i< dis.length; i++) {
					int temp = cur + dis[i];
					if(temp == e) {
						answer = L + 1;
						return answer;
					}
					if(temp >= 1 && temp <= 10000 && chk[temp] != 1) {
						chk[temp] = 1;
						Q.offer(temp);
					}
				}
			}
			L++;
		}
		return 0;
	}
	
	public static void main(String[] args) {
		Main T = new Main();
		Scanner sc = new Scanner(System.in);
		int s = sc.nextInt();
		int e = sc.nextInt();
		System.out.println(T.BFS(s, e));
	}
}