package Laba3_3;

import common.Sorting;
import java.util.List;

public class GenericSort<T extends Comparable<T>> implements Sorting<T> {

    @Override
    public void sort(List<T> nums) {
        if (nums == null || nums.size() <= 1) {
            return;
        }


        for (int i = 1; i < nums.size(); i++) {
            T key = nums.get(i);
            int j = i - 1;


            while (j >= 0 && nums.get(j).compareTo(key) > 0) {
                nums.set(j + 1, nums.get(j));
                j = j - 1;
            }

            nums.set(j + 1, key);
        }
    }
}