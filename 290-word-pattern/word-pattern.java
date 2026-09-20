class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] tokens=s.split(" ");
        if(pattern.length()!=tokens.length){
            return false;
        }
        HashMap<Character,String> hash=new HashMap<>();
        for(int i=0;i<pattern.length();i++){
            if(!hash.containsKey(pattern.charAt(i))){
                hash.put(pattern.charAt(i),tokens[i]);
            }
            else if(hash.containsKey(pattern.charAt(i))){
                if(!hash.get(pattern.charAt(i)).equals(tokens[i])){
                    return false;
                }
            }
        }
        HashMap<String,Character> hash1=new HashMap<>();
        for(int i=0;i<pattern.length();i++){
            if(!hash1.containsKey(tokens[i])){
                hash1.put(tokens[i],pattern.charAt(i));
            }
            else if(hash1.containsKey(tokens[i])){
                if(!hash1.get(tokens[i]).equals(pattern.charAt(i))){
                    return false;
                }
            }
        }
        return true;
    }
}