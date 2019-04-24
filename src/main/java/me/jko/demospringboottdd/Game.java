package me.jko.demospringboottdd;

public class Game {

    private int[] nums;

    public Game(int... nums) {
        this.nums = nums;
    }

    public Score guess(int... g) {
        verifyLength(g);
        verifyRange(g);
        return new Score(balls(g), strikes(g));
    }

    private void verifyRange(int[] g) {
        if (g[0] < 0 || g[0] > 9 ||
                g[1] < 0 || g[1] > 9 ||
                g[2] < 0 || g[2] > 9) {
            throw new IllegalArgumentException();
        }
    }

    private void verifyLength(int[] g) {
        if (g.length != 3) {
            throw new IllegalArgumentException();
        }
    }

    private int strikes(int[] g) {
        int matchCnt = 0;
        if (nums[0] == g[0]) matchCnt++;
        if (nums[1] == g[1]) matchCnt++;
        if (nums[2] == g[2]) matchCnt++;
        return matchCnt;
    }

    private int balls(int[] g) {
        int ballCnt = 0;
        if (nums[0] == g[1] || nums[0] == g[2]) {
            ballCnt++;
        }
        if (nums[1] == g[0] || nums[1] == g[2]) {
            ballCnt++;
        }
        if (nums[2] == g[0] || nums[2] == g[1]) {
            ballCnt++;
        }
        return ballCnt;
    }
}
