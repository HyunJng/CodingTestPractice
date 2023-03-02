import java.util.*;

class Solution {
    public String[] solution(String[] quiz) {
        String[] answer = new String[quiz.length];
        int i = 0;
        
        for(String s : quiz){
            String[] temp = s.split(" ");
            int a = Integer.parseInt(temp[0]);
            int b = Integer.parseInt(temp[2]);
            int result = Integer.parseInt(temp[4]);
            int trueResult = (temp[1].equals("+"))? a + b : a - b;
            answer[i++] = (result == trueResult)? "O" : "X";
        }
        return answer;
    }
}