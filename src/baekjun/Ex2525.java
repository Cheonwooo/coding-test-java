package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 아이디어 : (필요한 시간)을 60으로 나눈 몫과 나머지 저장
 * 몫을 현재 시간의 시에 더하고 23이 넘어가는경우 0부터 다시 시작
 * 나머지를 현재 시간의 분과 더하고 60이 넘어가는 경우 0부터 다시 시작, 1시간 더하기
 * 
 * 시간복잡도 : O(n)
 * 
 * 자료구조 : X
 */

public class Ex2525 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] time = br.readLine().split(" ");
		int hour = Integer.parseInt(time[0]);
		int minute = Integer.parseInt(time[1]);
		int takeTime = Integer.parseInt(br.readLine());
		
		int plusHour = takeTime / 60;
		takeTime -= plusHour * 60;
		
		if(minute + takeTime >= 60) {
			minute = (minute + takeTime) - 60;
			hour += 1;
		} else {
			minute += takeTime;
		}
		
		if(hour + plusHour >= 24) {
			hour = (hour + plusHour) - 24;
		} else {
			hour += plusHour;
		}
		
		System.out.println(hour + " " + minute);
	}

}
