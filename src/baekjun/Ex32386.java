package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Ex32386 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Map<String, Integer> map = new HashMap<>();
		int n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int problem = Integer.parseInt(st.nextToken());
			int number = Integer.parseInt(st.nextToken());
			for (int j = 0; j < number; j++) {
				String tag = st.nextToken();
				
				map.put(tag, map.getOrDefault(tag, 0) + 1);
			}
		}
		
		int max = 0;
		int[] maxCount = new int[100_001];
		String answer = "";
		for (String key : map.keySet()) {
			int count = map.get(key);
			
			if (max < count) {
				maxCount[count]++;
				max = count;
				answer = key;
			} else if (max == count) {
				maxCount[count]++;
			}
		}
		System.out.println((maxCount[max] != 1) ? -1 : answer);
	}

}
