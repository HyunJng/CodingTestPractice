class Node {
	int data;
	Node lt, rt;
	
	public Node (int data) {
		this.data = data;
		this.lt = this.rt = null;
	}
}

public class Main {
	Node root;
	public void DFS(Node root) {
		Queue<Node> Q = new LinkedList<>();
		Q.offer(root);
		int L = 0;
		while(!Q.isEmpty()) {
			int len = Q.size();
			System.out.print(L + " : ");
			for(int i = 0; i < len; i++) {
				Node cur = Q.poll();
				System.out.print(cur.data + " ");
				if(cur.lt != null) Q.offer(cur.lt);
				if(cur.rt != null) Q.offer(cur.rt);
			}
			System.out.println();	
			L++;
		}
	}
	
	public static void main(String[] args) {
		Main T = new Main();
		T.root = new Node(1);
		T.root.lt = new Node(2);
		T.root.rt = new Node(3);
		T.root.lt.lt = new Node(4);
		T.root.lt.rt = new Node(5);
		T.root.rt.lt = new Node(6);
		T.root.rt.rt = new Node(7);
		T.DFS(T.root);
	}
}