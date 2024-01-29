package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

/*
 * 아이디어
 * n번째 수까지 증가하는 수열의 길이 개수를 저장
 * d[n] = 0~n-1까지 n번째 수보다 작은 수인 경우 중에 최댓값
 * int[] 입력 받은 수 저장
 * 2중 for문 - int[] for문, d[n] = function(최댓값) + 1
 * 배열을 오름차순으로 정렬 - List사용하자
 * List.get(0)출력
 * 
 * 시간복잡도
 * n * n + nlogn
 * 
 * 자료구조
 * 입력값을 저장할 int[]
 * dp값을 저장할 int[]
 * 값을 저장할 int
 * 
 */

public class Ex11053 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] input = new int[n];
		int[] dp = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		
		dp[0] = 0;
		for (int i = 1; i < n; i++) {
			for (int j = i-1; j >= 0; j--) {
				if (input[i] > input[j]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
		}
		
		Integer[] newDp = Arrays.stream(dp).boxed().toArray(Integer[]::new);
		
		Arrays.sort(newDp, Collections.reverseOrder());
		System.out.println(newDp[0]+1);
	}

}
