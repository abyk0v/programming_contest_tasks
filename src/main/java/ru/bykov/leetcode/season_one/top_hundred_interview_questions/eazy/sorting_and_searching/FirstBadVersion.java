package ru.bykov.leetcode.season_one.top_hundred_interview_questions.eazy.sorting_and_searching;

/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class FirstBadVersion {

    public static void main(String[] args) {
        FirstBadVersion test = new FirstBadVersion();
        System.out.println(test.firstBadVersion(100));
    }

    /*
    time: O(logN)
    memory: O(1)
     */
    public int firstBadVersion(int n) {
        return find(0, n);
    }

    private int find(int l, int r) {
        if (l == r) {
            return l;
        }

        int testVersion = (l + r) / 2;

        boolean isBadVersion = isBadVersion(testVersion);

        if (isBadVersion) {
            return find(l, testVersion);
        } else {
            return find(testVersion + 1, r);
        }
    }

    public int firstBadVersion_2(int n) {
        int left = 0;
        int right = n;

        while (left < right) {
            int medium = left + (right - left) / 2;
            if (isBadVersion(medium)) {
                right = medium;
            } else {
                left = medium + 1;
            }
        }

        // так как bad версия точно есть всегда, то данная проверка излишния
        // if (left == right && isBadVersion(left)) {
        //     return left;
        // }
        return left;
    }

    private boolean isBadVersion(int n) {
        return n >= 4;
    }
}
