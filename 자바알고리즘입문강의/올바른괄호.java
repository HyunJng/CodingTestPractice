import java.util.*;

public class Main {
	
	public static String solution(String str) {
		String answer = "NO";
		Stack<Character> stack = new Stack<>();
		
		for(char x : str.toCharArray()) {
			if(x == '(') stack.push(x);
			else {
				if(!stack.isEmpty()) stack.pop();
				else return answer;
			}
		}
		if(stack.isEmpty()) answer = "YES";
		
		return answer;
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String str = sc.next();
		
		System.out.println(Main.solution(str));
	}
}