import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> feelingsList = new ArrayList<>() {
            {
                add(-1); add(-1); add(0); add(0); add(1); add(1); add(-1); add(1); add(0); add(-1); add(0); add(0);
                add(1); add(1); add(-1); add(0); add(1); add(1);
            }
        };
        Feelings feelings = new Feelings(feelingsList);
        //feelings.beHappy(feelingsList);
        System.out.println(feelings.beHappy(feelingsList));
    }
}