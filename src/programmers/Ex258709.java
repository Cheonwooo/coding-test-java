package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Ex258709 {
	private static int n, win;
	private static double max;
	private static int[] answer;
	private static int[][] allDice;
	private static boolean[] visited;
	
	public static void main(String[] args) {
		int[][] dice = {{40, 41, 42, 43, 44, 45}, {43, 43, 42, 42, 41, 41}, {1, 1, 80, 80, 80, 80}, {70, 70, 1, 1, 70, 70}};
		solution(dice);
	}
    public static int[] solution(int[][] dice) {
    	n = dice.length;
        answer = new int[n/2];
        
        allDice = dice;
        
        int[] diceA = new int[n/2];
        int[] diceB = new int[n/2];
        visited = new boolean[n];
        
        selectDice(diceA, diceB, 0, 0);
        System.out.println(Arrays.toString(answer));
        return answer;
    }
    
    public static void selectDice(int[] diceA, int[] diceB, int depth, int start) {
    	if (depth == n/2) {
    		visited = new boolean[n];
    		win = 0;
    		for (int i = 0; i < diceA.length; i++) {
    			visited[diceA[i]] = true;
    		}
    		
    		int index = 0;
    		for (int i = 0; i < n; i++) {
    			if (!visited[i]) diceB[index++] = i; 
    		}

    		int[] tempA = new int[n/2];
    		List<Integer> listA = new ArrayList<>();
    		calculateSum(listA, diceA, tempA, 0);
    		
    		int[] tempB = new int[n/2];
    		List<Integer> listB = new ArrayList<>();
    		calculateSum(listB, diceB, tempB, 0);
    		
    		Collections.sort(listB);
    		compareList(listA, listB);
    		System.out.println(win);
    		double avg = win/(double)Math.pow(6, n);
    		if (max < avg) {
    			max = avg;
    			for (int i = 0; i < answer.length; i++) {
    				answer[i] = diceA[i]+1;
    			}
    		}
    		return;
    	}
    	for (int i = start; i < n; i++) {
    		diceA[depth] = i;
    		selectDice(diceA, diceB, depth + 1, i + 1);
    	}
    }
    
    public static void calculateSum(List<Integer> list, int[] dice, int[] temp, int depth) {
    	if (depth == dice.length) {
    		list.add(getSum(dice, temp));
    		return;
    	}
    	
    	for (int i = 0; i < 6; i++) {
    		temp[depth] = i;
    		calculateSum(list, dice, temp, depth+1);
    	}
    }
    
    public static int getSum(int[] dice, int[] temp) {
    	int sum = 0;
    	for (int i = 0; i < temp.length; i++) {
    		sum += allDice[dice[i]][temp[i]];
    	}
    	return sum;
    }
    
    public static void compareList(List<Integer> listA, List<Integer> listB) {
    	for (int i = 0; i < listA.size(); i++) {
    		int left = 0;
    		int right = listB.size()-1;
    		int number = listA.get(i);
    		
    		int index = Integer.MIN_VALUE;
    		while (left <= right) {
    			int mid = (left + right) / 2;
    			
    			if (number > listB.get(mid)) {
    				left = mid + 1;
    				index = Math.max(index, mid);
    			} else {
    				right = mid-1;
    			}
    		}
    		if (index != Integer.MIN_VALUE) {
    			win += index+1;    			
    		}
    	}
    }
}