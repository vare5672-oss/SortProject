package Laba6_1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // чтение массива
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // чтение запросов
        int m = sc.nextInt();
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < m; i++) {
            int query = sc.nextInt();
            int closest = findClosest(arr, query);
            if (i > 0) result.append(" ");
            result.append(closest);
        }

        System.out.println(result.toString());
        sc.close();
    }

    // бинарный поиск ближайшего элемента
    // определение границ поиска
    static int findClosest(int[] arr, int target) {
        int left = 0, right = arr.length - 1;

        // бинарный поиск позиции
        while (left < right) {
            int mid = (left + right) / 2;
            if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        if (left > 0 && Math.abs(arr[left - 1] - target) <= Math.abs(arr[left] - target)) {
            return arr[left - 1];
        }
        return arr[left];
    }
}
