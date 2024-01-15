package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

/*
 * 아이디어 : 약수를 Set에 저장 후 set을 돌면서 List에 저장
 * List 정렬하고나서 정답 구하기
 * 
 * 시간복잡도 : n * k
 * 
 * 자료구조 : Set, List
 */

public class Ex2501 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Set<Integer> set = new HashSet<>();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		for (int i = 1; i <= n; i++) {
			if (n%i == 0) {
				set.add(i);
			}
		}
		
		if (set.size() < k) {
			System.out.println(0);
		} else {
			List<Integer> list = new ArrayList<>(set);
			Collections.sort(list);
			System.out.println(list.get(k-1));
		}
	}
}
