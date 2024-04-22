package programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ex65065 {

	public static void main(String[] args) {
		
		String s = "{{4,2,3},{3},{2,3,4,1},{2,3}}";
		int[] arr = solution(s);
		
		for (int val : arr) {
			System.out.println(val);
		}
	}
	
	public static int[] solution(String s) {
        
        s = s.substring(1,s.length()-1);
        List<String> list = new ArrayList<>();
		
		Pattern pattern = Pattern.compile("\\{(.*?)\\}");
		Matcher matcher = pattern.matcher(s);
		
		while (matcher.find()) {
			String newString = matcher.group(1);
			list.add(newString);
			
			if (matcher.group(1) == null) break;
		}
		
		Collections.sort(list, (o1, o2) -> (o1.length() - o2.length()));
		
	    Set<Integer> set = new LinkedHashSet<>(); 
		set.add(Integer.parseInt(list.get(0)));
		
		for (int i = 1; i < list.size(); i++) {
			String[] splitStr = list.get(i).split(",");
			
			for (int j = 0; j < splitStr.length; j++) {
				set.add(Integer.parseInt(splitStr[j]));
			}
		}
        
        int[] answer = set.stream().mapToInt(Integer::intValue).toArray();
		
		return answer;
		
    }

}
