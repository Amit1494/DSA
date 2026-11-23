class ProductOfNumbers {
     ArrayList<Long> list;
    

    public ProductOfNumbers() {
       list=new ArrayList<>();
       list.add(1L);

    }
    
    public void add(int num) {
       if(num==0)
       {
        list.clear();
        list.add(1L);
       return ;
       }
       long prefix=list.get(list.size()-1);
        list.add(prefix*num);
        
    }
    
    public int getProduct(int k) {
        int size=list.size();
        // int len=size-k;
        // int res=1;
        // for(int i=len;i<size;i++){
        //     res*=list.get(i);
        // }
        if(k>=list.size())return 0;
        long product=list.get(size-1)/list.get(size-k-1);
        return (int)product;
       
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */