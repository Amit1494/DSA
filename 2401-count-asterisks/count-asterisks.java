class Solution {
    public int countAsterisks(String s) {
        int count=0;
        boolean x=false;
        for(char ch:s.toCharArray()){
            if( !x &&ch=='*' ){
                count++;
            }
            else if(ch=='|'){
                x=!x;
            }
        }
        return count;
    }
}