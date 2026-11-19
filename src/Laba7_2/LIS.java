package Laba7_2;

import java.io.*;
import java.nio.file.*;
import java.util.*;

public class LIS {

    public static void main(String[] args) throws IOException {

        List<String> lines = Files.readAllLines(Paths.get("lis-input.txt"));

        int n = Integer.parseInt(lines.get(0).trim());
        String[] parts = lines.get(1).trim().split("\\s+");
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(parts[i]);
        }

        int[] dp = new int[n];
        int[] prev = new int[n];

        Arrays.fill(dp, 1);
        Arrays.fill(prev, -1);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (a[j] < a[i] && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                    prev[i] = j;
                }
            }
        }

        int bestEnd = 0;
        for (int i = 1; i < n; i++) {
            if (dp[i] > dp[bestEnd]) bestEnd = i;
        }
        int k = dp[bestEnd];

        List<Integer> result = new ArrayList<>();
        int cur = bestEnd;
        while (cur != -1) {
            result.add(a[cur]);
            cur = prev[cur];
        }
        Collections.reverse(result);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < result.size(); i++) {
            if (i > 0) sb.append(' ');
            sb.append(result.get(i));
        }

        List<String> output = new ArrayList<>();
        output.add(String.valueOf(k));
        output.add(sb.toString());
        Files.write(Paths.get("lis-output.txt"), output);

        System.out.println("Длина: " + k);
        System.out.println("Подпоследовательность: " + sb);
    }
}
