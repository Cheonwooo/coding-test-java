package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 아이디어 : List에 변경값들을 저장 후 입력받은 값에 List값들이 포함되는지 확인 후(순서 주의) 
 * 포함되어 있으면 replaceAll을 통해 치환, split후 length구하기 
 * 
 * 시간복잡도 : 100
 * 
 * 자료구조 : String[]
 */

public class Ex2941 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str = br.readLine();
		
		String[] alphabet = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
		
		for (int i = 0; i < alphabet.length; i++) {
			if(str.contains(alphabet[i])) {
				str = str.replaceAll(alphabet[i], "1");
			}
		}
		
		String[] answer = str.split("");
		
		System.out.println(answer.length);
	}

}
