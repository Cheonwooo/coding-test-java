package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Ex25593 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Map<String, Integer> workers = new HashMap<>();
		
		int n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < 4; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				
				int time = 0;
				if (j == 0) time = 4;
				else if (j == 1) time = 6;
				else if (j == 2) time = 4;
				else time = 10;
				
				for (int k = 0; k < 7; k++) {
					String name = st.nextToken();
					
					if (name.equals("-")) continue;
					
					workers.put(name, workers.getOrDefault(name, 0) + time);
				}
			}
		}
		
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		for (String name : workers.keySet()) {
			int time = workers.get(name);
			
			max = Math.max(max, time);
			min = Math.min(min, time);
		}
		
		if ((max - min) > 12) {
			System.out.println("No");
		} else {
			System.out.println("Yes");
		}
	}

}
