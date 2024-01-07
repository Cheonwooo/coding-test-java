package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/*
 * 아이디어 : a~z까지 리스트에 저장 후, 
 * 각 글자에 대해 contain()이 true면 indexOf(String str)을 사용하여 위치 찾기
 * 
 * 시간복잡도 : length * length = 100 * 100
 * 
 * 자료구조 : String[], List
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
