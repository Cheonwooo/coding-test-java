package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex15961 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int[] arr = new int[n + k - 1];
		int[] sushiCount = new int[d + 1];
		
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		for (int i = n; i < n + k - 1; i++) {
			arr[i] = arr[i - n];
		}
		
		int answer = 0;
		int typeOfSushiCount = 0;
		int left = 0;
		int right = 0;
		while (left != n-1) {
			if (right - left != k) {//k만큼 안됐다면
				if (sushiCount[arr[right]] == 0) {
					typeOfSushiCount++;
				}
				sushiCount[arr[right++]]++;
			} else {
				
				if (sushiCount[arr[left]] == 1) {
					typeOfSushiCount--;
				}
				sushiCount[arr[left++]]--;
				
				if (sushiCount[arr[right]] == 0) {
					typeOfSushiCount++;
				}
				sushiCount[arr[right++]]++;
			}
			if (sushiCount[c] == 0) {
				answer = Math.max(answer, typeOfSushiCount + 1);
			} else {
				answer = Math.max(answer, typeOfSushiCount);
			}
		}
		System.out.println(answer);
	}

}
