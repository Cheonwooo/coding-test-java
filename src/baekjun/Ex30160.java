package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex30160 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        long[] S1 = new long[n+1]; // arr[j]
        long[] S2 = new long[n+1]; // j * arr[j]
        long[] S3 = new long[n+1]; // j^2 * arr[j]

        for (int i = 1; i <= n; i++) {
            S1[i] = S1[i-1] + arr[i];
            S2[i] = S2[i-1] + (long)i * arr[i];
            S3[i] = S3[i-1] + (long)i * i * arr[i];
        }

        long[] answer = new long[n+1];
        for (int i = 1; i <= n; i++) {
            long term1 = (long)(i+1) * (i+1) * S1[i];
            long term2 = 2L * (i+1) * S2[i];
            long term3 = S3[i];
            answer[i] = term1 - term2 + term3;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(answer[i]).append(" ");
        }
        System.out.println(sb.toString().trim());
    }
}

/*
 * answer[i]=j=1∑i​arr[j]⋅(i−j+1)^2
 * (i−j+1)^2=(i+1−j)^2
 * (i+1−j)^2=(i+1)^2−2(i+1)j+j^2
 * 
 * answer[i]=j=1∑i​arr[j]⋅((i+1)^2−2(i+1)j+j^2)
 * 
 * answer[i]=(i+1)^2j=1∑i​arr[j]−2(i+1)j=1∑i​j⋅arr[j]+j=1∑i​j^2⋅arr[j]
 */
