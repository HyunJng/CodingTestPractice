import java.util.*;

public class Main {

	// 방법 1 : stack에는 괄호만 넣기
	public static String solution(String str) {
		Stack<Character> stack = new Stack<>();
		String answer = "";
		for(char x : str.toCharArray()) {
			
			if(x == '(') stack.push(x);
			else if(x == ')') stack.pop();
			else if(stack.isEmpty()) answer += x;
		}
		return answer;
	}
	
	// 방법 2: stack에 괄호와 문자 넣기
	public static String solution(String str) {

		Stack<Character> stack = new Stack<>();
		String answer = "";
		for(char x : str.toCharArray()) {
			
			if(x == ')') {
				while(stack.pop() != '(');
			}
			else stack.push(x);
		}
		for(char x : stack)
			answer += x;
		return answer;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		
		System.out.println(Main.solution(str));
	}
}