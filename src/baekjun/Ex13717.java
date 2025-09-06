package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex13717 {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int answer = 0;
		int max = 0;
		String answerName = "";
		for (int i = 0; i < n; i++) {
			String name = br.readLine();
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			int requireCount = Integer.parseInt(st.nextToken());
			int totalCount = Integer.parseInt(st.nextToken());
			
			int upgradeCount = 0;
			while (totalCount - requireCount >= 0) {
				upgradeCount++;
				answer++;
				totalCount -= requireCount;
				totalCount += 2;
			}
			
			if (upgradeCount > max) {
				max = upgradeCount;
				answerName = name;
			}
		}
		System.out.println(answer);
		System.out.println(answerName);
	}
}
