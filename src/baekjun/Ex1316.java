package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * ���̵�� : �� ù ���ĺ� true�� ����, �յ� ������ continue, �ٸ��� true���� 
 * �ƴ����� ���� �׷� �ܾ����� üũ 
 * 
 * 
 * �ð����⵵ : 100 * 100
 * 
 * �ڷᱸ�� : boolean[]
 */

public class Ex1316 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int count = 0;
		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			boolean[] groupWord = new boolean[26];
			boolean check = false;
			
			groupWord[str.charAt(0) - 'a'] = true;
			for (int j = 1; j < str.length(); j++) {
				if (str.charAt(j-1) == str.charAt(j)) continue;
				
				int index = str.charAt(j) - 'a';
				if (!groupWord[index]) {
					groupWord[index] = true;
					continue;
				}
				if (groupWord[index]) {
					check = true;
					break;
				}
			}
			if(check) continue;
			count++;
		}
		System.out.println(count);
	}

}
