package programmers;

import java.util.HashMap;
import java.util.Map;

/*
 * 아이디어
 * 
 */

public class Ex42577 {

	public static void main(String[] args) {
		String[] phone_book = {"119", "97674223", "1195524421"};
		
		System.out.println(solution(phone_book));
	}
	
	private static boolean solution(String[] phone_book) {
		Map<String, Integer> map = new HashMap<>();
		
		for (int i = 0; i < phone_book.length; i++) {
			map.put(phone_book[i], 1);
		}
		
        for (String s : phone_book) {
        	for (int j = 1; j < s.length(); j++) {
        		if (map.containsKey(s.substring(0, j))) {
        			return false;
        		}
        	}
        }
        return true;
    }
}
