package Laba4_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        MinStackImpl stack = new MinStackImpl();
        String line;

        while ((line = reader.readLine()) != null) {
            line = line.trim();
            if (line.isEmpty()) {
                continue;
            }

            if (line.startsWith("push")) {
                int value = Integer.parseInt(line.substring(5).trim());
                stack.push(value);
            } else if (line.equals("pop")) {
                stack.pop();
            } else if (line.equals("top")) {
                Integer v = stack.top();
                if (v != null) {
                    out.println(v);
                }
            } else if (line.equals("min")) {
                Integer v = stack.min();
                if (v != null) {
                    out.println(v);
                }
            }
        }

        out.flush();
        reader.close();
    }
}