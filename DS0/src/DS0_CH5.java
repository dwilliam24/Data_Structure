import java.util.ArrayList;

public class DS0_CH5 {
    public static void removeAllInRange(ArrayList<Integer> numbers, int lower, int upper)
    {
        for(int x=numbers.size()-1; x>=0; x--)
        {
            if (numbers.get(x)<=upper && numbers.get(x)>=lower) {
                numbers.remove(x);
            }
        }
    }
}
