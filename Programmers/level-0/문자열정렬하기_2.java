package level0;

import java.util.*;
import java.util.stream.*;

public class 문자열정렬하기_2 {
	
	// 스트림 이용
	public static String solution(String my_string) {
		IntStream stream = my_string.toLowerCase().chars();
		return stream.sorted().mapToObj(c -> String.valueOf((char)c)).collect(Collectors.joining());
	}
	
	/*// 메서드 이용(가장 먼저 생각난 것)
	public static String solution(String my_string) {
		my_string = my_string.toLowerCase();

		char[] temp = my_string.toCharArray();
		Arrays.sort(temp);
		return String.valueOf(temp);
	}
	 */
	
	/*// 손코딩
	public static String solution(String my_string) {
        String answer = "";
        my_string = my_string.toLowerCase();
        StringBuilder build = new StringBuilder(my_string);
        
        // 삽입정렬
        for(int i = 1; i < build.length(); i++) {
        	char temp = build.charAt(i);
        	int j;
        	for(j = i - 1; j >= 0; j--) {
        		if(build.charAt(j) > temp)
        			build.setCharAt(j + 1, build.charAt(j));
        		else break;
        	}
        	build.setCharAt(j + 1, temp);
        }
        answer = build.toString();
        return answer;
    }
	 * */

}
