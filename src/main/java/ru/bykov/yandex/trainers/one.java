package ru.bykov.yandex.trainers;

import java.util.Arrays;

public class one {

    public static void main(String[] args) {
        one task = new one();
        System.out.println("[3, 2] " + Arrays.toString(task.findMaxs(new int[]{1, 2, 1, 2, 3})));
        System.out.println("[2, 2] " + Arrays.toString(task.findMaxs(new int[]{2, 2, 2, 2, 2})));
    }

    public int[] findMaxs(int[] seq) {
        if (seq.length < 2) return null;

        int max = Math.max(seq[0], seq[1]);
        int max2 = Math.min(seq[0], seq[1]);
        for (int i = 2; i < seq.length; i++) {
            if (seq[i] > max) {
                max2 = max;
                max = seq[i];
            } else if (seq[i] > max2) {
                max2 = seq[i];
            }
        }
        return new int[] {max, max2};
    }
}
