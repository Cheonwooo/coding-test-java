package programmers;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class Ex42578_3 {

	public static void main(String[] args) {
		String[][] clothes= {{"yellow_hat", "eyewear"},
				{"blue_sunglasses", "eyewear"},
				{"green_turban", "asd"}};
		
		
		System.out.println(solution(clothes));
	}
	
	private static int solution(String[][] clothes) {
		Map<String, Integer> map = Arrays.stream(clothes)
				.collect(Collectors.toMap(cloth -> cloth[1], cloth -> 1, Integer::sum));
		
		int answer = map.values().stream()
				.mapToInt(count -> count+1)
				.reduce(1, (x, y) -> x*y);
		
		return answer-1;
	}

}
