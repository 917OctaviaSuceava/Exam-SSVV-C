package test.java;

import main.java.Feelings;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.Array;
import java.util.ArrayList;

public class FeelingsTest {
    private ArrayList<Integer> feelingsList;

    /*public test.java.FeelingsTest(ArrayList<Integer> feelingsList) {
        this.feelingsList = feelingsList;
    }*/

    public FeelingsTest()
    {
        feelingsList = new ArrayList<>() {
            {
                add(-1); add(-1); add(0); add(0); add(1); add(1); add(-1); add(1); add(0); add(-1); add(0); add(0);
                add(1); add(1); add(-1); add(0); add(1); add(1);
            }
        };
    }

    @Test
    public void testFindSadFeeling() {
        this.feelingsList = new ArrayList<>() {
            {
                add(-1); add(0); add(1);
            }
        };
        Feelings feelings = new Feelings(this.feelingsList);
        int result = feelings.findSadFeeling(0);

        Assertions.assertEquals(0, result);
    }

    @Test
    public void testFindSadFeeling246Array() {
        this.feelingsList = new ArrayList<>() {
            {
                add(2); add(4); add(6);
            }
        };
        Feelings feelings = new Feelings(this.feelingsList);
        int result = feelings.findSadFeeling(0);

        Assertions.assertEquals(-1, result);
    }

    @Test
    public void testFindSadFeelingPosGreaterThanLength() {
        this.feelingsList = new ArrayList<>() {
            {
                add(-1); add(0);
            }
        };
        Feelings feelings = new Feelings(this.feelingsList);
        int result = feelings.findSadFeeling(3);

        Assertions.assertEquals(-1, result);
    }

    @Test
    public void testFindSadFeelingNegativePos() {
        this.feelingsList = new ArrayList<>() {
            {
                add(-1); add(0); add(1);
            }
        };
        Feelings feelings = new Feelings(this.feelingsList);
        try {
            int result = feelings.findSadFeeling(-4);
            assert(false);
        } catch (Exception err) {
            assert(true);
        }
    }

    @Test
    public void testCheckNeighboursFullCoverage() {
        this.feelingsList = new ArrayList<>() {
            {
                add(0); add(1); add(-1);
            }
        };
        Feelings feelings = new Feelings(this.feelingsList);
        var result = feelings.checkNeighbours(1);
        Assertions.assertArrayEquals(new int[]{0, -1}, result);
    }

    @Test
    public void testCheckNeighboursArrayWithLength1() {
        this.feelingsList = new ArrayList<>() {
            {
                add(0);
            }
        };
        Feelings feelings = new Feelings(this.feelingsList);
        var result = feelings.checkNeighbours(0);
        Assertions.assertArrayEquals(new int[]{2, 2}, result);
    }

    @Test
    public void testCheckNeighboursOnlyLeftNeighbour() {
        this.feelingsList = new ArrayList<>() {
            {
                add(0); add(1);
            }
        };
        Feelings feelings = new Feelings(this.feelingsList);
        var result = feelings.checkNeighbours(1);
        Assertions.assertArrayEquals(new int[]{0, 2}, result);
    }

    @Test
    public void testCheckNeighboursOnlyRightNeighbour() {
        this.feelingsList = new ArrayList<>() {
            {
                add(0); add(1);
            }
        };
        Feelings feelings = new Feelings(this.feelingsList);
        var result = feelings.checkNeighbours(0);
        Assertions.assertArrayEquals(new int[]{2, 1}, result);
    }

    //integration testing for the beHappy method

    @Test
    public void testBeHappyWithNoSadFeelingsArray(){

        var arr = new ArrayList<Integer>(){{
            add(0);add(1);add(0);add(1);
        }};

        Feelings feelings = new Feelings(arr);

        var result = feelings.beHappy(arr);

        Assertions.assertEquals(arr, result);

    }

    @Test
    public void testBeHappyWithOneSadFeelingsArray(){

        var arr = new ArrayList<Integer>(){{
            add(0);add(1);add(1);add(0);add(-1);add(1);
        }};

        Feelings feelings = new Feelings(arr);

        var result = feelings.beHappy(arr);

        var expected = new ArrayList<Integer>(){{
            add(0);add(1);add(1);add(0);add(1);add(-1);add(1);
        }};

        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testBeHappyWithSadFeelingsAtEndsArray(){

        var arr = new ArrayList<Integer>(){{
            add(-1);add(1);add(1);add(0);add(0);add(-1);
        }};

        Feelings feelings = new Feelings(arr);

        var result = feelings.beHappy(arr);

        var expected = new ArrayList<Integer>(){{
            add(1);add(-1);add(1);add(1);add(0);add(0);add(1);add(-1);add(1);
        }};
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testBeHappyWithEmptyArray(){

        var arr = new ArrayList<Integer>();

        Feelings feelings = new Feelings(arr);

        var result = feelings.beHappy(arr);

        var expected = new ArrayList<Integer>();

        Assertions.assertEquals(expected, result);
    }


    @Test
    public void testBeHappyWithAlternatingSadFeelings() {

        Feelings feelings = new Feelings(feelingsList);
        ArrayList<Integer> result = feelings.beHappy(feelingsList);

        ArrayList<Integer> expected = new ArrayList<>() {
            {
                add(1); add(-1); add(1); add(-1); add(1); add(0); add(0); add(1); add(1); add(-1); add(1); add(0);
                add(1); add(-1); add(1); add(0); add(0); add(1); add(1); add(-1); add(1); add(0); add(1); add(1);
            }
        };

        Assertions.assertEquals(expected, result);
    }
}
