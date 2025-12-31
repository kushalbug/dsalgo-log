import java.util.*;
public class majorityElement {
    public static void main(String args []) {
        int arr[] = {2,2,1,1,1,2,2};
        HashMap<Integer, Integer> hm = new HashMap<>();

        for(int i=0; i<arr.length; i++) {
            if(hm.containsKey(arr[i])) {
                hm.put(arr[i], hm.get(arr[i]) + 1);
            } else {
                hm.put(arr[i], 1);
            }
        }

        
    }
}