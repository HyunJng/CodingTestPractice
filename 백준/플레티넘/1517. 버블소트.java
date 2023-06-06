package Main;
import java.io.*;
import java.util.*;
/*
 * 병합 정렬 이용
 * - 병합 정렬 안에 버블 소트의 swap 연산이 수멍있음
 * - 기존 배열에 재정렬할 때 index가 왼쪽으로 이동한 만큼이 swap된 횟수와 동일.
 * 
 * 입력값
8
3 2 8 1 7 4 5 6
 */
public class Main {
	static int[] arr, temp;
	static long result = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		arr = new int[n];
		temp = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		merge_sort(0, n-1);
		System.out.println(result);
	}
	
	public static void merge_sort(int start, int end) {
		if(end - start < 1) return;
		
		int mid = start + (end - start) / 2;
		merge_sort(start, mid);
		merge_sort(mid + 1, end);
		
		for(int i = start; i <= end; i++) {
			temp[i] = arr[i];
		}
		
		int k = start;
		int left = start;
		int right = mid + 1;
		while(left <= mid && right <= end) {
			if(temp[left] > temp[right]) { // 순서 중요. 
				// right가 작은 것을 먼저 체크하지 않으면 == 연산도 여기서 체크할 수 있기 때문.
				// (== 이면 swap이 없는데 병합정렬에서는 arr에 아닌 것과 동일한 액션이기 때문에 문제)
				if(right - k > 0) result += right - k; // 추가 
				arr[k++] = temp[right++];
			} else {
				if(left - k > 0) result += left - k; // 사실 필요 없음
				arr[k++] = temp[left++];
			}
		}
		
		while(left <= mid) arr[k++] = temp[left++];
		while(right <= end) arr[k++] = temp[right++];
	}
}