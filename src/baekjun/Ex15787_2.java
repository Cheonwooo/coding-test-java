package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Ex15787_2 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[] subway = new int[n];
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			
			int option = Integer.parseInt(st.nextToken());
			int subwaySeq = Integer.parseInt(st.nextToken()) - 1;
			int seatSeq = (option < 3) ? Integer.parseInt(st.nextToken()) - 1 : 0;
			
			if (option == 1) {
				subway[subwaySeq] |= (1 << seatSeq);
			} else if (option == 2) {
				subway[subwaySeq] &= ~(1 << seatSeq);
			} else if (option == 3) {
				subway[subwaySeq] = (subway[subwaySeq] << 1) & ~(1 << 20);
			} else {
				subway[subwaySeq] = (subway[subwaySeq] >> 1);
			}
		}
		
		Set<Integer> typeOfSubway = new HashSet<>();
		int answer = 0;
		for (int i = 0; i < subway.length; i++) {
			if (!typeOfSubway.contains(subway[i])) {
				typeOfSubway.add(subway[i]);
				answer++;
			}
		}
		System.out.println(answer);
	}

}
