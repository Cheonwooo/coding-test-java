package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * ���̵��
 * ��� ���� �տ��� ���� 100�� �Ǵ� �ΰ��� ã��
 * ���� for�� �̿��ϱ�
 * 
 * �ð����⵵
 * n * n-1
 * 
 * �ڷᱸ��
 * �Է°��� ������ List
 * ���� ������ int
 * ���� ������ int
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
