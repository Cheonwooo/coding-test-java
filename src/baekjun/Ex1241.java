package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex1241 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		int[] students = new int[n];
		int[] answer = new int[n];
		int[] arr = new int[1_000_001];
		for (int i =0 ; i < n; i++) {
			int num = Integer.parseInt(br.readLine());
			students[i] = num;
			arr[num]++;
		}
		
		for (int i = 0; i < n; i++) {
			int num = students[i];
			arr[num]--;
			for (int j = 1; j <= (int)Math.sqrt(num); j++) {
				if (num % j == 0) {//나누어 떨어지는 수라면
					//제곱 수 확인
					if (Math.pow(j, 2) == num) {
						//제곱수라면 한 번만 더하기
						answer[i] += arr[j];
					} else {
						answer[i] += arr[j];
						
						int mod = num / j;
						answer[i] += arr[mod];
					}
				}
			}
			arr[num]++;
		}
		for (int num : answer) {
			sb.append(num + "\n");
		}
		System.out.println(sb);
	}
}
