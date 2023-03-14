import java.util.*;

public class Main {
	public int cal(char op, int a, int b) {
		switch(op) {
		case '+' : return a + b;
		case '-' : return a - b;
		case '/' : return a / b;
		case '*' : return a * b;
		}
		return -1;
	}
	public int solution(String str) {
		Stack<Integer> stack = new Stack<>();
		
		for(char x : str.toCharArray()) {
			if(Character.isDigit(x)) stack.push((int)x - '0');
			else {
				int b = stack.pop();
				int a = stack.pop();
				stack.push(cal(x, a, b));
			}
		}
		return stack.pop();
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		Main M = new Main();
		
		System.out.println(M.solution(str));
	}
}