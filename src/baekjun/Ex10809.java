package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/*
 * ���̵�� : a~z���� ����Ʈ�� ���� ��, 
 * �� ���ڿ� ���� contain()�� true�� indexOf(String str)�� ����Ͽ� ��ġ ã��
 * 
 * �ð����⵵ : length * length = 100 * 100
 * 
 * �ڷᱸ�� : String[], List
 */

public class Ex10809 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		String str = br.readLine();
		String[] splitStr = str.split("");
		
		List<String> characterList = new ArrayList<String>();
		for (char c = 'a'; c <= 'z'; c++) {
			characterList.add(String.valueOf(c));
		}
		
		for (int i = 0; i<characterList.size(); i++) {
			if(str.contains(characterList.get(i))) {
				System.out.print(str.indexOf(characterList.get(i)) + " ");
			} else {
				System.out.print(-1 + " ");
			}
		}
	}

}
