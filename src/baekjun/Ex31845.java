package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Ex31845 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		List<Integer> arr = new ArrayList<>();
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr.add(Integer.parseInt(st.nextToken()));
		}
		
		Collections.sort(arr, Collections.reverseOrder());
		int score = 0;
		
		while (m-- > 0) {
			if (arr.get(0) > 0) {
				score += arr.get(0);
				arr.remove(0);
				
				if (arr.size() != 0) {
					arr.remove(arr.size() - 1);
				}
			} else {
				break;
			}
			
			if (arr.size() == 0) {
				break;
			}
		}
		System.out.println(score);
	}

}
