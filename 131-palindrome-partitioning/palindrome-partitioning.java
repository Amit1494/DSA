class Solution {
    public List<List<String>> partition(String s) {
        List<String> partition=new ArrayList<>();
        List<List<String>> ans=new ArrayList<>();
        getAllParts(s,partition,ans);
        return ans;
    }
   public void getAllParts(String s,List<String> partition,List<List<String>> ans){
    if(s.length()==0)
    {
        ans.add(new ArrayList<>(partition));
        return ;
    }
    for(int i=0;i<s.length();i++){
        String part=s.substring(0,i+1);
        if(palindromecheck(part)){
            partition.add(part);
            getAllParts(s.substring(i+1),partition,ans);
            partition.remove(partition.size()-1);
        }
    }
   }
    public boolean palindromecheck(String s){
        int i=0;
        int j=s.length()-1;
        while(i<j){
            if (s.charAt(i) != s.charAt(j)) {
            return false;
        }
        i++;
        j--;
    }

    return true;
}
}