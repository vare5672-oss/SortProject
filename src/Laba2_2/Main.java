package Laba2_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String firstLine = br.readLine();
        if (firstLine == null) return;

        int n = Integer.parseInt(firstLine.trim());
        List<Integer> nums = new ArrayList<>(n);

        StringTokenizer st = new StringTokenizer(br.readLine());

        while (nums.size() < n) {
            while (st.hasMoreTokens() && nums.size() < n) {
                nums.add(Integer.parseInt(st.nextToken()));
            }
            if (nums.size() < n) {
                String next = br.readLine();
                if (next == null) break;
                st = new StringTokenizer(next);
            }
        }

        Sorting<Integer> sorter = new MergeSort();
        sorter.sort(nums);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nums.size(); i++) {
            if (i > 0) sb.append(' ');
            sb.append(nums.get(i));
        }
        System.out.println(sb.toString());
    }
}