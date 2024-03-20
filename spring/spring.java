import java.util.*;
import java.io.*;

public class spring {

    static int n;
    static Long[] a;
    static HashMap<Integer, Long> dp;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader("spring.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("spring.out")));
        n = Integer.parseInt(br.readLine());

        a = new Long[n];
        dp = new HashMap<Integer, Long>();

        for(int i = 0; i < n; i++) {
            a[i] = Long.parseLong(br.readLine());
        }

        sim(0, 0L, 0L);

        pw.println(dp.get(n - 1));

        br.close();
        pw.close();

    }

    public static void sim(int index, Long threshold, Long sum) {
        if(index == n) return;
        if(dp.containsKey(index)) return dp.get(index);
        if(a[index] >= threshold) {
            Long ret = Math.max(sim(index + 1, a[index], sum + a[index]), sim(index + 1, threshold, sum));
            dp.put(index, ret);
            return ret;
        }
        Long ret = sim(index + 1, threshold, sum);
        dp.get(index).put(threshold, ret);
        return ret;
    }

}