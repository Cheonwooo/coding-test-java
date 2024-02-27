package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 아이디어
 * 음수를 하나씩 삭제하면서 연속합1 문제처럼 풀기
 * 음수가 나오는 인덱스를 List에 저장
 * List크기만큼 for문
 * List의 인덱스에 해당하는 순서를 제외한 dp를 구하고 max값 구하기
 * 
 * 시간복잡도
 * n * n
 */

public class Ex13398 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] dpFront = new int[n+1];
		int[] dpBack = new int[n+1];
		int[] arr = new int[n+1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i < n+1; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		dpFront[1] = arr[1];
		int max = dpFront[1];
		
		for (int i = 2; i < n+1; i++) {
			dpFront[i] = Math.max(dpFront[i-1] + arr[i], arr[i]);
			max = Math.max(max, dpFront[i]);
		}
		
		dpBack[n] = arr[n];
		
		for (int i = n-1; i >= 1; i--) {
			dpBack[i] = Math.max(dpBack[i+1] + arr[i], arr[i]);
		}

		
		for (int i = 2; i < n; i++) {
			max = Math.max(max, dpFront[i-1] + dpBack[i+1]);
		}
		System.out.println(max);
	}
}
