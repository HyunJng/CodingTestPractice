import java.util.*;

public class Main {
	static int[] unf;
	
	public static int Find(int v) { // 그룹 찾기
		if(unf[v] == v) return unf[v];
		else return unf[v] = Find(unf[v]);
	}
	
	public static void Union(int a, int b) { // 합집합으로 변경
		int fa = Find(a);
		int fb = Find(b);
		
		if(fa != fb) unf[fa] = fb; // 그룹의 마지막 노드(최상위 노드)와 연결
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
	
		unf = new int[n + 1];
		for(int i = 1; i <= n; i++) unf[i] = i;
		
		for(int i = 0; i < m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			Union(a, b);
		}
		int x = sc.nextInt();
		int y = sc.nextInt();
		
		if(Find(x) == Find(y)) System.out.println("YES");
		else System.out.println("NO");
	}
}
