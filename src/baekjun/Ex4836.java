package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.TreeSet;

public class Ex4836 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String input;
		while ((input = br.readLine()) != null) {
			input = input.toLowerCase();
			String[] dance = input.split(" ");
			int size = dance.length;
			
			Set<Integer> error = new TreeSet<>();
			
			if (dance[0].equals("jiggle")) error.add(4);
			
			boolean isDip = false;
			boolean isTwirl = false;
			boolean isHop = false;
			for (int i = 0; i < dance.length; i++) {
				if (dance[i].equals("twirl")) isTwirl = true;
				if (dance[i].equals("hop")) isHop = true;
				if (dance[i].equals("dip")) {
					isDip = true;
					boolean check = false;
					if (i < dance.length-1 && dance[i+1].equals("twirl")) {
						check = true;
					}
					if (i >= 1 && dance[i-1].equals("jiggle")) {
						check = true;
					} 
					if (i >= 2 && dance[i-2].equals("jiggle")) {
						check = true;
					}
					if (!check) {
						dance[i] = "DIP";
						error.add(1);
					}
				}
			}
			if ((isTwirl && !isHop)) {
				error.add(3);
			}
			
			boolean isEnd = false;
			if (size >= 3 && dance[size-3].equals("clap") && dance[size-2].equals("stomp") && dance[size-1].equals("clap")) {
				isEnd = true;
			}
			if (!isEnd) error.add(2);
			
			if (!isDip) error.add(5);
			
			if (error.contains(1)) {
				input = "";
				for (int i = 0; i < size; i++) {
					input += dance[i] + " ";
				}
			}
			
			if (error.size() == 0) {
				System.out.println("form ok: " + input);
			} else if (error.size() == 1) {
				System.out.print("form error ");
				for (int number : error) {
					System.out.println(number + ": " + input);
				}
			} else if (error.size() == 2) {
				System.out.print("form errors ");
				int index = 1;
				for (int number : error) {
					if (index == 1) {
						System.out.print(number + " and ");
						index++;
					} else {
						System.out.println(number + ": " + input);
					}
				}
			} else {
				System.out.print("form errors ");
				int index = 1;
				for (int number : error) {
					if (index == 1) {
						System.out.print(number);
					} else if (index != error.size()) {
						System.out.print(", " + number);
					} else {
						System.out.println(" and " + number + ": " + input);
					}
					index++;
				}
			}
		}
	}

}
