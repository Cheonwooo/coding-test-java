package programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Ex72412 {

	public static void main(String[] args) {
		String[] info = {"java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"};
		String[] query = {"java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"};
		solution(info, query);
	}
	
	private static int index = 0;
	private static int[] answer;
	private static List<String> keys;
	private static List<String>[] list;
    private static Map<String, List<Integer>> map;
    
    public static int[] solution(String[] info, String[] query) {
        answer = new int[query.length];
        
        list = new List[4];
        for (int i = 0; i < 4; i++) {
            list[i] = new ArrayList<String>();
        }
        
        list[0].addAll(List.of("cpp", "java", "python"));
        list[1].addAll(List.of("backend", "frontend"));
        list[2].addAll(List.of("junior", "senior"));
        list[3].addAll(List.of("chicken", "pizza"));
        
        map = new HashMap<>();
        
        for (int i = 0; i < list[0].size(); i++) {
        	makeKeys(1, 1, list[0].get(i));
        }
        
        makeMapping(info);
        sortMap();
        
        for (int i = 0; i < query.length; i++) {
        	String[] selects = query[i].replaceAll(" and", "").split(" ");
        	keys = new ArrayList<>();
        	findKeyAndPeople(0, 0, selects, "");
        	findPeople(Integer.parseInt(selects[selects.length-1]));
        }
        for (int val : answer) {
        	System.out.print(val + " ");
        }
        return answer;
    }
    
    public static void makeKeys(int depth, int index, String key) {
        if (depth == list.length) {
        	map.put(key, new ArrayList<Integer>());
        	return;
        }
        
        for (int i = 0; i < list[index].size(); i++) {
        	String newKey = key + list[index].get(i);
        	makeKeys(depth+1, index+1, newKey);
        }
    }
    
    public static void makeMapping(String[] info) {
    	for (int i = 0; i < info.length; i++) {
    		String key = "";
    		
    		String[] selects = info[i].split(" ");
    		for (int j = 0; j < selects.length - 1; j++) {
    			key += selects[j];
    		}
    		
    		List<Integer> value = map.get(key);
    		value.add(Integer.parseInt(selects[selects.length-1]));
    		map.put(key, value);
    	}
    }
    
    public static void sortMap() {
    	for (String key : map.keySet()) {
    		List<Integer> value = map.get(key);
    		Collections.sort(value);
    	}
    }
    
    public static void findKeyAndPeople(int depth, int start, String[] selects, String key) {
    	if (depth == selects.length-1) {
    		keys.add(key);
    		return;
    	}
    	
    	for (int i = start; i < selects.length-1; i++) {
    		if (selects[i].equals("-")) {
    			for (int j = 0; j < list[i].size(); j++) {
    				String newKey = key + list[i].get(j);
    				findKeyAndPeople(depth+1, i+1, selects, newKey);
    			}
    		} else {
    			String newKey = key + selects[i];
    			findKeyAndPeople(depth+1, i+1, selects, newKey);
    		}
    	}
    }
    
    public static void findPeople(int score) {
    	for (int i = 0; i < keys.size(); i++) {
    		List<Integer> scores = map.get(keys.get(i));
    		if(scores.size() == 0) continue;
    		
//    		System.out.println("now : " + keys.get(i));
//    		System.out.println(scores);
//    		System.out.println(score);
    		//이분탐색 사용
    		int start = 0;
    		int end = scores.size()-1;
    		int result = scores.size();
    		while (start <= end) {
    			int mid = (start + end) / 2;
    			
    			if (scores.get(mid) < score) {
    				start = mid + 1;
    			} else {
    				result = mid;
    				end = mid - 1;
    			}
    		}
    		answer[index] += scores.size() - result;
    	}
    	index++;
    }
}