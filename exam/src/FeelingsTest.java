import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

public class FeelingsTest {
    private ArrayList<Integer> feelingsList;

    /*public FeelingsTest(ArrayList<Integer> feelingsList) {
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

        Feelings feelings = new Feelings(feelingsList);
        int result = feelings.findSadFeeling(0);

        Assertions.assertEquals(0, result);
    }

    @Test
    public void testCheckNeighbours() {

        Feelings feelings = new Feelings(feelingsList);
        int[] result = feelings.checkNeighbours(5);

        Assertions.assertArrayEquals(new int[]{1, -1}, result);
    }

    @Test
    public void testBeHappy() {

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
