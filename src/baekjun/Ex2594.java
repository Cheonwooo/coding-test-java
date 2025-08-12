package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Ex2594 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int start = 600;
		int end = 1320;
		
		int n = Integer.parseInt(br.readLine());
		int[][] timeTable = new int[n][2];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			String startTime = st.nextToken();
			String endTime = st.nextToken();
			
			timeTable[i][0] = convertMinute(startTime)-10; 
			timeTable[i][1] = convertMinute(endTime)+10;
		}
		
		Arrays.sort(timeTable, (o1, o2) -> o1[1] - o2[1]);
		
		int max = Math.max(0, timeTable[0][0] - start);
		int endTime = timeTable[0][1];
		for (int i = 1; i < n; i++) {
			if (timeTable[i][0] > endTime) { 
				max = Math.max(max, timeTable[i][0] - endTime);
			}
			endTime = timeTable[i][1];
		}
		
		max = Math.max(max, end - timeTable[n-1][1]);
		System.out.println(max);
	}
	
	private static int convertMinute(String time) {
		int hour = Integer.parseInt(time.substring(0,2));
		int min = Integer.parseInt(time.substring(2));
		
		return hour*60 + min;
	}

}
