import java.util.*;
import java.io.*;

public class relprimes {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader("relprimes.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("relprimes.out")));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        int n_temp;

        if(m > n) {
            n_temp = n;
            n = m;
            m = n_temp;
        }
        
        while(m != 0) {
            n_temp = n;
            n = m;
            m = n_temp % m;
        }

        if(n == 1) pw.println(1);
        else pw.println(0);

        br.close();
        pw.close();

    }

}