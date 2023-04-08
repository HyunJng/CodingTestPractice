import java.util.*;
import java.util.stream.IntStream;

class Node implements Comparable<Node>{
	int node;
	int edge;
	
	Node(int node, int edge){
		this.node = node;
		this.edge = edge;
	}
	
	@Override
	public int compareTo(Node node) {
		return this.edge - node.edge;
	}
	
}
public class Main {
	static ArrayList<ArrayList<Node>> graph;
	static int[] dis;
	static int n, m;
	
	public static void solution(int v) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		
		Node now = new Node(v, 0);
		int nowValue = 0;
		pq.add(now);
		dis[v] = nowValue;
		
		while(!pq.isEmpty()) {
			now = pq.poll();
			nowValue = now.edge;
			
			for(int i = 0; i < graph.get(now.node).size(); i++) {
				Node temp = graph.get(now.node).get(i);
				int tempValue = temp.edge;
				
				if(dis[temp.node] < tempValue) continue;
				if(dis[temp.node] > nowValue + tempValue) {
					pq.offer(new Node(temp.node, nowValue + tempValue));
					dis[temp.node] =  nowValue + tempValue;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		dis = new int[n + 1];
		Arrays.fill(dis, Integer.MAX_VALUE);
		graph = new ArrayList<>();
		for(int i = 0; i<= n; i++) {
			graph.add(new ArrayList<Node>());
		}
		
		for(int i = 0; i < m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			
			graph.get(a).add(new Node(b, c));
		}
		solution(1);
		
		for(int i = 1; i <= n; i++) {
			if(dis[i] != Integer.MAX_VALUE) System.out.println(i + " : " + dis[i]);
			else System.out.println(i + " : Impossible");
		}
	}
}
