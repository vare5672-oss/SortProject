package Laba7_1;

import java.io.*;
import java.nio.file.*;
import java.util.*;

public class Roguelike {

    public static void main(String[] args) throws IOException {

        List<String> lines = Files.readAllLines(Paths.get("roguelike-input.csv"));

        List<int[]> gridList = new ArrayList<>();
        for (String line : lines) {
            line = line.trim();
            if (line.isEmpty()) continue;
            String[] parts = line.split(";");
            int[] row = new int[parts.length];
            for (int j = 0; j < parts.length; j++) {
                row[j] = Integer.parseInt(parts[j].trim());
            }
            gridList.add(row);
        }

        int n = gridList.size();
        int m = gridList.get(0).length;
        int[][] grid = gridList.toArray(new int[n][]);

        long[][] dp = new long[n][m];
        byte[][] from = new byte[n][m];

        dp[0][0] = grid[0][0];


        for (int j = 1; j < m; j++) {
            dp[0][j] = dp[0][j - 1] + grid[0][j];
            from[0][j] = 1;
        }

        for (int i = 1; i < n; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
            from[i][0] = 0;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (dp[i - 1][j] >= dp[i][j - 1]) {
                    dp[i][j] = dp[i - 1][j] + grid[i][j];
                    from[i][j] = 0;
                } else {
                    dp[i][j] = dp[i][j - 1] + grid[i][j];
                    from[i][j] = 1;
                }
            }
        }


        StringBuilder path = new StringBuilder();
        int i = n - 1, j = m - 1;
        while (i > 0 || j > 0) {
            if (from[i][j] == 0) {
                path.append('D');
                i--;
            } else {
                path.append('R');
                j--;
            }
        }
        path.reverse();

        List<String> output = new ArrayList<>();
        output.add(String.valueOf(dp[n - 1][m - 1]));
        output.add(path.toString());
        Files.write(Paths.get("roguelike-output.txt"), output);

        System.out.println("Максимум монет: " + dp[n - 1][m - 1]);
        System.out.println("Путь: " + path);
    }
}