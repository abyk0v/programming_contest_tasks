package ru.bykov.yandex.trainers;

public class two {

    public static void main(String[] args) {
        two task = new two();
        System.out.println("7: " + task.findWater(new int[] {3, 1, 4, 3, 5, 1, 1, 3, 1}));
        System.out.println("0: " + task.findWater(new int[] {2, 2, 2, 2, 2, 2}));
    }

    public int findWater(int[] seq) {
        int answer = 0;

        int max_l = seq[0], max_r = max_l;
        int count = 0;

        for (int i = 0; i < seq.length; i++) {
            for (int j = 1; j < seq.length; j++) {

            }
        }

//        for (int i: seq) {
//            if (i > max_l && count == 0) {
//                max_l = i;
//            }
//            if (max_l <= i )
//            if (max_l > i) {
//                count += 1;
//            }
//
//        }

        return answer;
    }
}
