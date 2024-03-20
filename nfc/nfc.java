import java.util.*;
import java.io.*;

public class nfc {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader("nfc.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("nfc.out")));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] a = new int[n];

        for(int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(br.readLine());
        }

        int minDist = Integer.MAX_VALUE;
        int closer = 0;
        int farther = 0;

        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                if(a[i] + a[j] == k) {
                    int dist = i + j;
                    if(dist < minDist) {
                        minDist = dist;
                        closer = Math.min(i, j);
                        farther = Math.max(i, j);
                    }
                }
            }
        }

        pw.println((closer + 1) + " " + (farther + 1));

        br.close();
        pw.close();

    }

}