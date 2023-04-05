import java.util.*;
import java.util.stream.IntStream;

class Conference implements Comparable<Conference>{
	int start;
	int end;
	
	public Conference(int start, int end) {
		this.start = start;
		this.end = end;
	}
	
	@Override
	public int compareTo(Conference c) {
		if(c.end == this.end) return this.start - c.start;
		return this.end - c.end;
	}
}

public class Main {
	
	public int solution(List<Conference> list, int n) {
		int answer = 1;
		
		Collections.sort(list);
		int lastTime = list.get(0).end;
		
		for(int i = 1; i < list.size(); i++) {
			if(lastTime <= list.get(i).start) {
				lastTime = list.get(i).end;
				answer++;
			}
		}
		return answer;
	}
	
	public static void main(String[] args) {
		Main T = new Main();
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		List<Conference> list = new ArrayList<>();
		
		for(int i = 0; i<n ;i++) {
			int start = sc.nextInt();
			int end = sc.nextInt();
			
			list.add(new Conference(start, end));
		}
		System.out.println(T.solution(list, n));
	}
}