package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex32332 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int nowY = Integer.parseInt(st.nextToken());
		int nowM = Integer.parseInt(st.nextToken());
		int nowD = Integer.parseInt(st.nextToken());
		double nowLati = Double.parseDouble(st.nextToken());
		double nowLongi = Double.parseDouble(st.nextToken());
		int nowDayCount = (nowD - 1) + ((nowM - 1) + (nowY * 12)) * 30;
		
		st = new StringTokenizer(br.readLine());
		int nextY = Integer.parseInt(st.nextToken());
		int nextM = Integer.parseInt(st.nextToken());
		int nextD = Integer.parseInt(st.nextToken());
		double nextLati = Double.parseDouble(st.nextToken());
		double nextLongi = Double.parseDouble(st.nextToken());
		int nextDayCount = (nextD - 1) + ((nextM - 1) + (nextY * 12)) * 30;
		
		int totalDayCount = calculateDate(nowDayCount, nextDayCount);
		int day =totalDayCount % 30 + 1;
		int temp = totalDayCount / 30;
		int month = temp % 12 + 1;
		int year = temp / 12;
		
		double lati = calculatePosition(nowLati, nextLati);
		double longi = calculatePosition(nowLongi, nextLongi);
		
		System.out.printf("%d %d %d %.3f %.3f", year, month, day, lati, longi);
	}
	
	private static int calculateDate(int nowD, int nextD) {
		int distD = nowD - nextD;
		return nowD + distD;
	}
	
	private static double calculatePosition(double nowP, double nextP) {
		double distP = nowP - nextP;
		return nowP + distP;
	}
}
