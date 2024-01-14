package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/*
 * 아이디어 : 1부터 6의 배수만큼 거듭합으로 List에 저장 후
 * 해당 값이 포함되는 인덱스 찾기
 * 
 * 시간복잡도 : 1
 * 
 * 자료구조 : List
 */

public class Ex2292 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		List<Integer> beeHouse = new ArrayList<>();
		int start = 1;
		int sum = 1;
		beeHouse.add(sum);
		while(sum < 1_000_000_000) {
			beeHouse.add(sum + 6*start);
			sum += 6*start;
			start++;
		}
		
		int beeRoom = Integer.parseInt(br.readLine());
		if(beeRoom == 1) {
			System.out.println(1);
		} else {
			for (int i = 0; i < beeHouse.size()-1; i++) {
				if(beeRoom >= beeHouse.get(i) && beeRoom <= beeHouse.get(i+1)) {
					System.out.println(i+2);
					break;
				}
			}
		}
		
	}

}
