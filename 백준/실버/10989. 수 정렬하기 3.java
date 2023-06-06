import java.io.*;
import java.util.*;

/**
 * 기수 정렬
 * - 1의자리수부터 비교해서 정렬하는 방법
 * - O(kn) k는 자리수 개수
 * - queue를 이용한느게 보통인데 그러면 메모리 초과나서 합배열로 구현
 * - 정답 찾아봄. 
 */
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n]; 
		
		for(int i = 0; i<n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		Radix_sort(arr, 5);
		
		for(int x : arr) {
			bw.write(x+"\n");
		}
		bw.close();
	}
	
	public static void Radix_sort(int[] arr, int max_size) {
		int[] output = new int[arr.length];
		int jarisu = 1;
		int count = 0;
		
		while(count != max_size) {
			int[] bucket = new int[10];
			for(int i = 0; i<arr.length; i++) {
				bucket[(arr[i]/jarisu)%10]++; // 자리수대로 개수 구하기
			}
			
			for(int i = 1; i<10; i++) {
				bucket[i] += bucket[i-1]; // 해당 자리수의 숫자는 배열의 어떤 index에 들어갈 수 있는지
				// 앞의 자리수보다는 뒤에 와야하기 때문에 합배열로 index 구할 수 있다.
			}
			
			for(int i = arr.length - 1; i >= 0; i--) {
				output[bucket[(arr[i] / jarisu % 10)] - 1] = arr[i]; // 개수이니까 -1 뺌.
				bucket[(arr[i]/jarisu) %10]--;
			}
			
			for(int i = 0; i<arr.length; i++) {
				arr[i] = output[i];
			}
			jarisu = jarisu * 10;
			count++;
		}
	}
}