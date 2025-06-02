package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Ex7662 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int t = Integer.parseInt(br.readLine());
		for (int i = 0; i < t; i++) {
			TreeMap<Integer, Integer> map = new TreeMap<>();
			
			int n = Integer.parseInt(br.readLine());
			for (int j = 0; j < n; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				
				String option = st.nextToken();
				int number = Integer.parseInt(st.nextToken());
				
				if (option.equals("I")) {
					map.put(number, map.getOrDefault(number, 0) + 1);
				} else {
					if (map.size() == 0) continue;
					if (number == 1) {
						if (map.get(map.lastKey()) >= 1) {
							map.put(map.lastKey(), map.get(map.lastKey()) - 1);
						}
						if (map.get(map.lastKey()) == 0){
							map.remove(map.lastKey());
						}
					} else {
						if (map.get(map.firstKey()) >= 1) {
							map.put(map.firstKey(), map.get(map.firstKey()) - 1);
						} 
						if (map.get(map.firstKey()) == 0){
							map.remove(map.firstKey());
						}
					}
				}
			}
			if (map.size() == 0) {
				sb.append("EMPTY" + "\n");
			} else {
				sb.append(map.lastKey() + " " + map.firstKey() + "\n");
			}
		}
		System.out.println(sb);
	}
}

