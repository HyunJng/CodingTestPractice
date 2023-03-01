import java.util.*;

class Solution {
   // 유클리드호제법
    public int ucli(int min, int max){
        int temp = max % min;
        if(temp == 0) return min;
        
        return ucli(temp, min);
    }    
    
    public int solution(int a, int b) {
        int t = ucli(Math.min(a, b), Math.max(a, b));
        
        while(t != 1){
            a /= t; b /= t;
            t = ucli(Math.min(a, b), Math.max(a, b));
        }
        
        while(b % 2 == 0) b /= 2;
        while(b % 5 == 0) b /= 5;
        
        return (b == 1) ? 1 : 2;
    }
}