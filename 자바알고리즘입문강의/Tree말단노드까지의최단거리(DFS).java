import java.util.*;
import java.util.stream.*;

class Node{
	int data;
	Node lt;
	Node rt;
	
	Node(int data){
		this.data = data;
		lt = rt = null;
	}
}
public class Main {

	public static int DFS(int L, Node node) {
		if(node.lt == null && node.rt == null) return L;
		int l = DFS(L + 1, node.lt);
		int r = DFS(L + 1, node.rt);
		return Math.min(l, r);
	}
	public static int BFS(Node root) {
		int answer = 0;
		Queue<Node> q = new LinkedList<>();
		q.offer(root);
		while(!q.isEmpty()) {
			int len = q.size();
			for(int i = 0; i<len; i++) {
				Node t = q.poll();
				if(t.lt == null) return ++answer;
				else {
					q.offer(t.lt);
					q.offer(t.rt);
				}
			}
		}
		return answer;
	}

	public static void main(String[] args) {
		Node root = new Node(1);
		root.lt = new Node(2);
		root.rt = new Node(3);
		root.lt.lt = new Node(4);
		root.lt.rt = new Node(5);
		
		System.out.println(DFS(0, root));
	}
}