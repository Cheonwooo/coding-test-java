package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 아이디어 : 분이 45보다 작다면 시를 하나 줄이기, 시를 줄이는데 시가 0이라면 23으로 변경
 * 
 * 시간복잡도 : O(n)
 * 
 * 자료구조 : x
 */

public class Ex2884 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int hour = Integer.parseInt(st.nextToken());
		int minute = Integer.parseInt(st.nextToken());
		
		if(minute < 45) {
			int temp = 45 - minute;
			minute = 60 - temp;
			
			hour = (hour == 0) ? 23 : hour-1;
		} else {
			minute -= 45;
		}
		
		System.out.println(hour + " " + minute);
	}

}
