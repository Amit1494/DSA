class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Map<String, Boolean> memo = new HashMap<>();
        return helper(s,wordDict,memo);
    }
    public boolean helper(String s,List<String> wordDict,Map<String, Boolean> memo){
        if(memo.containsKey(s)){
            return memo.get(s);
        }
        if(s.length()==0){
            return true;
        }
        for(int i=0;i<wordDict.size();i++){
            if(s.startsWith(wordDict.get(i))){
                boolean res=helper(s.substring(wordDict.get(i).length(),s.length()),wordDict,memo);
                if(res==true){
                    memo.put(s,res);
                    return true;
                }
                
            }
        }
        memo.put(s,false);
        return false;
    }
}