package level0;

import java.util.*;

public class 옹알이 {
	
    public static int solution(String[] babbling) {
        int answer = 0;
        String[] ong = {"aya", "ye", "woo", "ma"}; 

        for(String str : babbling) {
        	for(String temp : ong) {
        		if(str.contains(temp)) {
        			str = str.replaceFirst(temp, ",");
        		}
        	}
        	str=str.replace(",", "");
        	if(str.isEmpty())
        		answer++;
        }
        
        return answer;
    }
}
