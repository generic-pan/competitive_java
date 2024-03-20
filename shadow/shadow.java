import java.util.*;
import java.io.*;

public class shadow {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader("shadow.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("shadow.out")));
        int n = Integer.parseInt(br.readLine());

        int[] a = new int[n];

        for(int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(br.readLine());
        }

        int max = a[0] + a[1] + a[2] + a[3] + a[4];
        int sum = max;

        for(int i = 5; i < n; i++) {
            sum = sum + a[i] - a[i - 5];
            max = Math.max(sum, max);
        }

        pw.println(max);

        br.close();
        pw.close();

    }

}