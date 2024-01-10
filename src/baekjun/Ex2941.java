package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * ���̵�� : List�� ���氪���� ���� �� �Է¹��� ���� List������ ���ԵǴ��� Ȯ�� ��(���� ����) 
 * ���ԵǾ� ������ replaceAll�� ���� ġȯ, split�� length���ϱ� 
 * 
 * �ð����⵵ : 100
 * 
 * �ڷᱸ�� : String[]
 */

public class Ex2941 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str = br.readLine();
		
		String[] alphabet = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
		
		for (int i = 0; i < alphabet.length; i++) {
			if(str.contains(alphabet[i])) {
				str = str.replaceAll(alphabet[i], "1");
			}
		}
		
		String[] answer = str.split("");
		
		System.out.println(answer.length);
	}

}
