package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

// 메모리 14216kb, 시간 104ms

public class Ex16638 {
	
	private static int max = Integer.MIN_VALUE;
	private static int[] temp, number, newNumber;
	private static char[] operation, newOper;
	private static List<Integer> lastNumber;
	private static List<Character> lastOper;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		number = new int[n/2+1];
		operation = new char[n/2];
		
		String str = br.readLine();
		int opIdx = 0;
		int numIdx = 0;
		for (int i = 0; i < str.length(); i++) {
			if (i%2 == 0) {//짝수이면 숫자
				number[numIdx++] = str.charAt(i)-'0';
			} else {//홀수이면 수식
				operation[opIdx++] = str.charAt(i);
			}
		}
		if (n == 1) {
			System.out.println(number[0]);
		} else {
			for (int i = 0; i <= operation.length/2; i++) {
				temp = new int[i];
				selectParenthess(0, 0, i);
			}
			System.out.println(max);
		}
	}
	
	public static void selectParenthess(int depth, int start, int cnt) {
		if (depth == cnt) {
			newOper = new char[operation.length-temp.length];
			newNumber = new int[number.length-temp.length];
			//괄호값 계산하기
			if (cnt > 0) calculateParentheses(temp);
			else {
				System.arraycopy(operation, 0, newOper, 0, operation.length);
				System.arraycopy(number, 0, newNumber, 0, number.length);
			}
			
			//'*'값 계산하기
			calculateMulOper(newNumber, newOper);
			
			//최종값 계산하기
			int result = calculateResult();
			max = Math.max(max, result);
			return;
		}
		
		for (int i = start; i < operation.length; i++) {
			temp[depth] = i;
			selectParenthess(depth+1, i+2, cnt);
		}
	}
	
	public static void calculateParentheses(int[] temp) {
		int numIdx = 0;
		int opIdx = 0;
		int tempIdx = 0;
		for (int i = 0; i < operation.length; i++) {
			if (tempIdx < temp.length && temp[tempIdx] == i) {//괄호값이라면
				int result = cal(operation[i], number[i], number[i+1]);
				newNumber[numIdx++] = result;
				
				if (i < operation.length-1) {//operation의 마지막 인덱스에서는 다음 부호를 추가할 수 없음
					newOper[opIdx++] = operation[++i];
					if (i == operation.length-1) {
						newNumber[numIdx] = number[i+1];
					}
				}
				tempIdx++;
			} else {
				newOper[opIdx++] = operation[i];
				newNumber[numIdx++] = number[i];
				if (i == operation.length-1) {
					newNumber[numIdx] = number[i+1];
				}
			}
		}
	}
	
	public static void calculateMulOper(int[] numbers, char[] operations) {
		lastNumber = new ArrayList<>();
		lastOper = new ArrayList<>();
		
		int sum = numbers[0];
		for (int i = 0; i < operations.length; i++) {
			if (operations[i] == '*') {
				sum *= numbers[i+1];
				if(i == operations.length-1) {
					lastNumber.add(sum);
				}
			} else {
				lastNumber.add(sum);
				sum = numbers[i+1];
				lastOper.add(operations[i]);
				if(i == operations.length-1) {
					lastNumber.add(numbers[i+1]);
				}
			}
		}
	}
	
	public static int calculateResult() {
		int sum = lastNumber.get(0);
		
		for (int i = 0; i < lastOper.size(); i++) {
			char op = lastOper.get(i);
			if (op == '+') {
				sum += lastNumber.get(i+1);
			} else {
				sum -= lastNumber.get(i+1);
			}
		}
		return sum;
	}
	
	public static int cal(char op, int a, int b) {
		if (op == '*') {
			return a * b;
		} else if (op == '+') {
			return a + b;
		} else {
			return a - b;
		}
	}
}
