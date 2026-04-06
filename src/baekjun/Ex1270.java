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
			for (long num : map.keySet()) {
				int count = map.get(num);
				if (max < count && count > (total / 2)) {
					max = count;
					representNum = num;
				}
			}
			
			boolean check = false;
			if (max == 0) {
				check = true;
			}
			
			for (long num : map.keySet()) {
				int count = map.get(num);
				if (representNum != num && max == count) {
					check = true;
					break;
				}
			}
			
			System.out.println((check) ? "SYJKGW" : representNum);
		}
	}

}
