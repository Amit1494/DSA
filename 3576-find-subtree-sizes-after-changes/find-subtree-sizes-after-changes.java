class Solution {
    
    HashMap<Integer,List<Integer>> hash=new HashMap<>();
    int []resultsize;
    int []last;
    
    void dfs(int currNode,String s,int []parent){
        int n=parent.length;
        int c=s.charAt(currNode)-'a';
        int nearestA=last[c];
        last[c]=currNode;
          for (int child : hash.getOrDefault(currNode, Collections.emptyList()))
            dfs(child, s, parent);
        
        last[c]=nearestA;
        if(currNode!=0){
            int newParent=parent[currNode];
            if(nearestA!=-1){
                newParent=nearestA;
            }
            parent[currNode]=newParent;
            resultsize[newParent]+=resultsize[currNode];
        }
    }
    public int[] findSubtreeSizes(int[] parent, String s) {
        int n=parent.length;
        for(int i=1;i<n;i++){
            int u=parent[i];
            int v=i;
            hash.computeIfAbsent(u,key->new ArrayList<>()).add(v);
        }
        resultsize=new int[n];
        Arrays.fill(resultsize,1);
        last=new int[26];
        Arrays.fill(last,-1);
        dfs(0,s,parent);
        return resultsize;

    }

}