import java.util.ArrayList;
import java.util.ListIterator;
import java.util.stream.IntStream;

public class Feelings {
    private ArrayList<Integer> feelings;

    public Feelings(ArrayList<Integer> f) {
        feelings = f;
    }

    public ArrayList<Integer> beHappy(ArrayList<Integer> feelingsList) {
        int i = 0;
        while (i < feelingsList.size()) {
            int pos = findSadFeeling(i);
            if (pos != -1) {
                int[] neighbours = checkNeighbours(pos);
                if (neighbours[0] != 1 && neighbours[1] != 1) { // no happy neighbours, insert on both sides
                    insertHappyFeelings(pos);
                    i = pos + 3;
                }
                else if (neighbours[0] == 1 && neighbours[1] != 1) { // happy neighbour on left side only, insert on right
                    insertHappyFeelingAfter(pos);
                    i = pos + 2;
                }
                else if (neighbours[0] != 1 && neighbours[1] == 1) {
                    insertHappyFeelingBefore(pos);
                    i = pos + 3; // happy neighbour on right side only, insert on left
                }
                else i = pos + 1; // both neighbours are happy, don't do anything, just go further in the array
            }
            else break; // break the loop if there are no more sad feelings in the array
        }
        return feelingsList;
    }

    public void insertHappyFeelings(int i) {

        if (i >= 0 && i < feelings.size()) { // insert on both sides
            feelings.add(i, 1);
            feelings.add(i + 2, 1);
        }
    }

    public void insertHappyFeelingBefore(int i) {
        if (i >= 0 && i < feelings.size()) { // insert on the left
            feelings.add(i, 1);
        }
    }

    public void insertHappyFeelingAfter(int i) {
        if (i >= 0 && i < feelings.size()) { // insert on the right
            feelings.add(i + 1, 1);
        }
    }

    public int findSadFeeling(int position) {
        return IntStream.range(position, feelings.size())
                .filter(i -> feelings.get(i) == -1)
                .findFirst()
                .orElse(-1);
    }

    public int[] checkNeighbours(int position) // return an array with the left-side neighbour and the right-side neighbour
    {
        int[] neighbours = {2,2};
        if(position != 0)
            neighbours[0] = feelings.get(position-1);
        if(position != feelings.size()-1)
            neighbours[1] = feelings.get(position+1);
        return neighbours;
    }

    public ArrayList<Integer> getFeelings() {
        return feelings;
    }

    @Override
    public String toString() {
        return "Feelings: " + feelings;
    }
}
