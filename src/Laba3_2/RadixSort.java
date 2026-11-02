package Laba3_2;
import common.Sorting;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class RadixSort implements Sorting<BigInteger> {
    private static final BigInteger BASE = BigInteger.TEN;

    @Override
    public void sort(List<BigInteger> nums) {
        if (nums == null || nums.size() <= 1) {
            return;
        }

        BigInteger max = BigInteger.ZERO;
        for (BigInteger num : nums) {
            if (num.compareTo(max) > 0) {
                max = num;
            }
        }

        BigInteger exp = BigInteger.ONE;
        while (max.divide(exp).compareTo(BigInteger.ZERO) > 0) {
            countingSortByDigit(nums, exp);
            exp = exp.multiply(BASE);
        }
    }

    private void countingSortByDigit(List<BigInteger> nums, BigInteger exp) {
        int n = nums.size();
        List<BigInteger> output = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            output.add(BigInteger.ZERO);
        }

        int[] count = new int[10];

        for (BigInteger num : nums) {
            int digit = num.divide(exp).mod(BASE).intValue();
            count[digit]++;
        }

        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        for (int i = n - 1; i >= 0; i--) {
            int digit = nums.get(i).divide(exp).mod(BASE).intValue();
            output.set(count[digit] - 1, nums.get(i));
            count[digit]--;
        }

        for (int i = 0; i < n; i++) {
            nums.set(i, output.get(i));
        }
    }
}
