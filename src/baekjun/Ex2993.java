package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ex2993 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		
		List<String> strList = new ArrayList<>();
		for (int i = 1; i < str.length()-1; i++) {
			for (int j = i+1; j < str.length(); j++) {
				StringBuilder str1 = new StringBuilder(str.substring(0, i));
				StringBuilder str2 = new StringBuilder(str.substring(i, j));
				StringBuilder str3 = new StringBuilder(str.substring(j));
				
				str1 = str1.reverse();
				str2 = str2.reverse();
				str3 = str3.reverse();
				
				String newStr = str1.toString() + str2.toString() + str3.toString();
				strList.add(newStr);
			}
		}
		
		Collections.sort(strList);
		System.out.println(strList.get(0));
	}
}
