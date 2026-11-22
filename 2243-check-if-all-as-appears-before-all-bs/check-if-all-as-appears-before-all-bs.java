class Solution {
    public boolean checkString(String s) {
        boolean res=true;
        for(char ch:s.toCharArray()){
            if(ch=='a'){
                if(res==false)return false;
            }
            else if(ch=='b')res=false;
            

        }return true;
    }
}