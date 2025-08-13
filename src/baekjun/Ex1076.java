package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Ex1076 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Map<String, Integer> value = new HashMap<>();
		Map<String, Integer> multi = new HashMap<>();
		
		value.put("black", 0);
		value.put("brown", 1);
		value.put("red", 2);
		value.put("orange", 3);
		value.put("yellow", 4);
		value.put("green", 5);
		value.put("blue", 6);
		value.put("violet", 7);
		value.put("grey", 8);
		value.put("white", 9);
		
		multi.put("black", 1);
		multi.put("brown", 10);
		multi.put("red", 100);
		multi.put("orange", 1000);
		multi.put("yellow", 10000);
		multi.put("green", 100000);
		multi.put("blue", 1000000);
		multi.put("violet", 10000000);
		multi.put("grey", 100000000);
		multi.put("white", 1000000000);
		
		String first = br.readLine();
		String second = br.readLine();
		String third = br.readLine();
		
		long preNum = value.get(first)*10 + value.get(second);
		long answer = preNum * multi.get(third);
		System.out.println(answer);
	}

}
