//day-25 of daily log

class Solution {
    public int findClosest(int x, int y, int z) {
        int temp1 , temp2 ;

        if(x < z){
            temp1 = z - x; 
        } else temp1 = x - z; 

        if(y < z){
            temp2 = z - y; 
        } else temp2 = y - z ;

        if(temp1 == temp2){
            return 0;
        }else if(temp1 > temp2){
            return 2;
        } else return 1;
    }
}