import java.util.ArrayList;

import static java.lang.Math.abs;

public class DS0_CH6 {
    public static ArrayList<Integer> absoluteDifference(ArrayList<Integer> listA, ArrayList<Integer> listB) {
        ArrayList<Integer> numbers = new ArrayList<>();
        for(int x = 0; x<listA.size(); x++) {
            numbers.add(Math.abs(listA.get(x)-listB.get(x)));
        }
        return numbers;
    }
}
