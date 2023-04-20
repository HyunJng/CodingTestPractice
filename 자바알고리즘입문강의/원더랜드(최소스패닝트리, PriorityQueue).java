import java.util.*;
import java.util.stream.*;

class Edge implements Comparable<Edge>{
	int v;
	int cost;
	
	Edge(int v, int cost){
		this.v = v; this.cost = cost;
	}
	public int compareTo(Edge other) {
		return this.cost - other.cost;
	}
}
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); 
		int v = sc.nextInt();
		int e = sc.nextInt();
		
		int[] check = new int[v + 1];
		List<List<Edge>> graph = new ArrayList<>();

		Arrays.fill(check, 0);
		IntStream.rangeClosed(0, v).forEach(i -> {
			graph.add(new ArrayList<Edge>());
		});
		
		for(int i = 0; i < e ; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			
			graph.get(a).add(new Edge(b, c));
			graph.get(b).add(new Edge(a, c)); // 다익스트라와 달리 양방향이라서
		}
		
		PriorityQueue<Edge> pQ = new PriorityQueue<>();
		pQ.add(new Edge(1, 0));
		
		int sum = 0;
		while(!pQ.isEmpty()) {
			Edge target = pQ.poll();
			int a = target.v;
			if(check[a] == 1) continue;
			else {
				check[a] = 1;
				sum += target.cost;
				
				graph.get(a).stream()
					.filter(i -> (check[i.v] == 0))
					.forEach(i -> pQ.add(i));
			}
		}
		System.out.println(sum);
	}
}