class ProductOfNumbers {
     ArrayList<Integer> list;

    public ProductOfNumbers() {
       list=new ArrayList<>();

    }
    
    public void add(int num) {
        list.add(num);
    }
    
    public int getProduct(int k) {
        int size=list.size();
        int len=size-k;
        int res=1;
        for(int i=len;i<size;i++){
            res*=list.get(i);
        }
        return res;
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */