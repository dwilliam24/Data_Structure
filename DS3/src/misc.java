import java.util.*;

public class misc {
    public static void main(String[] args)
    {
        Map<String,Set> map= new TreeMap<String,Set>();
        Set<Integer> t = new HashSet<>();
        t.add(3);
        t.add(56);
        map.put("Z",t);
        map.put("Y",t);
        map.put("X",t);
        map.put("Y",t);

        Iterator it = map.values().iterator();

        while(it.hasNext())
            System.out.print(it.next() + " ");
    }
}
