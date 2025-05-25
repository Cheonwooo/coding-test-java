package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Ex9375 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < t; i++) {
			int n = Integer.parseInt(br.readLine());
			
			Map<String, Integer> map = new HashMap<>();
			
			for (int j = 0; j < n; j++) {
				String[] clothes = br.readLine().split(" ");
				map.put(clothes[1], map.getOrDefault(clothes[1], 1) + 1);
			}
			
			int mul = 1;
			for (String key : map.keySet()) {
				mul *= map.get(key);
			}
			
			System.out.println(mul-1);
		}
	}
}
