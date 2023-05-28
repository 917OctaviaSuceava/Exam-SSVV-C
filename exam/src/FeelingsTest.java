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

        // Assert that the first occurrence of -1 is at index 0
        Assertions.assertEquals(0, result);
    }

    @Test
    public void testCheckNeighbours() {

        Feelings feelings = new Feelings(feelingsList);
        int[] result = feelings.checkNeighbours(5);

        // Assert that the left-side neighbour is 1 and the right-side neighbour is 1
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

        // Assert that the resulting array matches the expected array
        Assertions.assertEquals(expected, result);
    }
}
