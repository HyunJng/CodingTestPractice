package Main;

import java.util.*;
import java.util.stream.IntStream;
class Man implements Comparable<Man>{
	public int height;
	public int weight;
	
	public Man(int height, int weight) {
		this.height = height;
		this.weight = weight;
	}
	
	@Override
	public int compareTo(Man m) {
		return m.height - this.height;
	}
}

public class Main {
	
	public int solution(List<Man> list, int n) {
		int answer = 0;
		
		Collections.sort(list);
		int max = Integer.MIN_VALUE;
		
		for(Man i : list) {
			if(i.weight > max) {
				max = i.weight;
				answer++;
			}
		}
		
		return answer;
	}
	
	public static void main(String[] args) {
		Main T = new Main();
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		List<Man> list = new ArrayList<>();
		
		for(int i = 0; i< n; i++) {
			int height = sc.nextInt();
			int weight = sc.nextInt();
			list.add(new Man(height, weight));
		}
		
		System.out.println(T.solution(list, n));
	}
}