import java.util.*;
import java.io.*;

public class stonks {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader("stonks.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("stonks.out")));
        int n = Integer.parseInt(br.readLine());

        State[] a = new State[n];

        for(int i = 0; i < n; i++) {
            a[n - i - 1] = new State(n - i - 1, Integer.parseInt(br.readLine()));
        }

        Arrays.sort(a);

        int ans = Integer.MAX_VALUE;
        int maxSum = -1;

        BIT bit = new BIT(n);

        for(int i = 0; i < n; i++) {
            int index = a[i].ind;
            bit.update(index, 1);
            int sum = bit.sumTo(index - 1);
            if(sum > maxSum) {
                maxSum = sum;
                ans = index;
            }
            else if(sum == maxSum) {
                ans = Math.max(index, ans);
            }
        }

        pw.println(n - ans);

        br.close();
        pw.close();

    }

    static class State implements Comparable<State> {
        public int ind, p;
        public State(int ind, int p) {
            this.ind = ind;
            this.p = p;
        }
        public int compareTo(State o) {
            if(o.p == p) return ind - o.ind;
            return o.p - p;
        }
    }

    static class BIT {

        public int n;
        public int[] tree;
    
        public BIT(int n) {
            this.n = n;
            this.tree = new int[n + 1];
        }
    
        public int sumTo(int index) {      // Return the sum of all items until the index, [0...index]
            int sum = 0;
            index = index + 1;
            while(index > 0) {
                sum += tree[index];
                index -= index & (-index);
            }
            return sum;
        }
    
        public void update(int index, int val) {    // Replaces a certain index with a value
            index = index + 1;
            while(index <= n) {
                tree[index] += val;
                index += index & (-index);
            }
        }
    
    }

}