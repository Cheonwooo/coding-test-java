package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Ex24465 {
	
	private static boolean[] check = new boolean[13];
	private static int[][] month = new int[12][2];

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		month[1][0] = 120;
		month[1][1] = 218;
		month[2][0] = 219;
		month[2][1] = 320;
		month[3][0] = 321;
		month[3][1] = 419;
		month[4][0] = 420;
		month[4][1] = 520;
		month[5][0] = 521;
		month[5][1] = 621;
		month[6][0] = 622;
		month[6][1] = 722;
		month[7][0] = 723;
		month[7][1] = 822;
		month[8][0] = 823;
		month[8][1] = 922;
		month[9][0] = 923;
		month[9][1] = 1022;
		month[10][0] = 1023;
		month[10][1] = 1122;
		month[11][0] = 1123;
		month[11][1] = 1221;
		
		for (int i = 0; i < 7; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int pre = Integer.parseInt(st.nextToken());
			int next = Integer.parseInt(st.nextToken());
			
			int date = pre*100 + next;
			check[checkDate(date)] = true;
		}
		
		int count = 0;
		int n = Integer.parseInt(br.readLine());
		List<int[]> answer = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int pre = Integer.parseInt(st.nextToken());
			int next = Integer.parseInt(st.nextToken());
			
			int date = pre*100 + next; 
			if (!check[checkDate(date)]) {
				count++;
				answer.add(new int[] {pre, next});
			}
		}
		
		if (count == 0) {
			System.out.println("ALL FAILED");
		} else {
			Collections.sort(answer, (o1, o2) -> {
				if (o1[0] == o2[0]) {
					return o1[1] - o2[1];
				}
				return o1[0] - o2[0];
			});
			for (int[] temp : answer) {
				System.out.println(temp[0] + " " + temp[1]);
			}
		}
	}	
	
	private static int checkDate(int date) {
		int num = 12;
		for (int i = 1; i < 12; i++) {
			if (month[i][0] <= date && date <= month[i][1]) {
				num = i;
				break;
			}
		}
		return num;
	}

}
