package Laba2_3;

import java.util.ArrayList;
import java.util.List;

public class StudentSort implements Sorting<Student> {

    @Override
    public void sort(List<Student> students) {
        mergeSort(students);

        List<ByName> byName = new ArrayList<>(students.size());
        for (Student s : students) byName.add(new ByName(s));
        mergeSort(byName);

        for (int i = 0; i < students.size(); i++) {
            students.set(i, byName.get(i).student);
        }
    }

    private <T extends Comparable<T>> void mergeSort(List<T> a) {
        if (a.size() < 2) return;
        List<T> buf = new ArrayList<>(a.size());
        for (int i = 0; i < a.size(); i++) buf.add(null);
        mergeSort(a, buf, 0, a.size() - 1);
    }

    private <T extends Comparable<T>> void mergeSort(List<T> a, List<T> buf, int left, int right) {
        if (left >= right) return;
        int mid = left + (right - left) / 2;
        mergeSort(a, buf, left, mid);
        mergeSort(a, buf, mid + 1, right);
        merge(a, buf, left, mid, right);
    }

    private <T extends Comparable<T>> void merge(List<T> a, List<T> buf, int left, int mid, int right) {
        for (int i = left; i <= right; i++) buf.set(i, a.get(i));

        int i = left, j = mid + 1, k = left;
        while (i <= mid && j <= right) {
            if (buf.get(i).compareTo(buf.get(j)) <= 0) {
                a.set(k++, buf.get(i++));
            } else {
                a.set(k++, buf.get(j++));
            }
        }
        while (i <= mid)   a.set(k++, buf.get(i++));
        while (j <= right) a.set(k++, buf.get(j++));
    }



    public <T extends Comparable<T>> void quickSort(List<T> a) {
        if (a == null || a.size() < 2) return;
        quickSort(a, 0, a.size() - 1);
    }

    private <T extends Comparable<T>> void quickSort(List<T> a, int lo, int hi) {
        if (lo >= hi) return;
        int p = partition(a, lo, hi);
        quickSort(a, lo, p - 1);
        quickSort(a, p + 1, hi);
    }

    private <T extends Comparable<T>> int partition(List<T> a, int lo, int hi) {
        T pivot = a.get(hi);
        int i = lo;
        for (int j = lo; j < hi; j++) {
            if (a.get(j).compareTo(pivot) <= 0) {
                swap(a, i, j);
                i++;
            }
        }
        swap(a, i, hi);
        return i;
    }

    private <T> void swap(List<T> a, int i, int j) {
        T t = a.get(i);
        a.set(i, a.get(j));
        a.set(j, t);
    }

    private static class ByName implements Comparable<ByName> {
        final Student student;
        ByName(Student s) { this.student = s; }

        @Override
        public int compareTo(ByName other) {
            return this.student.getName().compareTo(other.student.getName());
        }
    }
}