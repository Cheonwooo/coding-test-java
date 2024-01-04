package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * ���̵�� : (�ʿ��� �ð�)�� 60���� ���� ��� ������ ����
 * ���� ���� �ð��� �ÿ� ���ϰ� 23�� �Ѿ�°�� 0���� �ٽ� ����
 * �������� ���� �ð��� �а� ���ϰ� 60�� �Ѿ�� ��� 0���� �ٽ� ����, 1�ð� ���ϱ�
 * 
 * �ð����⵵ : O(n)
 * 
 * �ڷᱸ�� : X
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
