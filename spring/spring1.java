import java.util.*;
import java.io.*;

public class spring1 {

    static int n;
    static int[] a;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader("spring.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("spring.out")));
        n = Integer.parseInt(br.readLine());

        a = new int[n];

        for(int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(br.readLine());
        }

        pw.println(sim(0, 0, 0));

        br.close();
        pw.close();

    }

    public static int sim(int index, int threshold, int sum) {
        if(index == n) return sum;
        if(a[index] >= threshold) {
            return Math.max(sim(index + 1, a[index], sum + a[index]), sim(index + 1, threshold, sum));
        }
        return sim(index + 1, threshold, sum);
    }

}