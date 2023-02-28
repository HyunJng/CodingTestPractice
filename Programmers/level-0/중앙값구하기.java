import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int[] array) {
        int[] arr = Arrays.stream(array).sorted().toArray();
        return arr[arr.length/2];
    }
}