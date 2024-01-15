package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 아이디어 : 조건문을 통해 약수/배수를 걸러내자
 * 
 * 시간복잡도 : 1
 * 
 * 자료구조 : x
 */

public class Ex5086 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int firstNumber = Integer.parseInt(st.nextToken());
			int secondNumber = Integer.parseInt(st.nextToken());
			
			if (firstNumber == 0 && secondNumber == 0) break;
			
			sb.append(checkFactorOrMultiple(firstNumber, secondNumber)).append("\n");
		}
		System.out.println(sb);
	}
	
	private static String checkFactorOrMultiple(int firstNumber, int secondNumber) {
		if (secondNumber / firstNumber != 0 && secondNumber % firstNumber == 0) {
			return "factor";
		}
		if (firstNumber / secondNumber != 0 && firstNumber % secondNumber == 0) {
			return "multiple";
		}
		return "neither";
	}

}
