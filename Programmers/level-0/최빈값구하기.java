import java.util.*;
import java.util.*;

class Solution {
    public int solution(int[] array) {
        int answer = 0;
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i : array) {
        	map.put(i, map.getOrDefault(i, 0) + 1);
        }
        
        int max = Integer.MIN_VALUE;
        for(int i: map.keySet()) {
        	int t = map.get(i);
        	if(max < t) {
        		max = t;
        		answer = i;
        	} else if(max == t) {
        		answer = -1;
        	}
        }
        
        return answer;
    }
}