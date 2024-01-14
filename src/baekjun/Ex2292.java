package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/*
 * ���̵�� : 1���� 6�� �����ŭ �ŵ������� List�� ���� ��
 * �ش� ���� ���ԵǴ� �ε��� ã��
 * 
 * �ð����⵵ : 1
 * 
 * �ڷᱸ�� : List
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
