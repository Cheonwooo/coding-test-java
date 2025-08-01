package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Ex21921 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		int[] visitor = new int[n];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			visitor[i] = Integer.parseInt(st.nextToken());
		}
		
		Map<Integer, Integer> map = new HashMap<>();
		
		int sum = 0;
		for (int i = 0; i < x; i++) {
			sum += visitor[i];
		}
		int max = sum;
		int left = 0;
		int right = x-1;
		map.put(sum, map.getOrDefault(sum, 0) + 1);
		
		for (int i = 1; i <= n-x; i++) {
			sum = sum - visitor[left] + visitor[right+1];//왼쪽값 빼고 오른쪽값 더하고
			max = Math.max(max, sum);
			left++;
			right++;
			map.put(sum, map.getOrDefault(sum, 0) + 1);
		}
		
		if (max == 0) {
			System.out.println("SAD");
		} else {
			System.out.println(max);
			System.out.println(map.get(max));
		}
	}

}
