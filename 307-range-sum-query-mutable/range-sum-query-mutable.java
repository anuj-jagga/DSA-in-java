class NumArray {
    int[] segTree;
    int n;
    void buildSegTree(int left,int right,int i, int[] nums, int[] segTree){
        if(left == right) {
            segTree[i] = nums[left];
            return;
        }

        int mid = (left + right)/2;

        buildSegTree(left,mid,2*i+1,nums,segTree);
        buildSegTree(mid+1,right,2*i+2,nums,segTree);

        segTree[i] = segTree[2*i + 1] + segTree[2*i + 2];
    }

    int sumRangeSegTree(int start, int end, int left, int right, int i, int[] segTree){
        if(left > end || right < start) return 0; // outofbound

        if(left >= start && right <= end){ // if both within range 
            return segTree[i];
        }

        // if either left or right in range of left and right then explore at left and right side
        int mid = (left + right) / 2;
        return sumRangeSegTree(start, end, left, mid, 2*i+1,segTree) + sumRangeSegTree(start, end, mid+1, right, 2*i+2, segTree);
    }

    void updateSegTree(int idx, int left, int right, int val, int i, int[] segTree){
        if(left == right){  
            segTree[i] = val;
            return;
        }

        int mid = (left+right)/2;

        if(idx <= mid){ // go left;
            updateSegTree(idx, left, mid, val, 2*i+1, segTree);
        }else{
            updateSegTree(idx, mid+1, right, val, 2*i+2, segTree);
        }

        segTree[i] = segTree[2*i+1] + segTree[2*i+2];
    }





    public NumArray(int[] nums) {
        n = nums.length;
        segTree = new int[4*n];
        buildSegTree(0, n-1, 0, nums, segTree);
    }
    
    public void update(int index, int val) {
        updateSegTree(index, 0,n-1,val, 0,segTree); 

        // here you dont need to update nums array Because the segment tree already is the data structure you’re maintaining.
    }
    
    public int sumRange(int left, int right) {
        return sumRangeSegTree(left,right,0, n-1, 0, segTree);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */