package Laba7_3;

import java.io.*;
import java.nio.file.*;
import java.util.*;

public class LCS {

    public static void main(String[] args) throws IOException {

        List<String> lines = Files.readAllLines(Paths.get("lcs-input.txt"));

        String x = lines.get(0).trim();
        String y = lines.get(1).trim();

        int n = x.length();
        int m = y.length();

        int[][] dp = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {

                if (x.charAt(i - 1) == y.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        int answer = dp[n][m];
        System.out.println(answer);
    }
}
