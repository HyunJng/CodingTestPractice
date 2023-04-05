import java.util.*;
import java.util.stream.IntStream;

class State implements Comparable<State>{
	int state; // come : 1, out : -1
	int time;
	
	public State(int state, int time) {
		this.state = state;
		this.time = time;
	}
	
	@Override
	public int compareTo(State s) {
		if(this.time == s.time) return this.state - s.state; 
		return this.time - s.time;
	}
	
//	@Override
//	public String toString() {
//		return state+ " : " + time + " ";
//	}
}

public class Main {
	
	public int solution(List<State> list, int n) {
		int answer = Integer.MIN_VALUE;
		
		Collections.sort(list);
		//list.stream().forEach((i) -> System.out.println(i));
		int cur = 0;
		for(State s : list) {
			cur += s.state;
			if(cur > answer) answer = cur;
		}
		return answer;
	}
	
	public static void main(String[] args) {
		Main T = new Main();
		Scanner sc = new Scanner(System.in);
		List<State> list = new ArrayList<>();
		
		int n = sc.nextInt();
		for(int i = 0; i<n; i++) {
			int come = sc.nextInt();
			int out = sc.nextInt();
			list.add(new State(1, come));
			list.add(new State(-1, out));
		}
		System.out.println(T.solution(list, n));
	}
}
