package Laba2_2;

import java.util.List;

public class MergeSort implements Sorting<Integer> {

    private void slice(List<Integer> nums, int start, int end) {
        if (start >= end) {
            return;
        }
        int middle = start + (end - start) / 2;
        slice(nums, start, middle);
        slice(nums, middle + 1, end);
        merge(nums, start, middle, end);
    }

    private void merge(List<Integer> nums, int start, int middle, int end) {
        int leftSize = middle - start + 1;
        int rightSize = end - middle;

        int[] left = new int[leftSize];
        int[] right = new int[rightSize];

        for (int i = 0; i < leftSize; i++) {
            left[i] = nums.get(start + i);
        }
        for (int j = 0; j < rightSize; j++) {
            right[j] = nums.get(middle + 1 + j);
        }

        int i = 0, j = 0, k = start;

        while (i < leftSize && j < rightSize) {
            if (left[i] <= right[j]) {
                nums.set(k++, left[i++]);
            } else {
                nums.set(k++, right[j++]);
            }
        }

        while (i < leftSize) {
            nums.set(k++, left[i++]);
        }
        while (j < rightSize) {
            nums.set(k++, right[j++]);
        }
    }

    @Override
    public void sort(List<Integer> nums) {
        slice(nums, 0, nums.size() - 1);
    }
}