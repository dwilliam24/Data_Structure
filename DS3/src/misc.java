import java.util.*;

public class misc {
    public static void main(String[] args)
    {
        Map<String,Integer> map= new TreeMap<String,Integer>();

        map.put("Z",2);
        map.put("Y",3);
        map.put("X",4);
        map.put("Y",1);

        Iterator<String> it = map.keySet().iterator();

        while(it.hasNext())
            System.out.print(it.next() + " ");
    }
}
