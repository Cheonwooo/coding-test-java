package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Ex30804 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		int[] number = new int[10];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int left = 0;
		int answer = 0;
		
		Map<Integer, Integer> map = new HashMap<>();
		
		for (int right = 0; right < n; right++) {
			map.put(arr[right], map.getOrDefault(arr[right], 0) + 1);
			
			while (map.size() > 2) {
				map.put(arr[left], map.get(arr[left]) - 1);
				if (map.get(arr[left]) == 0) {
					map.remove(arr[left]);
				}
				left++;
			}
			answer = Math.max(answer, right - left + 1);
		}
		
		System.out.println(answer);
	}
}