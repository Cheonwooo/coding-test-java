package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Ex20437 {

	private static Map<Integer, List<Integer>> map;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			map = new HashMap<>();
			init();
			
			String w = br.readLine();
			int k = Integer.parseInt(br.readLine());
			
			for (int i = 0; i < w.length(); i++) {
				int index = w.charAt(i) - 'a';
				List<Integer> temp = new ArrayList<>(map.get(index));
				temp.add(i);
				map.put(index, temp);
			}
			
			boolean check = false;
			int min = Integer.MAX_VALUE;
			int max = Integer.MIN_VALUE;
			for (int i = 0; i < 26; i++) {
				if (map.get(i).size() < k) continue;
				
				check = true;
				List<Integer> temp = map.get(i);
				for (int j = 0; j < temp.size() - k + 1; j++) {
					min = Math.min(min, temp.get(j + k - 1) - temp.get(j) + 1);
					max = Math.max(max, temp.get(j + k - 1) - temp.get(j) + 1);
				}
			}
			
			if (!check) {
				System.out.println(-1);
			} else {
				System.out.println(min + " " + max);
			}
		}
	}
	
	private static void init() {
		for (int i = 0; i < 26; i++) {
			map.put(i, new ArrayList<>());
		}
	}
}

