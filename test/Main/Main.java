import java.util.*;

public class Main {
    public static void main(String args[]){
        
        int start[] = {1, 3, 0, 5, 8, 5};
        int end[] = {2, 4, 6, 7, 9, 9};

        ArrayList<Integer> ans = new ArrayList<>();
        int maxAct = 1;
        ans.add(0);
        int lastEnd = end[0];

        for(int i=1 ; i<start.length; i++){
            if(start[i] >= lastEnd){
                ans.add(i);
                maxAct++;
                lastEnd = end[i];
            }
        }

        System.out.println("max activities = " + maxAct);
        for(int i = 0; i<ans.size(); i++){
            System.out.println("A" + ans.get(i));
        }
    }
}