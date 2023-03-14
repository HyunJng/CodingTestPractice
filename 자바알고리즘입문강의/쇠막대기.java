import java.util.*;

public class Main {
	public int solution(String str) {
		int answer = 0;
		Stack<Character> stack = new Stack<>();
		
		for(int i = 0; i < str.length(); i++) {
			char t = str.charAt(i);
			if(t == '(') stack.push(t);
			else {
				stack.pop();
				char prev = str.charAt(i - 1);
				if(prev == '(') {
					answer += stack.size();					
				} else answer++;
			}
		}
		return answer;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		Main M = new Main();
		System.out.println(M.solution(str));
	}
}