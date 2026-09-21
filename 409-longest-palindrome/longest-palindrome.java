class Solution {
    public int longestPalindrome(String s) {
        HashMap<Character,Integer> hash=new HashMap<>();
        for(Character ch:s.toCharArray()){
            if(hash.containsKey(ch)){
                hash.put(ch,hash.get(ch)+1);
            }
            else{hash.put(ch,1);}
        }

        int res=0;
        boolean odd=false;
        for(int freq:hash.values()){
            if(freq%2==0) res+=freq;
            else {
                res+=freq-1;
                odd=true;
            }
        }
        if(odd==true){res++;}
        return res;

        
    }
}