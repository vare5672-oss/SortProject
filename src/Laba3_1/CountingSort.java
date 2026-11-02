package Laba3_1;
import common.Sorting;
import java.util.List;

public class CountingSort implements Sorting<Integer> {
    @Override
    public void sort(List<Integer> nums) {
        if (nums == null || nums.size() <= 1) {
            return;
        }

        int[] count = new int[128];

        for (int num : nums) {
            count[num]++;
        }

        int index = 0;
        for (int value = 0; value < count.length; value++) {
            for (int i = 0; i < count[value]; i++) {
                nums.set(index++, value);
            }
        }
    }
}
