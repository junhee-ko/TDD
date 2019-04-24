package me.jko.demospringboottdd;


import org.junit.Test;

import static org.junit.Assert.*;

// 주의 사항
// test method : 하나의 독립적인 프로그램
// 독립적이기 때문에, 테스트 실행 순서가 영향을 주지 않아야함
// test method 안에 given 이 같이 있는게 좋아 ( 테스트 메서드 자체로 설명 하기 위해 )

public class GameTest {

    @Test
    public void create() {
        Game game = new Game(1, 3, 5);
    }

    @Test
    public void badParamCount() {
        Game game = new Game(1, 2, 3);

        try {
            game.guess(1, 2);
            fail();
        } catch (IllegalArgumentException ex) {

        }

        try {
            game.guess(1, 2, 3, 4);
            fail();
        } catch (IllegalArgumentException ex) {

        }
    }

    @Test
    public void badNumberRange() {
        Game game = new Game(1, 3, 5);

        try {
            game.guess(-1, 2, 3);
            fail();
        } catch (IllegalArgumentException ex) {

        }

        try {
            game.guess(10, 2, 3);
            fail();
        } catch (IllegalArgumentException ex) {

        }

        try {
            game.guess(1, -1, 3);
            fail();
        } catch (IllegalArgumentException ex) {

        }

        try {
            game.guess(1, 10, 3);
            fail();
        } catch (IllegalArgumentException ex) {

        }


        try {
            game.guess(1, 2, 10);
            fail();
        } catch (IllegalArgumentException ex) {

        }
    }

    @Test
    public void noMatch() {
        Game game = new Game(1, 3, 5);
        assertScore(game.guess(4, 4, 4), new Score(0, 0));
        assertScore(game.guess(6, 6, 6), new Score(0, 0));
    }

    @Test
    public void _1S() {

        Game game01 = new Game(1, 3, 5);
        assertScore(game01.guess(1, 4, 6), new Score(0, 1));

        Game game2 = new Game(9, 2, 3);
        assertScore(game2.guess(4, 2, 5), new Score(0, 1));
        assertScore(game2.guess(9, 1, 5), new Score(0, 1));
    }

    @Test
    public void _2S() {
        Game game = new Game(1, 2, 3);

        assertScore(game.guess(1, 2, 5), new Score(0, 2));
        assertScore(game.guess(1, 5, 3), new Score(0, 2));
        assertScore(game.guess(5, 2, 3), new Score(0, 2));
    }

    @Test
    public void _3S() {
        Game game = new Game(1, 2, 3);

        assertScore(game.guess(1, 2, 3), new Score(0, 3));
    }

    @Test
    public void _1B(){
        Game game = new Game(1, 2, 3);

        assertScore(game.guess(4, 1, 5), new Score(1, 0));
        assertScore(game.guess(4, 5, 1), new Score(1, 0));
        assertScore(game.guess(2, 5, 4), new Score(1, 0));
        assertScore(game.guess(4, 5, 2), new Score(1, 0));
        assertScore(game.guess(3, 5, 4), new Score(1, 0));
        assertScore(game.guess(4, 3, 5), new Score(1, 0));

    }

    @Test
    public  void _1B_1S(){
        Game game = new Game(1, 2, 3);

        assertScore(game.guess(1, 4, 2), new Score(1, 1));
        assertScore(game.guess(1, 3, 4), new Score(1, 1));
        assertScore(game.guess(3, 2, 4), new Score(1, 1));
        assertScore(game.guess(4, 2, 1), new Score(1, 1));
        assertScore(game.guess(4, 1, 3), new Score(1, 1));
        assertScore(game.guess(2, 4, 3), new Score(1, 1));
    }

    @Test
    public  void _2B(){
        Game game = new Game(1, 2, 3);

        assertScore(game.guess(4, 1, 2), new Score(2, 0));
    }

    private void assertScore(Score guess, Score score) {
        assertEquals(guess, score);
    }




}
