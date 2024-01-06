package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

/*
 * 아이디어 : 배열 정렬 후 최댓값 구하기
 * 평균값을 구할 때마다 값 더해서 저장하기.
 * 
 * 시간복잡도 : n
 * 
 * 자료구조 : List
 */

public class Ex1546 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		List<Integer> score = new ArrayList<Integer>();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < n; i++) {
			score.add(Integer.parseInt(st.nextToken()));
		}
		
		Collections.sort(score);
		
		int max = score.get(score.size()-1);
		
		double sum = 0;
		for (int i = 0; i < n; i++) {
			sum += (double)score.get(i) / max * 100;
		}
		double avg = sum / n;
		
		System.out.println(avg);
	}

}
