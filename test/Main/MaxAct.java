import java.util.*;

public class MaxAct {
    public static void main(String args[]){
        int start[] = {1, 3, 0, 5, 8, 5};
        int end[] = {2, 4, 6, 7, 9, 9};   

        //end time basis sorted
        int maxAcc = 0;
        ArrayList<Integer> ans = new ArrayList<>();

        //1st activity
        maxAcc = 1;
        ans.add(0);
        int lastEnd = end[0];
        for(int i=1; i<end.length; i++){
            if(start[i] >= lastEnd){
                //activity select
                maxAcc++;
                ans.add(i);
                lastEnd = end[i];
            }
        }

        System.out.println("max activities = " + maxAcc);
        for(int i=0; i<ans.size(); i++){
            System.out.print("A"+ ans.get(i)+" ");
        }
        System.out.println();
    }
}