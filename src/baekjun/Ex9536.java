package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex9536 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			String[] sound = br.readLine().split(" ");
			boolean[] check = new boolean[sound.length];
			while (true) {
				String animalSound = br.readLine();
				
				if (animalSound.equals("what does the fox say?")) {
					break;
				}
				
				String[] animalSoundSplit = animalSound.split(" ");
				
				for (int i = 0; i < sound.length; i++) {
					if (sound[i].equals(animalSoundSplit[2])) {
						check[i] = true;
					}
				}
			}
			
			for (int i = 0; i < sound.length; i++) {
				if (!check[i]) {
					sb.append(sound[i] + " ");
				}
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

}
