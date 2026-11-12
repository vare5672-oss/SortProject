package Laba6_2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        long w = sc.nextLong();
        long h = sc.nextLong();
        sc.close();

        // бинарный поиск по ответу
        long low = 1;
        long high = Math.max(w, h) * (long) Math.ceil(Math.sqrt(n)) + Math.max(w, h);

        while (low < high) {
            long mid = low + (high - low) / 2;
            if (fits(mid, n, w, h)) {
                high = mid;      // влезает — пробуем меньше
            } else {
                low = mid + 1;   // не влезает — нужно больше
            }
        }

        System.out.println(low);
    }

    // Проверка: поместятся ли n дипломов в квадрат со стороной m
    static boolean fits(long m, long n, long w, long h) {
        long cols = m / w;   // сколько по ширине
        long rows = m / h;   // сколько по высоте

        // Защита от переполнения: если cols >= n, то точно хватит
        // (cols * rows может выйти за пределы long при больших числах)
        if (cols == 0 || rows == 0) return false;
        if (cols >= n / rows + 1) return true; // безопасное сравнение
        return cols * rows >= n;
    }
}