import java.util.*;
import java.io.*;

public class verybest {

    static int[] a;
    static int n;
    static int m;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader("verybest.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("verybest.out")));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        a = new int[n];

        for(int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(br.readLine());
        }

        int low = 1;
        int high = 1000000000;

        while(low < high) {
            int mid = (low + high) / 2;
            if(sim(mid)) high = mid;
            else low = mid + 1;
        }

        if(n == 1) pw.println(a[0]);
        else pw.println(low);

        br.close();
        pw.close();

    }

    public static boolean sim(int k) {
        int usedNets = 0;
        int spaceLeft = k;
        for(int i = 0; i < n; i++) {
            if(a[i] > k) return false;
            if(a[i] <= spaceLeft) spaceLeft -= a[i];
            else {
                usedNets++;
                spaceLeft = k - a[i];
            }
        }
        usedNets++;
        if(usedNets <= m) return true;
        return false;
    }

}