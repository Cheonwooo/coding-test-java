package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Ex2304 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[][] arr = new int[n][2];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr, (o1, o2) -> o1[0] - o2[0]);
		
		int max = 0;
		int index = 0;
		for (int i = 0; i < n; i++) {
			if (max < arr[i][1]) {
				max = arr[i][1];
				index = i;
			}
		}
		
		//ÁÂÃø
		int sum = 0;
		int start = 0;
		max = arr[start][1];
		for (int i = 1; i <= index; i++) {
			if (max <= arr[i][1]) {
				max = arr[i][1];
				sum += arr[start][1] * (arr[i][0] - arr[start][0]);
				start = i;
			}
		}
		
		start = n-1;
		max = arr[start][1];
		//¿ìÃø
		for (int i = n-1; i >= index; i--) {
			if (max <= arr[i][1]) {
				max = arr[i][1];
				sum += arr[start][1] * (arr[start][0] - arr[i][0]);
				start = i;
			}
		}
		sum += arr[index][1];
		System.out.println(sum);
	}

}
