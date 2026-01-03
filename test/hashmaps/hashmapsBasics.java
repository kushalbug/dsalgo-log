import java.util.*;
import java.util.HashMap;
public class hashmapsBasics {
    public static void main(String args[]) {
        HashMap<String, Integer> hm = new HashMap<>();
        hm.put("India", 120);
        hm.put("US", 30);
        hm.put("China", 150);

        System.out.println(hm);
        int poplation = hm.get("India");
        System.out.println(poplation);

        // iterate through keys 
        Set<String> keys = hm.keySet();
        for (String k : keys) {
            System.out.println("Key: " + k + " Value: " + hm.get(k));
        }
        
        LinkedHashMap<String, Integer> lhm = new LinkedHashMap<>();

        lhm.put("India", 120);
        lhm.put("US", 30);  
        lhm.put("China", 150);

        System.out.println(lhm);
    }
}