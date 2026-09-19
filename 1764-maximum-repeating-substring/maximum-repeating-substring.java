class Solution {
    
    public int maxRepeating(String sequence, String word) {
        String tbf=word;
        int ans=0;
        while(sequence.contains(tbf)){
            tbf+=word;
            ans++;
        }
        return ans;
    }
    
}