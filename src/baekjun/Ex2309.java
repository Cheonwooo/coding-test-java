package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * 아이디어
 * 모든 값의 합에서 빼면 100이 되는 두개를 찾기
 * 이중 for문 이용하기
 * 
 * 시간복잡도
 * n * n-1
 * 
 * 자료구조
 * 입력값을 저장할 List
 * 합을 저장할 int
 * 답을 저장할 int
 * 
 */

public class Ex2309 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		List<Integer> list = new ArrayList<>();
		int sum = 0;
		
		for (int i = 0; i < 9; i++) {
			list.add(Integer.parseInt(br.readLine()));
			sum += list.get(i);
		}
		
		for (int i = 0; i < 8; i++) {
			for (int j = i+1; j < 9; j++) {
				int temp = sum;
				
				temp -= (list.get(i) + list.get(j));
				if (temp == 100) {
					list.remove(j);
					list.remove(i);
					break;
				}
			}
			if (list.size() == 7) break;
		}
		
		Collections.sort(list);
		for (int number : list) {
			System.out.println(number);
		}
	}

}
