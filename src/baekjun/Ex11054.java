package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 아이디어
 * 증가하는 수열 + 감소하는 수열
 * 증가하는 수열로 dp값 구하기
 * 이중 for문 1~n까지, i-1부터 1까지 앞<뒤
 * 감소하는 수열로 구해놓은 dp값에 더하기
 * 이중 for문 1~n까지, i-1부터 1까지 앞>뒤
 * 
 * 시간복잡도
 * n * n *2
 * 
 * 자료구조
 * dp값 저장할 int[]
 * 입력값 저장할 int[]
 * 정답을 저장할 int
 */

public class Ex11054 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] input = new int[n+1];
		int[] dpUp = new int[n+1];
		int[] dpDown = new int[n+1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i < n+1; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		
		//증가하는 수열 계산
		dpUp[1] = 1;
		for (int i = 2; i < n+1; i++) {
			for (int j = i-1; j >= 0; j--) {
				if (input[i] > input[j]) {
					dpUp[i] = Math.max(dpUp[i], dpUp[j] + 1);
				}
			}
		}
		
		//감소하는 수열 계산
		dpDown[n] = 0;
		for (int i = n-1; i >= 0; i--) {
			for (int j = i+1; j < n+1; j++) {
				if (input[i] > input[j]) {
					dpDown[i] = Math.max(dpDown[i], dpDown[j] + 1);
				}
			}
		}
		
		int max = Integer.MIN_VALUE;
		for (int i = 1; i < n+1; i++) {
			int sum = dpUp[i] + dpDown[i];
			max = Math.max(max, sum);
		}
		System.out.println(max);
	}
}
