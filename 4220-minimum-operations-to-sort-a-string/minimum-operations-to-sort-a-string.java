class Solution {
    public int minOperations(String s) {
        int mini=s.charAt(0)-'a';
        int maxi=s.charAt(s.length()-1)-'a';
        for(char c:s.toCharArray()){
            mini=Math.min(mini,c-'a');
            maxi=Math.max(maxi,c-'a');
        }
        if(s.length()==1)return 0;
        if(s.length()==2)return s.charAt(0)<=s.charAt(1)?0:-1;
        int ans=0;
        int n=s.length();
        int minCount=0;
        int maxCount=0;
        for(char c:s.toCharArray()){
            if(c-'a'==mini)minCount++;

            if(c-'a'==maxi)maxCount++;
        }
        if(mini!=s.charAt(0)-'a')ans++;
        if(maxi!=s.charAt(n-1)-'a') ans++;

        if(ans==0){
            char[] arr=s.toCharArray();
            Arrays.sort(arr);
            String a=new String(arr);
            for(int i=1;i<n-1;i++){
                if(a.charAt(i)!=s.charAt(i)){return 1;}
            }
        }
    
    if(s.charAt(0)-'a'==maxi&&s.charAt(n-1)-'a'==mini){
        if(minCount==1 && maxCount==1){ans++;}
    }
    return ans;

}}