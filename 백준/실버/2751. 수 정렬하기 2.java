import java.io.*;
import java.util.*;

/**
 *  병합정렬 이용
 *  1. 배열을 더이상 쪼갤 것이 없을 때까지 쪼개고
 *  2. 주변 집합과 병합하여 차례로 정렬(각 집합 병렬 작업)
 *  
 *  - 시간복잡도 평균 nlog(n)
 *  
 * */
public class Main {
	static int[] arr, temp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		arr = new int[n];
		temp = new int[n];
		
		for(int i = 0; i<n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		merge_sort(0, n - 1); // 병합 정렬
		
		for(int x : arr) {
			bw.write(x + "\n");
		}
		
		bw.close();
	}
	
	public static void merge_sort(int start, int end) {
		if(end - start < 1) return; // 더 쪼갤 것이 없을 때. 길이 0일때 return
		
		int mid = start + (end - start) / 2;
		merge_sort(start, mid); // 반으로 쪼갬
		merge_sort(mid + 1, end);
		
		for(int i = start; i <= end; i++) {
			temp[i] = arr[i];
		}
		
		int k = start;
		int index_1 = start;
		int index_2 = mid + 1;
		
		while(index_1 <= mid && index_2 <= end) { // == 이유: 각각 아울러야하는 값이라서
			if(temp[index_1] < temp[index_2])
				arr[k++] = temp[index_1++];
			else
				arr[k++] = temp[index_2++];
		}
		
		while(index_1 <= mid) {
			arr[k++] = temp[index_1++];
		}
		
		while(index_2 <= end) {
			arr[k++] = temp[index_2++];
		}
	}
}