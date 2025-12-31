import java.util.*;
public class distinctElement {
    public static void main(String args[]) {
        int num[] = {4, 3, 2, 5, 6, 2, 3, 1, 4};

        HashSet<Integer> hs = new HashSet<>();
        for(int i = 0; i<num.length; i++) {
            hs.add(num[i]);
        }

        System.out.println("Number of distinct elements: " + hs.size());
    }
}
