class Solution {
    public boolean sumGame(String num) {
        int leftq=0;
        int rightq=0;
        int lefts=0;
        int rights=0;
        int i=0;
        for(;i<num.length()/2;i++){
            if(num.charAt(i)>='0' && num.charAt(i)<='9'){
                lefts+=num.charAt(i)-'0';
            }
            else{
                leftq+=1;
            }
        }
        for(;i<num.length();i++){
           if(num.charAt(i)>='0' && num.charAt(i)<='9'){
                rights+=num.charAt(i)-'0';
            }
            else{
                rightq+=1;
            }
        }
        int diff=0;
        diff=lefts-rights;
        int diffq;
        diffq=leftq-rightq;
        if(diffq==0){
            if(diff==0){
                return false;
            }
            return true;
        }
        else{
           if (diffq == 0) {
    return diff != 0;
}

if (diffq % 2 != 0) {
    return true;
}

return diff != -9 * diffq / 2;

        }

        
        

    }
}