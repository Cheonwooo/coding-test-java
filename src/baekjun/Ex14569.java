package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Ex14569 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		List<Integer>[] subjects = new List[n];
		for (int i = 0; i < n; i++) {
			subjects[i] = new ArrayList<>();
			
			st = new StringTokenizer(br.readLine());
			
			int count = Integer.parseInt(st.nextToken());
			for (int j = 0; j < count; j++) {
				subjects[i].add(Integer.parseInt(st.nextToken()));
			}
		}
		
		int m = Integer.parseInt(br.readLine());
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			
			int count = Integer.parseInt(st.nextToken());
			boolean[] emptyTime = new boolean[51];
			for (int j = 0; j < count; j++) {
				emptyTime[Integer.parseInt(st.nextToken())] = true;
			}
			
			int answer = 0;
			for (int j = 0; j < n; j++) {
				boolean check = true;
				for (int time : subjects[j]) {
					if (!emptyTime[time]) {
						check = false;
						break;
					}
				}
				if (check) answer++;
			}
			System.out.println(answer);
		}
	}

}

/*
 * 시간표 List<>[]
 * boolean[][] check = new boolean[][51]
 * 공강인 시간 true
 */
