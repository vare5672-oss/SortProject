package Laba3_3;

import common.Sorting;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Main {
    public static void main(String[] args) {
        GenericSort genericSort = new GenericSort<>();

        System.out.println("1. Integer");
        List<Integer> ints = new ArrayList<>(List.of(5, 1, 9, 3, 7));
        genericSort.sort(ints);
        for (Integer num : ints) {
            System.out.print(num + " ");
        }
        System.out.println();

        System.out.println("\n2. String");
        List<String> strings = new ArrayList<>(List.of("lily", "rose", "pion", "tulip"));
        genericSort.sort(strings);
        for (String str : strings) {
            System.out.print(str + " ");
        }
        System.out.println();

        System.out.println("\n3. LocalDateTime");
        List<LocalDateTime> dates = new ArrayList<>(List.of(
                LocalDateTime.of(2023, 12, 31, 23, 59),
                LocalDateTime.of(2020, 1, 1, 0, 0),
                LocalDateTime.of(2025, 5, 20, 12, 0)
        ));
        genericSort.sort(dates);
        for (LocalDateTime dt : dates) System.out.println(dt);

        System.out.println("\n4. Student");
        List<Student> students = new ArrayList<>(List.of(
                new Student("Vasya", 21),
                new Student("Anton", 22),
                new Student("Vasya", 19),
                new Student("Antonio", 23)
        ));
        genericSort.sort(students);
        for (Student s : students) System.out.println(s);

        System.out.println("\n5. UUID");
        List<UUID> uuids = new ArrayList<>(List.of(
                UUID.fromString("f47ac10b-58cc-4372-a567-0e02b2c3d479"),
                UUID.fromString("123e4567-e89b-12d3-a456-426614174000"),
                UUID.fromString("a8098c1a-f86e-11da-bd1a-00112444be1e")
        ));
        genericSort.sort(uuids);
        for (UUID uuid : uuids) System.out.println(uuid);
    }
}