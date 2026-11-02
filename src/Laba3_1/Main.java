package Laba3_1;
import common.Sorting;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine().trim());

        List<Integer> nums = new ArrayList<>(n);
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        for (int i = 0; i < n; i++) {
            nums.add(Integer.parseInt(tokenizer.nextToken()));
        }

        Sorting<Integer> sorter = new CountingSort();
        sorter.sort(nums);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nums.size(); i++) {
            if (i > 0) {
                sb.append(' ');
            }
            sb.append(nums.get(i));
        }
        System.out.println(sb);
    }
}
