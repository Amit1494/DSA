/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node==null)return null;
        HashMap<Node,Node> res=new HashMap<>();

        return helper(node,res);
    }
    public Node helper(Node node,HashMap<Node,Node> res){

                Node newNode=new Node(node.val);
                res.put(node,newNode);

        for(Node neighbour:node.neighbors){
            if(!res.containsKey(neighbour)){
                newNode.neighbors.add(helper(neighbour,res));
            }
            else{
                newNode.neighbors.add(res.get(neighbour));
            }
        }
        return newNode;
    }
}