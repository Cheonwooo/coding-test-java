package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

/*
 * 아이디어 : TreeSet을 이용해서 정렬과 중복 동시에 잡기
 * Map에 값 저장
 * 시간복잡도가 너무 큰 경우 Map을 활용하자
 * 
 * 시간복잡도 : n
 * 
 * 자료구조 : Set(TreeSet), Map, int[]
 */

public class Ex18870 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Set<Integer> set = new TreeSet<>();
		for (int i = 0; i < n; i++) {
			set.add(arr[i]);
		}
		
		int index = 0;
		Map<Integer, Integer> map = new HashMap<>();
		for (int number : set) {
			map.put(number, index);
			index++;
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			sb.append(map.get(arr[i])).append(" ");
		}
		System.out.println(sb);
	}
}
