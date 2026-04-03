package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.StringTokenizer;

public class Ex32980 {
	
	private static Map<String, Integer> types = Map.of(
			"P", 0,
			"C", 1,
			"V", 2,
			"S", 3,
			"G", 4,
			"F", 5,
			"O", 6
			);

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		String[] trash = new String[n];
		for (int i = 0; i < n; i++) {
			trash[i] = br.readLine();
		}
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] cost = new int[7];
		for (int i = 0; i < 6; i++) {
			cost[i] = Integer.parseInt(st.nextToken());
		}
		
		long answer = 0;
		cost[6] = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			boolean isNormal = false;
			String next = trash[i];
			char type = next.charAt(0);
			for (int j = 1; j < next.length(); j++) {
				if (type != next.charAt(j) || type == 'O') {
					isNormal = true;
					break;
				}
			}
			
			if (isNormal) {
				answer += cost[types.get("O")] * next.length();
			} else {
				int trashCost = cost[types.get(String.valueOf(type))];
				if (trashCost > cost[6]) {
					trashCost = cost[6];
				}
				answer += trashCost * next.length();
			}
		}
		System.out.println(answer);
	}

}

