package ru.bykov.leetcode.season_one.medium;

import java.util.Collections;
import java.util.List;
import java.util.Set;

public class task55_Jump_Game {

    private static final Set<String> REQUIRED_PHOTOS = Set.of(
            "PASSPORT_MAIN",
            "PASSPORT_REGISTRATION",
            "STS_FRONT",
            "STS_BACK"
    );

    private static final Set<String> userPhotos = Set.of(
            "PASSPORT_REGISTRATION",
            "STS_FRONT",
            "STS_BACK",
            "TEST_2"
    );

    public static void main(String[] args) {

        if (!userPhotos.containsAll(REQUIRED_PHOTOS)) {
            System.out.println("Tyt!");
        }

        Collections.sort(List.of("String"), Collections.reverseOrder());
//        Arrays.sort();

//        var task = new task55_Jump_Game();
//        System.out.println( "false: " + task.canJump(new int[] {0,2,3}) );
//        System.out.println( "true: " + task.canJump(new int[] {2,3,1,1,4}) );
//        System.out.println( "false: " + task.canJump(new int[] {3,2,1,0,4}) );
//        System.out.println( "true: " + task.canJump(new int[] {0}) );

    }

    public boolean canJump(int[] nums) {
        // Туалетный фикс :)
        int dp_i = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (dp_i == 0) return false;
            dp_i = Math.max(dp_i - 1, nums[i]);
        }

        return true;
    }
}
