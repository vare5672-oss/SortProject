package Laba8_1;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer in = new StreamTokenizer(br);

        in.nextToken();
        int n = (int) in.nval;

        long[] pref = new long[n + 1];
        for (int k = 0; k < n; k++) {
            in.nextToken();
            pref[k + 1] = pref[k] + (long) in.nval;
        }


        StringBuilder sb = new StringBuilder();

        while (in.nextToken() != StreamTokenizer.TT_EOF) {
            int i = (int) in.nval;
            in.nextToken();
            int j = (int) in.nval;
            sb.append(pref[j + 1] - pref[i]).append('\n');
        }

        System.out.print(sb);
    }
}