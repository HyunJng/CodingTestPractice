import java.util.*;
import java.util.stream.*;

class Bridge implements Comparable<Bridge>{
	int v1;
	int v2;
	int edge;
	
	public Bridge(int v1, int v2, int edge) {
		this.v1 = v1;
		this.v2 = v2;
		this.edge = edge;
	}
	
	@Override
	public int compareTo(Bridge other) {
		return this.edge - other.edge;
	}	
}

public class Main {
	static List<Bridge> bridges = new ArrayList<>();
	static int[] city;
	static int sum = 0;
	
	public static int Find(int n) {
		if(city[n] == n) return n;
		else return city[n] = Find(city[n]);
	}
	
	public static void Union(Bridge a) {
		int fa = Find(a.v1);
		int fb = Find(a.v2);
		
		if(fa != fb) {
			city[fa] = a.v2;
			sum += a.edge;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int v = sc.nextInt();
		int e = sc.nextInt();
		
		city = new int[v + 1];
		IntStream.rangeClosed(1, v)
			.forEach((i) ->	city[i] = i);
		
		for(int i = 0; i< e ; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			
			bridges.add(new Bridge(a, b, c));
		}
		Collections.sort(bridges);

		bridges.forEach(bridge -> {
			Union(bridge);
		});
		
		System.out.println(sum);
	}
}