import java.util.*;
import java.io.*;

public class capture {

    static int r, c, a, b;
    static int[][] graph;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader("capture.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("capture.out")));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        graph = new int[r][c];
        for(int i = 0; i < r; i++) Arrays.fill(graph[i], -1);

        Stack<State> pq = new Stack<State>();

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int r_i = Integer.parseInt(st.nextToken());
            int c_i = Integer.parseInt(st.nextToken());
            pq.add(new State(r_i, c_i, 0));
        }

        int[] dr = {1, -1, 0, 0};
        int[] dc = {0, 0, 1, -1};
        
        while(!pq.isEmpty()) {
            State state = pq.pop();
            int r_i = state.r;
            int c_i = state.c;
            int val_i = state.val;
            graph[r_i][c_i] = val_i;
            for(int i = 0; i < 4; i++) {
                int r_new = r_i + dr[i];
                int c_new = c_i + dc[i];
                if(r_new < r && r_new >= 0 && c_new < c && c_new >= 0) {
                    if((graph[r_new][c_new] == -1) || (val_i + 1 < graph[r_new][c_new])) {
                        pq.add(new State(r_new, c_new, val_i + 1));
                    }
                }
            }
        }

        /*for(int i = 0; i < r; i++) {
            System.out.println(Arrays.toString(graph[i]));
        }*/

        int ret = 0;

        for(int i = 0; i < r - a + 1; i++) {
            for(int j = 0; j < c - b + 1; j++) {
                ret = Math.max(calc(i, j), ret);
            }
        }

        pw.println(ret);

        br.close();
        pw.close();

    }

    public static int calc(int r_i, int c_i) {
        int ret = Integer.MAX_VALUE;
        for(int i = r_i; i < r_i + a; i++) {
            for(int j = c_i; j < c_i + b; j++) {
                ret = Math.min(graph[i][j], ret);
            }
        }
        return ret;
    }

    static class State implements Comparable<State> {
        public int r, c, val;
        public State(int r, int c, int val) {
            this.r = r;
            this.c = c;
            this.val = val;
        }
        public int compareTo(State o) {
            return val - o.val;
        }
    }

}