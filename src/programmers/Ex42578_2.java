package programmers;

import java.util.HashMap;
import java.util.Map;

public class Ex42578_2 {

	public static void main(String[] args) {
		String[][] clothes= {{"yellow_hat", "eyewear"},
				{"blue_sunglasses", "eyewear"},
				{"green_turban", "asd"}};
		
		
		System.out.println(solution(clothes));
	}
	
	private static int solution(String[][] clothes) {
		Map<String, Integer> typeCounter = new HashMap<>();
		
		for (int i = 0; i < clothes.length; i++) {
			String type = clothes[i][1];
			typeCounter.put(type, typeCounter.getOrDefault(type, 0)+1);
		}
		
		int answer = 1;
		for (String val : typeCounter.keySet()) {
			answer *= (typeCounter.get(val)+1);
		}
		
		return answer-1;
	}
}
