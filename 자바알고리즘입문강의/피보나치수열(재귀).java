public class Main {
	static int[] fibo;
	public int DFS(int n) { // N번째 항을 구하는 메서드
		if(fibo[n] != 0) return fibo[n];
		if(n == 1) return fibo[n] = 1;
		else if(n == 2) return fibo[n] = 1;
		else return fibo[n] = DFS(n - 2) + DFS(n - 1);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Main T = new Main();
		int n = 45;
		fibo = new int[n + 1]; // 0 안쓰고 7까지 쓸거라
		T.DFS(n); // 가장 큰 항을 구할 때 나머지 항을 다 구하게 됨
		for(int i = 1; i <= n; i++)
			System.out.print(fibo[i]+ " ");
	}
}