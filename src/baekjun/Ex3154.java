package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Ex3154 {
	
	private static Map<Integer, int[]> map;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] time = br.readLine().split(":");
		
		map = new HashMap<>();
		map.put(0, new int[] {3, 1});
		int number = 1;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				map.put(number++, new int[] {i, j});
			}
		}
		
		int hour = 0;
		int minute = 0;
		int min = Integer.MAX_VALUE;
		
		for (int i = Integer.parseInt(time[0]); i < 100; i += 24) {
			for (int j = Integer.parseInt(time[1]); j < 100; j += 60) {
				int sum = calculateTime(i, j);
				if (min > sum) {
					min = sum;
					hour = i;
					minute = j;
				}
			}
		}
		
		if (hour < 10 && minute < 10) {
			System.out.println("0" + hour +  ":0" + minute);
		} else if (hour < 10) {
			System.out.println("0" + hour +  ":" + minute);
		} else if (minute < 10) {
			System.out.println(hour +  ":0" + minute);
		} else {
			System.out.println(hour +  ":" + minute);
		}
	}
	
	private static int calculateTime(int h, int m) {
		int sum = 0;
		
		int[] first = map.get(h/10);
		int[] second = map.get(h%10);
		int[] third = map.get(m/10);
		int[] fourth = map.get(m%10);
		
		sum += Math.abs(first[0] - second[0]) + Math.abs(first[1] - second[1]);
		sum += Math.abs(second[0] - third[0]) + Math.abs(second[1] - third[1]);
		sum += Math.abs(third[0] - fourth[0]) + Math.abs(third[1] - fourth[1]);
		
		return sum;
	}

}
