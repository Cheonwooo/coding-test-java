package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Ex1270 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int total = Integer.parseInt(st.nextToken());
			Map<Long, Integer> map = new HashMap<>();
			for (int j = 0; j < total; j++) {
				long num = Long.parseLong(st.nextToken());
				map.put(num, map.getOrDefault(num, 0) + 1);	
			}
			
			int max = 0;
			long representNum = 0;
			boolean isDuplicated = false;
			
			for (Map.Entry<Long, Integer> entry : map.entrySet()) {
				long num = entry.getKey();
				int count = entry.getValue();
				
				if (count > (total / 2)) { 
					if (max < count) {
						representNum = num;
						max = count;
						isDuplicated = false;
					} else if (count == max) {
						isDuplicated = true;
					}
				}
			}
			
			System.out.println((max == 0 || isDuplicated) ? "SYJKGW" : representNum);
		}
	}

}
