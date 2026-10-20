package Laba2_3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());

        List<Student> students = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            String line = br.readLine().trim();
            int sp = line.lastIndexOf(' ');
            String name = line.substring(0, sp);
            int age = Integer.parseInt(line.substring(sp + 1));
            students.add(new Student(name, age));
        }

        new StudentSort().sort(students);

        PrintWriter pw = new PrintWriter(System.out);
        for (Student s : students) {
            pw.println(s.getName() + " " + s.getAge());
        }
        pw.flush();
    }
}